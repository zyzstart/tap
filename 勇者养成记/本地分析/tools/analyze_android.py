#!/usr/bin/env python3
"""Offline Android-only APK analysis. Reads unpacked/APK; writes only derived/android and one report.
No APK execution, network requests, dependency installation, Unity asset or IL2CPP parsing.
"""
from __future__ import annotations
import argparse
import configparser
import csv
import hashlib
import io
import json
import logging
import os
from pathlib import Path
import re
import struct
import subprocess
import sys
import time
import urllib.parse
import zipfile
from collections import Counter

ROOT = Path(__file__).resolve().parents[2]
BASE = ROOT / '本地分析'
SRC = BASE / 'unpacked'
OUT = BASE / 'derived' / 'android'
REPORT = BASE / 'reports' / 'Android层分析.md'
PACKAGES = BASE / 'tools' / 'python-packages'
sys.dont_write_bytecode = True
sys.path.insert(0, str(PACKAGES))
ANDROID = '{http://schemas.android.com/apk/res/android}'
SECRET_KEY = re.compile(r'(secret|token|password|passwd|credential|app.?key|private.?key|access.?key|session.?key|api.?key|qqkey|wxkey)', re.I)
ERRORS = []
SDK_PREFIXES = {
    'Unity': ('com.unity3d.',),
    '腾讯 YSDK': ('com.tencent.ysdk.',),
    '腾讯 Midas': ('com.tencent.midas.', 'com.pay.'),
    '腾讯 QQ/OpenSDK': ('com.tencent.tauth.', 'com.tencent.connect.', 'com.tencent.open.'),
    '微信 OpenSDK': ('com.tencent.mm.opensdk.', 'com.tencent.mm.sdk.'),
    '腾讯 Bugly': ('com.tencent.bugly.',),
    '腾讯 Beacon': ('com.tencent.beacon.',),
    '腾讯 GCloud/XT': ('com.tencent.gcloud.', 'com.tencent.tp.', 'com.tencent.tpshell.'),
    '腾讯 GDT': ('com.qq.e.',),
    '腾讯 TBS/X5': ('com.tencent.smtt.',),
    '腾讯 Turing/设备风控': ('com.tencent.turingfd.', 'com.tencent.ydkqmsp.'),
    '云知声 Unisound': ('com.unisound.',),
    'DMLT Tracking': ('com.dmlt.tracking.',),
    '移动安全联盟 MSA/OAID': ('com.bun.', 'com.asus.msa.', 'com.zui.deviceidservice.', 'com.samsung.android.deviceidservice.'),
    'Dodjoy 桥接': ('com.dodjoy.', 'com.dod.'),
}

def write_json(name, data):
    p = OUT / name
    p.parent.mkdir(parents=True, exist_ok=True)
    p.write_text(json.dumps(data, ensure_ascii=False, indent=2), encoding='utf-8')
    return p

def write_csv(name, rows, columns):
    p = OUT / name
    p.parent.mkdir(parents=True, exist_ok=True)
    with p.open('w', encoding='utf-8-sig', newline='') as f:
        w = csv.DictWriter(f, fieldnames=columns, extrasaction='ignore')
        w.writeheader()
        for row in rows:
            w.writerow({k: json.dumps(v, ensure_ascii=False) if isinstance(v, (dict, list)) else v for k, v in row.items()})

def sha(data):
    return hashlib.sha256(data).hexdigest()

def rel(path):
    return Path(path).relative_to(ROOT).as_posix()

def err(stage, ex):
    item = {'stage': stage, 'type': type(ex).__name__, 'message': str(ex)[:1200]}
    ERRORS.append(item)
    print(json.dumps(item, ensure_ascii=False))

def clean_url(value):
    try:
        u = urllib.parse.urlsplit(str(value))
        if u.scheme in ('http', 'https') and u.netloc:
            host = u.hostname or ''
            if u.port:
                host += ':' + str(u.port)
            # Userinfo, query and fragment never retained.
            return urllib.parse.urlunsplit((u.scheme, host, u.path, '[REDACTED]' if u.query else '', ''))
    except ValueError:
        pass
    return str(value)

def safe_value(key, value):
    if SECRET_KEY.search(str(key)):
        return '[REDACTED]'
    if isinstance(value, dict):
        return {k: safe_value(k, v) for k, v in value.items()}
    if isinstance(value, list):
        return [safe_value(key, v) for v in value]
    if isinstance(value, str) and value.startswith(('http://', 'https://')):
        return clean_url(value)
    return value

def configs():
    rows, details = [], []
    for p in sorted((SRC / 'assets').glob('Config*.bytes')):
        raw = p.read_bytes()
        try:
            text = raw.decode('utf-8-sig')
            strict_json, parse_note = True, None
            try:
                data = json.loads(text)
            except json.JSONDecodeError as ex:
                strict_json, parse_note = False, str(ex)
                err('config_strict_json:' + rel(p), ex)
                # One packaged config has a trailing comma. Derived parse only; original unchanged.
                data = json.loads(re.sub(r',\s*([}\]])', r'\1', text))
            safe = {k: safe_value(k, v) for k, v in data.items()}
            url = str(data.get('verurl', ''))
            u = urllib.parse.urlsplit(url)
            row = {'file': rel(p), 'sha256': sha(raw), 'channel': data.get('channel'), 'version': str(data.get('version', '')), 'version_url': clean_url(url), 'scheme': u.scheme, 'host': u.hostname, 'bugly_debug': data.get('bugly_debug'), 'disable_bugly': data.get('disable_bugly'), 'hide_fps': data.get('hide_fps'), 'stage': data.get('stage'), 'enable_guide': data.get('enable_guide'), 'selected_at_runtime': 'NOT_DETERMINED'}
            rows.append(row)
            details.append({'file': rel(p), 'sha256': sha(raw), 'strict_json': strict_json, 'parse_note': parse_note, 'derived_trailing_comma_normalization': not strict_json, 'values': safe})
        except Exception as ex:
            err('config:' + rel(p), ex)
    supplemental = []
    for name in ('SdkCfg.bytes', 'PrivacyConfig.json', 'supplierconfig.json', 'ysdkconf.ini', 'ysdkinfo.ini', 'com.tencent.open.config.json'):
        p = SRC / 'assets' / name
        if not p.exists():
            continue
        text = p.read_text(encoding='utf-8-sig', errors='replace')
        result = {'file': rel(p), 'sha256': sha(p.read_bytes())}
        if name.endswith(('.json', '.bytes')):
            try:
                obj = json.loads(text)
                result['strict_json'] = True
            except json.JSONDecodeError as ex:
                result['strict_json'] = False
                result['strict_json_error'] = str(ex)
                # PrivacyConfig has literal line breaks within a quoted string; do not alter source.
                try:
                    obj = json.loads(text, strict=False)
                    result['lenient_json'] = True
                except Exception:
                    obj = None
            if isinstance(obj, dict):
                result['values'] = {k: safe_value(k, v) for k, v in obj.items()}
        else:
            sections, current = {}, '_root'
            for line in text.splitlines():
                line = line.strip()
                if not line or line.startswith(('#', ';', '//')):
                    continue
                if line.startswith('[') and line.endswith(']'):
                    current = line[1:-1]
                elif '=' in line:
                    k, v = line.split('=', 1)
                    sections.setdefault(current, {})[k.strip()] = safe_value(k, v.strip())
            result['sections'] = sections
        supplemental.append(result)
    summary = {'count': len(rows), 'by_scheme': dict(Counter(r['scheme'] for r in rows)), 'distinct_channels': len(set(r['channel'] for r in rows)), 'selection_warning': 'All files are packaged candidates. Presence/channel naming does not establish runtime selection. Config.bytes dev defaults are NOT assumed production.', 'configs': rows}
    write_json('channel_configs.json', summary)
    write_json('channel_config_values.redacted.json', details)
    write_json('supplemental_configs.redacted.json', supplemental)
    write_csv('channel_configs.csv', rows, list(rows[0]) if rows else ['file'])
    return summary, supplemental

def dex_analysis():
    """DEX header, MUTF-8 strings and class definitions only, no bytecode execution."""
    all_classes, all_methods, summaries, sdk = [], [], [], []
    interesting = re.compile(r'UnityPlayer|YSDK|Midas|Bugly|Dod|MainActivity|Launcher|Tinker|DexClassLoader|CheckVer|check_ver|Config.*bytes|Config_(?:hardtime|web_wx)|LoadConfig|loadConfig|ysdkconf', re.I)
    hits, rejected = [], []
    for p in sorted(SRC.rglob('*.dex')):
        data = p.read_bytes()
        if not data.startswith(b'dex\n'):
            rejected.append({'file': rel(p), 'size': len(data), 'sha256': sha(data), 'first_16_bytes_hex': data[:16].hex(), 'status': 'NONSTANDARD_HEADER_NOT_PARSED', 'interpretation': 'Extension alone does not prove DEX/encryption/packing; no speculative decoding or execution.'})
            err('dex:' + rel(p), ValueError('Not a standard DEX; no speculative decoding attempted'))
            continue
        header = struct.unpack_from('<20I', data, 32)
        # file_size, header_size, endian_tag, link_size/off, map_off, strings size/off, types size/off, proto size/off, fields size/off, methods size/off, classes size/off, data size/off
        file_size, header_size, endian = header[:3]
        ns, so, nt, to, np, po, nf, fo, nm, mo, nc, co = header[6:18]
        strings = []
        for i in range(ns):
            pos = struct.unpack_from('<I', data, so + 4 * i)[0]
            while data[pos] & 128:
                pos += 1
            pos += 1
            end = data.index(0, pos)
            strings.append(data[pos:end].decode('utf-8', errors='replace').replace('\xc0\x80', '\0'))
        types = [strings[struct.unpack_from('<I', data, to + i * 4)[0]] for i in range(nt)]
        convert = lambda s: s[1:-1].replace('/', '.') if s.startswith('L') else s
        classes = []
        for i in range(nc):
            vals = struct.unpack_from('<8I', data, co + i * 32)
            cls = convert(types[vals[0]])
            superclass = convert(types[vals[2]]) if vals[2] != 0xffffffff else None
            source = strings[vals[4]] if vals[4] != 0xffffffff else None
            item = {'dex': rel(p), 'class': cls, 'superclass': superclass, 'access_flags': hex(vals[1]), 'source_file': source, 'package': cls.rsplit('.', 1)[0] if '.' in cls else ''}
            classes.append(item)
            all_classes.append(item)
        # method_ids counts definitions and referenced methods; report explicitly as IDs, not definitions.
        for i in range(nm):
            class_idx, proto_idx, name_idx = struct.unpack_from('<HHI', data, mo + i * 8)
            cls, name = convert(types[class_idx]), strings[name_idx]
            if interesting.search(cls + '.' + name):
                all_methods.append({'dex': rel(p), 'class': cls, 'method': name, 'proto_index': proto_idx})
        package_counts = Counter(x['package'] for x in classes)
        summary = {'file': rel(p), 'size': len(data), 'sha256': sha(data), 'magic': data[:8].decode('ascii', errors='replace'), 'header_file_size': file_size, 'header_size': header_size, 'endian_tag': hex(endian), 'string_ids': ns, 'type_ids': nt, 'proto_ids': np, 'field_ids': nf, 'method_ids_including_references': nm, 'defined_classes': nc, 'exact_package_count': len(package_counts), 'top_packages': package_counts.most_common(30)}
        summaries.append(summary)
        for s in strings:
            if len(s) < 280 and interesting.search(s) and not SECRET_KEY.search(s) and not s.startswith(('http://', 'https://')):
                hits.append({'dex': rel(p), 'string': s})
    for name, prefixes in SDK_PREFIXES.items():
        matches = [x for x in all_classes if x['class'].startswith(prefixes)]
        sdk.append({'sdk': name, 'class_count': len(matches), 'prefixes': list(prefixes), 'examples': [x['class'] for x in matches[:12]], 'evidence_dex': sorted(set(x['dex'] for x in matches)), 'runtime_status': 'PACKAGED_ONLY_NOT_PROVEN_ACTIVE'})
    packages = Counter((x['dex'], x['package']) for x in all_classes)
    write_json('nonstandard_dex_candidates.json', rejected)
    write_json('dex_summary.json', {'dex': summaries, 'unparsed_candidates': rejected, 'total_defined_classes': len(all_classes), 'total_exact_packages_across_dex': len(set(x['package'] for x in all_classes)), 'limitations': 'Header method_ids include references, not only method bodies. Class inventory does not prove SDK invocation. Auxiliary asset DEX is not presumed auto-loaded.'})
    write_csv('dex_classes.csv', all_classes, ['dex', 'class', 'superclass', 'access_flags', 'source_file', 'package'])
    write_csv('dex_packages.csv', [{'dex': d, 'package': p, 'defined_classes': n} for (d, p), n in packages.most_common()], ['dex', 'package', 'defined_classes'])
    write_csv('key_method_ids.csv', all_methods, ['dex', 'class', 'method', 'proto_index'])
    write_json('key_dex_strings.json', hits)
    write_json('sdk_evidence.json', sdk)
    return summaries, all_classes, sdk

def decode_axml(data):
    from androguard.core.axml import AXMLPrinter
    from lxml import etree
    if data.lstrip().startswith(b'<'):
        return etree.fromstring(data)
    printer = AXMLPrinter(data)
    root = printer.get_xml_obj()
    if root is None:
        raise ValueError('AXML decoder returned no document')
    return root

def manifest_analysis():
    from lxml import etree
    root = decode_axml((SRC / 'AndroidManifest.xml').read_bytes())
    a = lambda node, key, default=None: node.get(ANDROID + key, default)
    app = root.find('application')
    uses = root.find('uses-sdk')
    package = root.get('package')
    def qname(name):
        if not name:
            return None
        return package + name if name.startswith('.') else package + '.' + name if '.' not in name else name
    sdk = {k: a(uses, k) for k in ('minSdkVersion', 'targetSdkVersion', 'maxSdkVersion')} if uses is not None else {}
    components = []
    for node in app:
        if node.tag not in ('activity', 'activity-alias', 'service', 'receiver', 'provider'):
            continue
        filters = []
        for f in node.findall('intent-filter'):
            filters.append({'actions': [a(x, 'name') for x in f.findall('action')], 'categories': [a(x, 'name') for x in f.findall('category')], 'data': [{k.split('}')[-1]: safe_value(k, v) for k, v in x.attrib.items()} for x in f.findall('data')]})
        explicit = a(node, 'exported')
        if explicit is not None:
            effective, why = explicit.lower() == 'true', 'explicit_manifest'
        elif node.tag == 'provider':
            effective = int(sdk.get('targetSdkVersion') or 1) <= 16
            why = 'legacy_provider_default_by_target_sdk'
        else:
            effective, why = bool(filters), 'legacy_intent_filter_default'
        meta = [{k.split('}')[-1]: v for k, v in m.attrib.items()} for m in node.findall('meta-data')]
        for m in meta:
            if 'value' in m:
                m['value'] = safe_value(m.get('name', ''), m['value'])
        components.append({'type': node.tag, 'name': qname(a(node, 'name')), 'exported_declared': explicit, 'exported_effective_legacy': effective, 'exported_basis': why, 'enabled_declared': a(node, 'enabled'), 'permission': a(node, 'permission'), 'readPermission': a(node, 'readPermission'), 'writePermission': a(node, 'writePermission'), 'authorities': a(node, 'authorities'), 'targetActivity': qname(a(node, 'targetActivity')), 'process': a(node, 'process'), 'launchMode': a(node, 'launchMode'), 'grantUriPermissions': a(node, 'grantUriPermissions'), 'intent_filters': filters, 'metadata': meta})
    permissions = [{'name': a(n, 'name'), 'maxSdkVersion': a(n, 'maxSdkVersion'), 'tag': n.tag, 'usesPermissionFlags': a(n, 'usesPermissionFlags')} for n in root if n.tag.startswith('uses-permission')]
    defined = [{k.split('}')[-1]: v for k, v in n.attrib.items()} for n in root.findall('permission')]
    launchers = [c['name'] for c in components if any('android.intent.action.MAIN' in f['actions'] and 'android.intent.category.LAUNCHER' in f['categories'] for f in c['intent_filters'])]
    result = {'package': package, 'versionName': a(root, 'versionName'), 'versionCode': a(root, 'versionCode'), 'compileSdkVersion': a(root, 'compileSdkVersion'), 'sdk': sdk, 'application': {k.split('}')[-1]: safe_value(k, v) for k, v in app.attrib.items()}, 'launchers': launchers, 'permissions': permissions, 'defined_permissions': defined, 'components': components, 'network_policy': {'usesCleartextTraffic_declared': a(app, 'usesCleartextTraffic'), 'networkSecurityConfig_ref': a(app, 'networkSecurityConfig'), 'networkSecurityConfig_xml_present': [], 'interpretation': 'Declared flags only; no traffic was sent. targetSdk >=28 defaults cleartext off unless explicitly overridden. Missing per-domain config does not prove requests execute.'}}
    result['application_metadata'] = [{k.split('}')[-1]: safe_value(a(n, 'name', '') if k.split('}')[-1] == 'value' else k, v) for k, v in n.attrib.items()} for n in app.findall('meta-data')]
    for n in root.findall('.//meta-data'):
        k = a(n, 'name', '')
        if SECRET_KEY.search(k):
            if ANDROID + 'value' in n.attrib:
                n.set(ANDROID + 'value', '[REDACTED]')
    (OUT / 'AndroidManifest.decoded.redacted.xml').write_bytes(etree.tostring(root, encoding='utf-8', xml_declaration=True, pretty_print=True))
    for p in sorted((SRC / 'res' / 'xml').glob('*.xml')):
        try:
            rr = decode_axml(p.read_bytes())
            name = p.name.replace('.xml', '.decoded.xml')
            (OUT / name).write_bytes(etree.tostring(rr, encoding='utf-8', xml_declaration=True, pretty_print=True))
            if rr.tag == 'network-security-config':
                result['network_policy']['networkSecurityConfig_xml_present'].append(rel(p))
        except Exception as ex:
            err('resource_xml:' + rel(p), ex)
    write_json('manifest_summary.json', result)
    write_csv('manifest_components.csv', components, ['type', 'name', 'exported_declared', 'exported_effective_legacy', 'exported_basis', 'enabled_declared', 'permission', 'readPermission', 'writePermission', 'authorities', 'targetActivity', 'process', 'launchMode', 'grantUriPermissions', 'intent_filters', 'metadata'])
    write_csv('manifest_permissions.csv', permissions, ['name', 'maxSdkVersion', 'tag', 'usesPermissionFlags'])
    return result

def lp_sequence(data):
    pos = 0
    while pos < len(data):
        if pos + 4 > len(data):
            raise ValueError('Truncated length-prefixed signing field')
        n = struct.unpack_from('<I', data, pos)[0]
        pos += 4
        if pos + n > len(data):
            raise ValueError('Signing field length out of bounds')
        yield data[pos:pos+n]
        pos += n

def certificates(apk):
    from asn1crypto import cms, x509
    certs = []
    schemes = []
    def add(raw, source):
        cert = x509.Certificate.load(raw)
        certs.append({'source': source, 'subject': cert.subject.human_friendly, 'issuer': cert.issuer.human_friendly, 'serial_number_hex': hex(cert.serial_number), 'not_before': cert['tbs_certificate']['validity']['not_before'].native.isoformat(), 'not_after': cert['tbs_certificate']['validity']['not_after'].native.isoformat(), 'sha256': sha(raw), 'sha1': hashlib.sha1(raw).hexdigest(), 'md5': hashlib.md5(raw).hexdigest(), 'signature_algorithm': cert['signature_algorithm']['algorithm'].native, 'public_key_algorithm': cert.public_key.algorithm})
    for p in sorted((SRC / 'META-INF').glob('*')):
        if p.suffix.upper() in ('.RSA', '.DSA', '.EC'):
            try:
                info = cms.ContentInfo.load(p.read_bytes())
                for choice in info['content']['certificates']:
                    if choice.name == 'certificate':
                        add(choice.chosen.dump(), rel(p))
                schemes.append('v1 certificate container present')
            except Exception as ex:
                err('cert_v1:' + rel(p), ex)
    if apk:
        try:
            with apk.open('rb') as f:
                f.seek(0, 2)
                size = f.tell()
                f.seek(max(0, size - 65557))
                tail = f.read()
                eocd = tail.rfind(b'PK\x05\x06')
                if eocd < 0:
                    raise ValueError('ZIP EOCD not found')
                cd_offset = struct.unpack_from('<I', tail, eocd + 16)[0]
                f.seek(cd_offset - 24)
                footer = f.read(24)
                if footer[8:] == b'APK Sig Block 42':
                    n = struct.unpack_from('<Q', footer, 0)[0]
                    f.seek(cd_offset - n - 8)
                    block = f.read(n + 8)
                    if struct.unpack_from('<Q', block, 0)[0] != n:
                        raise ValueError('APK signing block size mismatch')
                    pos = 8
                    ids = {0x7109871a: 'v2', 0xf05368c0: 'v3', 0x1b93ad61: 'v3.1'}
                    while pos < len(block) - 24:
                        plen = struct.unpack_from('<Q', block, pos)[0]
                        ident = struct.unpack_from('<I', block, pos + 8)[0]
                        value = block[pos+12:pos+8+plen]
                        if ident in ids:
                            scheme = ids[ident]
                            schemes.append(scheme + ' signing block present')
                            # value: length-prefixed sequence of signers; signer begins signed-data.
                            for signers in lp_sequence(value):
                                for signer in lp_sequence(signers):
                                    signed_data = next(lp_sequence(signer))
                                    fields = list(lp_sequence(signed_data)) if scheme == 'v2' else None
                                    if fields is None:
                                        # v3 signed_data has uint32 SDK bounds after certificates; parse first two LP fields only.
                                        iterator = lp_sequence(signed_data)
                                        next(iterator)
                                        certseq = next(iterator)
                                    else:
                                        certseq = fields[1]
                                    for der in lp_sequence(certseq):
                                        add(der, rel(apk) + ':APK-signing-block:' + scheme)
                        pos += 8 + plen
                else:
                    schemes.append('No APK Signing Block immediately before central directory')
        except Exception as ex:
            err('apk_signing_block', ex)
    result = {'schemes_presence': sorted(set(schemes)), 'certificates': certs, 'unique_certificate_sha256': sorted(set(c['sha256'] for c in certs)), 'verification': 'Certificate extraction/digests only; JAR entry signatures, APK v2/v3 signatures and trust chain were NOT cryptographically verified. Signature presence is not signature validity.'}
    write_json('certificates.json', result)
    return result

def archives():
    rows = []
    for name in ('MidasPay.zip', 'ysdk_hackdex.jar'):
        p = SRC / 'assets' / name
        if not p.exists():
            continue
        try:
            with zipfile.ZipFile(p) as z:
                for item in z.infolist():
                    rows.append({'archive': rel(p), 'member': item.filename, 'size': item.file_size, 'compressed_size': item.compress_size, 'crc32': format(item.CRC, '08x')})
        except Exception as ex:
            err('archive:' + rel(p), ex)
    write_csv('sdk_archive_members.csv', rows, ['archive', 'member', 'size', 'compressed_size', 'crc32'])
    return rows

def jadx_analysis(classes, manifest, java):
    jars = sorted((BASE / 'tools' / 'jadx' / 'lib').glob('jadx-*-all.jar'))
    if not jars:
        jars = sorted((BASE / 'tools' / 'jadx').rglob('jadx-*-all.jar'))
    result = {'attempted': False, 'status': 'not_available', 'items': [], 'limitations': 'Decompiler output is a static approximation, not source-authoritative. No APK execution.'}
    if not jars or not java.exists():
        result['reason'] = 'jadx distribution or requested JDK unavailable; DEX structural parsing retained.'
        write_json('jadx_status.json', result)
        return result
    out = OUT / 'jadx'
    out.mkdir(exist_ok=True)
    tmp = OUT / 'java-tmp'
    tmp.mkdir(exist_ok=True)
    env = dict(os.environ)
    env.update({'TMP': str(tmp), 'TEMP': str(tmp), 'JADX_TMP_DIR': str(tmp), 'JADX_CONFIG_DIR': str(OUT / 'jadx-config'), 'JADX_CACHE_DIR': str(OUT / 'jadx-cache')})
    wanted = list(manifest.get('launchers', [])) + [
        'com.dodjoy.unityplayer.DodUnityPlayerActivity',
        'com.dodjoy.thirdPlatform.ThirdPlatform',
        'com.dodjoy.dodlib.DodLibConfig',
        'com.dodjoy.dodlib.DodLibMeta',
        'com.dodjoy.dodlib.DodLib',
        'com.dodjoy.platform.PlatformInterface',
        'com.dodjoy.utils.DodSdkEngine',
        'com.dodjoy.platform.PlatformConfig',
        'com.dodjoy.thirdPlatform.ThirdPlatformFactory',
        'com.dodjoy.privacy.DodPrivacyHelper',
        'com.dodjoy.thirdPlatform.DodYSDKLoginActivity',
        'com.tencent.ysdk.api.YSDKApi',
        'com.tencent.midas.api.APMidasPayAPI',
        'com.unity3d.player.UnityPlayerActivity']
    wanted = list(dict.fromkeys(wanted))[:16]
    previous = {}
    old_status = OUT / 'jadx_status.json'
    if old_status.exists():
        previous = {i['class']: i for i in json.loads(old_status.read_text(encoding='utf-8')).get('items', [])}
    result.update({'attempted': True, 'status': 'completed', 'jar': rel(jars[0]), 'selected_classes': wanted})
    for cls in wanted:
        inputs = sorted(set(ROOT / x['dex'] for x in classes if x['class'] == cls))
        if not inputs:
            continue
        safe_name = cls.replace('.', '_')
        dest = out / (safe_name + '.java')
        log = out / (safe_name + '.log')
        if cls in previous and previous[cls].get('exit_code') == 0 and dest.exists():
            result['items'].append(dict(previous[cls], reused_existing_offline_result=True))
            continue
        command = [str(java), '-Xmx2G', '-Duser.home=' + str(OUT / 'java-home'), '-Djava.io.tmpdir=' + str(tmp), '-cp', str(jars[0]), 'jadx.cli.JadxCLI', '--config', 'none', '--deobf-cfg-file-mode', 'ignore', '--single-class', cls, '--single-class-output', str(dest), '--no-res', '--no-imports', '--no-debug-info', '-j', '2'] + [str(p) for p in inputs]
        start = time.monotonic()
        try:
            with log.open('w', encoding='utf-8') as f:
                run = subprocess.run(command, stdout=f, stderr=subprocess.STDOUT, env=env, timeout=150, cwd=OUT)
            item = {'class': cls, 'exit_code': run.returncode, 'seconds': round(time.monotonic() - start, 2), 'output': rel(dest) if dest.exists() else None, 'log': rel(log)}
            if run.returncode:
                item['status'] = 'decompilation_nonzero_retained_for_review'
        except Exception as ex:
            item = {'class': cls, 'error': str(ex), 'log': rel(log)}
            result['status'] = 'partial_failure'
        # Do not publish embedded credential constants from decompilation.
        if dest.exists():
            text = dest.read_text(encoding='utf-8', errors='replace')
            redacted = []
            for line in text.splitlines():
                if SECRET_KEY.search(line):
                    line = re.sub(r'"(?:[^"\\]|\\.)*"', '"[REDACTED]"', line)
                line = re.sub(r'https?://[^\s"<>]+', lambda m: clean_url(m.group(0)), line)
                redacted.append(line)
            dest.write_text('\n'.join(redacted) + '\n', encoding='utf-8')
        result['items'].append(item)
    write_json('jadx_status.json', result)
    return result

def jadx_full_analysis(java):
    result = {'attempted': True, 'status': 'not_available', 'input': rel(SRC / 'classes.dex'), 'output_directory': rel(OUT / 'jadx-full'), 'log': rel(OUT / 'jadx_full.log')}
    jars = sorted((BASE / 'tools' / 'jadx' / 'lib').glob('jadx-*-all.jar'))
    if not jars or not java.exists():
        result['reason'] = 'Local jadx/JDK unavailable; no downloads attempted.'
        write_json('jadx_full_status.json', result)
        return result
    tmp = OUT / 'java-tmp'
    tmp.mkdir(exist_ok=True)
    env = dict(os.environ)
    env.update({'TMP': str(tmp), 'TEMP': str(tmp), 'JADX_TMP_DIR': str(tmp), 'JADX_CONFIG_DIR': str(OUT / 'jadx-config'), 'JADX_CACHE_DIR': str(OUT / 'jadx-cache')})
    command = [str(java), '-Xmx2G', '-Dfile.encoding=UTF-8', '-Duser.home=' + str(OUT / 'java-home'), '-Djava.io.tmpdir=' + str(tmp), '-cp', str(jars[0]), 'jadx.cli.JadxCLI', '--config', 'none', '--deobf-cfg-file-mode', 'ignore', '--no-res', '--no-imports', '--no-debug-info', '-j', '3', '-d', str(OUT / 'jadx-full'), str(SRC / 'classes.dex')]
    start = time.monotonic()
    try:
        with (OUT / 'jadx_full.log').open('w', encoding='utf-8') as f:
            run = subprocess.run(command, stdout=f, stderr=subprocess.STDOUT, env=env, timeout=600, cwd=OUT)
        result.update({'exit_code': run.returncode, 'status': 'completed' if run.returncode == 0 else 'nonzero_partial_output_retained'})
    except Exception as ex:
        result.update({'status': 'failure_partial_output_retained', 'error': str(ex)})
    redacted_lines, java_files = 0, 0
    for p in (OUT / 'jadx-full').rglob('*.java'):
        java_files += 1
        lines = p.read_text(encoding='utf-8', errors='replace').splitlines()
        changed = False
        for i, line in enumerate(lines):
            modified = line
            if SECRET_KEY.search(line):
                modified = re.sub(r'"(?:[^"\\]|\\.)*"', '"[REDACTED]"', modified)
            modified = re.sub(r'"[0-9a-fA-F]{32,}"', '"[REDACTED_HEX_CONSTANT]"', modified)
            modified = re.sub(r'https?://[^\s"<>]+', lambda m: clean_url(m.group(0)), modified)
            if modified != line:
                lines[i], changed = modified, True
                redacted_lines += 1
        if changed:
            p.write_text('\n'.join(lines) + '\n', encoding='utf-8')
    log_text = (OUT / 'jadx_full.log').read_text(encoding='utf-8', errors='replace')
    result.update({'seconds': round(time.monotonic() - start, 2), 'java_files': java_files, 'redacted_lines': redacted_lines, 'decompilation_error_markers': log_text.count('ERROR'), 'limitations': 'Full static DEX decompilation, not APK execution. Nonzero exit/warnings retained. Credential-labelled and long-hex string constants redacted; not a secret-discovery guarantee. Outer/nested Java files are not the same count as DEX defined classes.'})
    write_json('jadx_full_status.json', result)
    return result


def derived_findings(manifest, config):
    appmeta = {m.get('name'): m.get('value', m.get('resource')) for m in manifest.get('application_metadata', [])}
    platform = appmeta.get('DOD_PLATFORM_NAME')
    name = 'Config_' + platform + '.bytes' if platform and not platform.startswith('@') else None
    selected = next((c for c in config['configs'] if Path(c['file']).name == name), None)
    findings = {
        'application_metadata': appmeta,
        'configuration_selection': {
            'status': 'STATIC_ANDROID_BRIDGE_CANDIDATE' if selected else 'UNCONFIRMED',
            'manifest_platform': platform,
            'selected_candidate': selected,
            'chain': [
                {'file': rel(OUT / 'AndroidManifest.decoded.redacted.xml'), 'evidence': 'Application meta-data DOD_PLATFORM_NAME'},
                {'file': rel(OUT / 'jadx/com_dodjoy_platform_PlatformConfig.java'), 'evidence': 'Init reads ApplicationInfo.metaData'},
                {'file': rel(OUT / 'jadx/com_dodjoy_dodlib_DodLibConfig.java'), 'evidence': 'Init reads DOD_PLATFORM_NAME; GetConfigBytesConfig formats Config_%s.bytes'},
                {'file': rel(OUT / 'jadx/com_dodjoy_dodlib_DodLibMeta.java'), 'evidence': 'DOD_PLATFORM_NAME constant equals DOD_PLATFORM_NAME'}],
            'limitations': 'Static configured branch only. It does not prove call completion, successful network access, production status, Unity configuration reuse, or absence of later overrides.'},
        'exported_legacy_count': sum(c.get('exported_effective_legacy') is True for c in manifest.get('components', [])),
        'full_decompilation': None}
    if (OUT / 'jadx_full_status.json').exists():
        status = json.loads((OUT / 'jadx_full_status.json').read_text(encoding='utf-8'))
        issues = []
        for p in (OUT / 'jadx-full').rglob('*.java'):
            for number, line in enumerate(p.read_text(encoding='utf-8', errors='replace').splitlines(), 1):
                if 'JADX ERROR' in line or 'Method not decompiled:' in line:
                    issues.append({'file': rel(p), 'line': number, 'kind': 'JADX_ERROR' if 'JADX ERROR' in line else 'METHOD_NOT_DECOMPILED', 'diagnostic': line.strip()})
        status.update({'methods_not_decompiled_markers': sum(i['kind'] == 'METHOD_NOT_DECOMPILED' for i in issues), 'severe_error_blocks': sum(i['kind'] == 'JADX_ERROR' for i in issues), 'issue_inventory': rel(OUT / 'java_decompilation_issues.csv')})
        write_csv('java_decompilation_issues.csv', issues, ['file', 'line', 'kind', 'diagnostic'])
        write_json('jadx_full_status.json', status)
        findings['full_decompilation'] = status
    write_json('android_static_findings.json', findings)
    return findings


def link(path, label=None):
    return '[' + (label or Path(path).name) + '](<' + str(path).replace('\\', '/') + '>)'

def report(manifest, config, supplemental, dex, classes, sdk, cert, jadx, archive_rows):
    # Report links are relative to reports/, not the shell working directory.
    evidence = lambda f: link('../derived/android/' + f, f)
    source = lambda f: link('../unpacked/' + f, Path(f).name)
    rows = []
    add = rows.append
    add('# Android 层离线静态分析\n')
    add('## 范围、方法与结论边界\n')
    add('- 仅离线读取原 APK 与完整解包目录；未执行 APK、未启动模拟器、未访问配置域名或游戏服务器。未分析 Unity 资产内容或 IL2CPP（由主代理负责）。')
    add('- 结构解析：自编只读 DEX 表解析；androguard AXML 解码；asn1crypto 证书解析；可选 jadx 关键类反编译。仅向授权 Android 派生目录及本报告写入。')
    add('- **事实**表示包内直接证据；**推断/待证**表示由静态声明推导或尚缺运行时依据。组件导出、HTTP 候选或 SDK 打包均不等于可利用漏洞、实际调用或已发生隐私采集。')
    add('- 输出已对名称含 secret/token/password/appkey 等的值及 URL 查询参数脱敏；证书公开摘要、包名、组件名、版本号、域名不是秘密。jadx 代码为近似重建，不替代原始字节码。\n')
    if manifest:
        add('## 1. Manifest 身份、SDK 与权限\n')
        add('| 项目 | 包内事实 |\n|---|---|')
        for k in ('package', 'versionName', 'versionCode', 'compileSdkVersion'):
            add('| ' + k + ' | `' + str(manifest.get(k)) + '` |')
        for k, v in manifest['sdk'].items():
            add('| ' + k + ' | `' + str(v) + '` |')
        for k in ('name', 'debuggable', 'allowBackup', 'extractNativeLibs', 'usesCleartextTraffic', 'networkSecurityConfig'):
            add('| application.' + k + ' | `' + str(manifest['application'].get(k, '未显式声明')) + '` |')
        add('\n证据：' + evidence('manifest_summary.json') + '、' + evidence('AndroidManifest.decoded.redacted.xml') + '。')
        add('\n申请权限共 **' + str(len(manifest['permissions'])) + '** 项（声明不等于授予/调用）：')
        for p in manifest['permissions']:
            add('- `' + str(p['name']) + '`' + ('，maxSdkVersion=' + p['maxSdkVersion'] if p['maxSdkVersion'] else ''))
        add('\n完整清单：' + evidence('manifest_permissions.csv') + '。')
        add('- **复核重点但非已证漏洞：** 电话状态、外部存储、录音、精确位置、短信收发为需关注的敏感能力声明；悬浮窗、修改设置、安装未知应用涉及特殊授权。READ_LOGS、MOUNT_UNMOUNT_FILESYSTEMS 等并不因写入 Manifest 就让普通第三方应用获得系统级权限。未观察运行时授权、调用时机或数据流。')
        add('\n## 2. 启动入口、Unity 集成与导出组件\n')
        for launcher in manifest['launchers']:
            add('- **事实：Launcher Activity** 为 `' + launcher + '`，具有 MAIN + LAUNCHER intent-filter。')
            chain, current, visited = [], launcher, set()
            while current and current not in visited:
                visited.add(current)
                chain.append(current)
                parent = next((x['superclass'] for x in classes if x['class'] == current), None)
                current = parent
            add('- **事实：DEX 继承链**：`' + ' → '.join(chain) + '`。')
        add('- **静态方法体证据：** 启动类不是 UnityPlayerActivity 的子类；它直接继承 Activity，在 onCreate 中初始化 PlatformInterface、DodLib 并构造 UnityPlayer/setContentView，生命周期转发给平台桥接与 Unity。见 ' + evidence('jadx/com_dodjoy_unityplayer_DodUnityPlayerActivity.java') + '（onCreate 第62–70行）。')
        add('- Manifest 的启动 Activity 带 `unityplayer.UnityActivity=true`；应用元数据含 `HaveDodNative=false`、`HaveHotIl2cpp=true`、`isSDKVersion=true`。这些仅是集成开关声明，不是对 native/IL2CPP 内容或实际加载的分析。')
        counts = Counter(c['type'] for c in manifest['components'])
        add('- 组件总数 **' + str(len(manifest['components'])) + '**；分类：' + '，'.join(k + '=' + str(v) for k, v in counts.items()) + '。')
        add('- 下表“有效导出”依据目标 SDK 的显式值/传统默认值计算，未考虑运行时启停、安装环境及调用方权限；没有 intent-filter 的非导出组件不因此可从外部启动。\n')
        add('| 类型 | 名称 | exported 声明 | 静态有效导出 | 权限/authority |\n|---|---|---|---|---|')
        for c in manifest['components']:
            add('| ' + c['type'] + ' | `' + c['name'] + '` | ' + str(c['exported_declared']) + ' | ' + str(c['exported_effective_legacy']) + ' | ' + str(c['permission'] or c['authorities'] or '未声明') + ' |')
        add('\n证据：' + evidence('manifest_components.csv') + '、' + evidence('dex_classes.csv') + '。按 target28 的传统默认值合计8个导出候选，包括未显式 exported、但带 intent-filter 的 YSDK PipeService 与网络状态 Receiver；这不等于权限绕过。系统受保护广播、组件内部校验及运行时状态尚未核验。导出 SDK 回调 Activity 是集成常见形态，未做参数注入验证。')
        add('- 包内两份 provider-path XML 含 external-path path="."，见 ' + evidence('com_tencent_ysdk_fileprovider_path.decoded.xml') + '、' + evidence('dod_provider_paths.decoded.xml') + '；但本 Manifest **没有引用这两份路径资源的 FileProvider**，不能把未被引用的宽路径配置报告成已存在任意文件泄露。唯一声明的 Provider 是 exported=false 的 YSDKInitProvider。')
        add('\n## 3. 网络策略\n')
        n = manifest['network_policy']
        add('- **事实：** `usesCleartextTraffic=' + str(n['usesCleartextTraffic_declared']) + '`；`networkSecurityConfig=' + str(n['networkSecurityConfig_ref']) + '`。')
        add('- 解包 res/xml 中识别到 network-security-config：' + str(n['networkSecurityConfig_xml_present']) + '。')
        add('- **推断边界：** 显式允许明文意味着平台层通常不阻止 HTTP；不能据此证明某候选 URL 被访问、链路遭攻击或存在可利用漏洞。WebView、原生网络栈及系统版本的实际处理未动态核验。')
    add('\n## 4. 第三方 SDK 的明确证据\n')
    add('| SDK/桥接 | DEX 定义类数 | 直接类名证据 |\n|---|---:|---|')
    for s in sdk:
        if s['class_count']:
            add('| ' + s['sdk'] + ' | ' + str(s['class_count']) + ' | ' + '、'.join('`' + x + '`' for x in s['examples'][:3]) + ' |')
    add('\n- **事实：** ' + source('assets/SdkCfg.bytes') + ' 声明 `DodStaticsName=ysdk`。')
    add('- **事实：** 包含 ' + source('assets/ysdkconf.ini') + '、' + source('assets/ysdkinfo.ini') + '、YSDK 公钥资源与 ' + source('assets/MidasPay.zip') + '；配置已脱敏写入 ' + evidence('supplemental_configs.redacted.json') + '。')
    add('- **明确版本证据：** ' + source('assets/ysdkinfo.ini') + ' 标注 `VERSION=1.8.1`、`DATETIME=20210817`；该值属于包内 YSDK 版本标注，不是游戏版本或在线更新后版本。支付 ZIP 成员名标注 `MidasPay_1.6.9w_171`、`MidasCore_1.6.9w_171` 等，运营商子模块另有1.6.8/1.6.9，不能把这些混为单一 SDK 总版本。')
    add('- **调用点证据：** ' + evidence('jadx/com_dodjoy_thirdPlatform_ThirdPlatform.java') + ' 的 initSdk 中调用 `YSDKApi.onCreate/handleIntent/init`，支付分支调用 `YSDKApi.recharge`；' + evidence('jadx/com_dodjoy_thirdPlatform_ThirdPlatformFactory.java') + ' 反射构造该 ThirdPlatform。Manifest 声明 YSDK 实名、免登回调、Midas支付Activity及YSDKInitProvider。结合包名、资源、组件和具体调用点，确认这是 YSDK/Midas 适配集成，仍不声称已执行登录或支付。')
    add('- SDK 归属依据包名前缀及明确资源，不把通用类名/域名当成 SDK 版本证明；按包名前缀计数可能含适配/兼容类。仅能确认打包，不证明所有 SDK 在本次运行启用。')
    add('- ZIP/JAR 内成员仅列目录、大小和 CRC，不执行或加载：' + evidence('sdk_archive_members.csv') + '（' + str(len(archive_rows)) + ' 个成员）。类证据：' + evidence('sdk_evidence.json') + '。')
    add('\n## 5. 多渠道 Config 配置：不把 dev 默认当正式\n')
    add('- **事实：** 发现 **' + str(config['count']) + '** 份 Config*.bytes；按 verurl scheme：`' + json.dumps(config['by_scheme'], ensure_ascii=False) + '`。')
    add('- **事实：** ' + source('assets/Config.bytes') + ' 是 `dev_android`、版本 `1.5`、内网 `192.168.1.2` HTTP、`bugly_debug=1`。它只是打包默认候选，**不能据此断言本包正式请求内网**。多个候选仍使用 dev_android 字段但指向不同域名，不能单凭 channel 文本判定开发/正式。')
    add('- **Android桥接静态选择链已确认：** Manifest 应用元数据 `DOD_PLATFORM_NAME=hardtime`、`ChannelId=550`；PlatformConfig.Init 读取 ApplicationInfo.metaData；DodLibConfig.Init 读取平台名；GetConfigBytesConfig 按 `Config_%s.bytes` 组织资源名。因此这条已反编译的Android读取路径指向 ' + source('assets/Config_hardtime.bytes') + '，其中 `version=2.10`、`verurl=http://web.ysr.hardtime.cn/ver/check_ver.php`、`bugly_debug=0`，虽然 channel 字段仍是dev_android。证据链见 ' + evidence('android_static_findings.json') + '、' + evidence('jadx/com_dodjoy_dodlib_DodLibConfig.java') + '（第30–44、63–74行）、' + evidence('AndroidManifest.decoded.redacted.xml') + '（第60–61行）。')
    add('- **待证边界：** 上述是配置好的Android静态代码分支，不是运行结果；不证明方法确已成功执行、该URL实际可达、属于生产环境、Unity复用此文件或没有后续覆盖。各 Config.version 与 Manifest.versionName/versionCode 是不同维度，不可混用。')
    add('- **格式异常但原件未改：** ' + source('assets/Config_om_android.bytes') + ' 尾部有逗号，严格JSON失败；派生副本仅去尾逗号解析以保留30份完整盘点，原始错误及规范化标记见 ' + evidence('channel_config_values.redacted.json') + '。\n')
    add('| 配置文件 | channel | 配置版本 | verurl（仅离线读取） | bugly_debug |\n|---|---|---|---|---:|')
    for c in config['configs']:
        add('| ' + source('assets/' + Path(c['file']).name) + ' | `' + str(c['channel']) + '` | ' + c['version'] + ' | `' + c['version_url'] + '` | ' + str(c['bugly_debug']) + ' |')
    add('\n证据（含 SHA-256）：' + evidence('channel_configs.json') + '、' + evidence('channel_configs.csv') + '。')
    privacy = next((x for x in supplemental if x['file'].endswith('PrivacyConfig.json')), {})
    if privacy:
        add('- 隐私文本 **声明** 涉及存储、电话与设备标识信息；这属于文案，不是实际采集数据流证据。' + source('assets/PrivacyConfig.json') + ' 严格 JSON 解析成功：`' + str(privacy.get('strict_json')) + '`；保留原始错误及宽松解析结果，不修改源文件。')
    add('\n## 6. DEX 包/类统计\n')
    add('| DEX | 字节数 | 定义类数 | string_ids | method_ids（含引用） |\n|---|---:|---:|---:|---:|')
    for d in dex:
        add('| ' + link('../../' + d['file'], Path(d['file']).name) + ' | ' + str(d['size']) + ' | ' + str(d['defined_classes']) + ' | ' + str(d['string_ids']) + ' | ' + str(d['method_ids_including_references']) + ' |')
    add('\n- ' + source('assets/39285EFA.dex') + ' 共71500字节，头部不是标准 `dex\\n` 魔数，因此未作DEX类解析；仅记录摘要和前16字节于 ' + evidence('nonstandard_dex_candidates.json') + '。仅靠扩展名或非标准头不能认定加壳、加密或恶意，亦不能当成有效第二DEX。')
    add('- ' + source('assets/ysdk_hackdex.jar') + ' 中有一个436字节的嵌套classes.dex成员，仅列ZIP目录，未当作根DEX总量；资源存在不证明它或其他assets文件被加载执行。')
    add('- 精确包名按类去掉末段统计；同包跨 DEX 不重复定义为不同 SDK。完整结果：' + evidence('dex_summary.json') + '、' + evidence('dex_packages.csv') + '、' + evidence('dex_classes.csv') + '。')
    add('\n## 7. 签名证书摘要\n')
    if cert:
        add('- 签名结构存在性：' + '；'.join(cert['schemes_presence']) + '。')
        seen = set()
        for c in cert['certificates']:
            if c['sha256'] in seen:
                continue
            seen.add(c['sha256'])
            add('- Subject：`' + c['subject'] + '`；Issuer：`' + c['issuer'] + '`。')
            add('- 有效期：`' + c['not_before'] + '` 至 `' + c['not_after'] + '`；证书签名算法：`' + c['signature_algorithm'] + '`。')
            add('- SHA-256：`' + c['sha256'] + '`。')
            add('- SHA-1：`' + c['sha1'] + '`；MD5：`' + c['md5'] + '`（仅历史比对标识，不作为安全性推荐）。')
        add('- **限制：** 仅提取证书及摘要，未验证 APK/JAR 签名数学正确性、各条目完整性或证书信任链。不能据此宣称原包可信/未篡改，也不因开发者自签名认定异常。')
        add('- 证据：' + evidence('certificates.json') + '。')
    else:
        add('- 本轮证书解析未完成，详见失败记录；不凭文件名猜测签名者。')
    add('\n## 8. jadx 与失败说明\n')
    add('- 状态：`' + str(jadx.get('status')) + '`；是否尝试：`' + str(jadx.get('attempted')) + '`。')
    if jadx.get('reason'):
        add('- ' + jadx['reason'])
    for item in jadx.get('items', []):
        add('- `' + item['class'] + '`：exit=' + str(item.get('exit_code')) + ('；error=' + str(item['error']) if 'error' in item else '') + ('；' + link('../' + item['output'].split('本地分析/', 1)[-1], Path(item['output']).name) if item.get('output') else '；无源码输出') + '；日志 ' + link('../' + item['log'].split('本地分析/', 1)[-1], Path(item['log']).name) + '。')
    add('- 完整结果：' + evidence('jadx_status.json') + '；非零退出保留日志及已生成片段，不把反编译失败当成混淆/加固的唯一证明。')
    if (OUT / 'jadx_full_status.json').exists():
        full = json.loads((OUT / 'jadx_full_status.json').read_text(encoding='utf-8'))
        add('\n- **全量主DEX反编译（非完全成功）：** jadx1.5.6、JDK、`-Xmx2G -j3 --no-res`，exit=`' + str(full.get('exit_code')) + '`，耗时' + str(full.get('seconds')) + '秒，保留 **' + str(full.get('java_files')) + '** 个Java文件。该文件数与6052个DEX定义类不相等，嵌套/匿名类可能合并。状态 ' + evidence('jadx_full_status.json') + '；原始日志 ' + evidence('jadx_full.log') + '；源码位于 [jadx-full](<../derived/android/jadx-full/>)。')
        add('- 日志仅汇总1个ERROR，不代表只有一个方法不完整：扫描有 **' + str(full.get('methods_not_decompiled_markers')) + '** 个 `Method not decompiled` 占位、**' + str(full.get('severe_error_blocks')) + '** 处严重JADX_ERROR。完整定位见 ' + evidence('java_decompilation_issues.csv') + '。严重错误为RegionMakerVisitor的JadxOverflowException，见 ' + evidence('jadx-full/sources/com/tencent/tmassistantbase/util/e.java') + ' 第33行；保留原始字节码和错误，不虚报源码恢复成功。')
        add('- 全量派生代码对带凭据关键字、长十六进制字符串常量和URL查询做了脱敏（' + str(full.get('redacted_lines')) + '行）。这是保守暴露控制，不保证识别所有秘密，也不可把删改过的派生代码重新编译当原始源。')
    add('\n## 9. 局限与复现\n')
    add('- 不实施联网、漏洞利用、登录/支付调用、动态权限测试；无法确认服务器状态、生产配置、SDK 活跃状态、隐私同意前后行为或运行时组件配置。')
    add('- DEX strings 的精确业务解释及 native/Unity 配置选择不在本报告保证范围。没有报告“已证实可利用漏洞”。')
    add('- 复现脚本：' + link('../tools/analyze_android.py', 'analyze_android.py') + '。默认无参等同 `--phase full`，完整重算Manifest/配置/DEX/证书/报告并复用已有jadx状态，不下载依赖、不联网；`--jadx` 补做缺失关键类，已成功类不会重复；`--jadx-full` 明确重新执行全量DEX反编译。只需独立配置或DEX结构阶段时用 `--phase config` 或 `--phase structure`。pycache已禁用，Java临时目录限定在Android派生目录。')
    add('```powershell\n$env:PYTHONDONTWRITEBYTECODE=\'1\'\n& \'C:\\Users\\Admin\\.dsh\\dsh-runtimes\\dsh-primary-runtime\\dependencies\\python\\python.exe\' \'本地分析\\tools\\analyze_android.py\' --phase full --jadx --jadx-full 2>&1 | Out-File \'本地分析\\derived\\android\\reproduce.log\' -Encoding utf8\nif ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }\n```')
    add('- 输入摘要与运行信息：' + evidence('run_summary.json') + '；解析失败/限制：' + evidence('errors.json') + '。')
    if ERRORS:
        for e in ERRORS:
            add('- `' + e['stage'] + '`：' + e['type'] + ' — ' + e['message'].replace('\n', ' '))
    REPORT.parent.mkdir(parents=True, exist_ok=True)
    REPORT.write_text('\n'.join(rows) + '\n', encoding='utf-8')

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('--phase', choices=['config', 'structure', 'full'], default='full')
    parser.add_argument('--jadx', action='store_true')
    parser.add_argument('--jadx-full', action='store_true', help='Also decompile full primary DEX offline; can return partial output/nonzero')
    parser.add_argument('--java', default=r'D:\Android Studio\jbr\bin\java.exe')
    args = parser.parse_args()
    OUT.mkdir(parents=True, exist_ok=True)
    logging.basicConfig(level=logging.ERROR)
    try:
        from loguru import logger
        logger.remove()
    except ImportError:
        pass
    config, supplemental = configs()
    if args.phase == 'config':
        write_json('config_phase_status.json', {'status': 'completed', 'configuration_files': config['count'], 'dependencies_required': False, 'errors': ERRORS})
        print('Config-only offline analysis completed:', config['count'])
        return
    dex, classes, sdk = dex_analysis()
    if args.jadx_full:
        jadx_full_analysis(Path(args.java))
    if args.phase == 'structure':
        archive_rows = archives()
        jadx = jadx_analysis(classes, {}, Path(args.java)) if args.jadx else None
        write_json('structure_phase_status.json', {'status': 'completed', 'dex_files': len(dex), 'defined_classes': len(classes), 'archive_members': len(archive_rows), 'jadx': jadx, 'errors': ERRORS})
        print(json.dumps({'status': 'structure_completed', 'dex_files': len(dex), 'defined_classes': len(classes)}, ensure_ascii=False))
        return
    manifest = {}
    cert = None
    try:
        manifest = manifest_analysis()
    except Exception as ex:
        err('manifest', ex)
    apks = list(ROOT.glob('*.apk'))
    apk = apks[0] if len(apks) == 1 else None
    try:
        cert = certificates(apk)
    except Exception as ex:
        err('certificates', ex)
    archive_rows = archives()
    if args.jadx:
        jadx = jadx_analysis(classes, manifest, Path(args.java))
    elif (OUT / 'jadx_status.json').exists():
        jadx = json.loads((OUT / 'jadx_status.json').read_text(encoding='utf-8'))
        jadx['reused_existing_offline_result'] = True
    else:
        jadx = {'attempted': False, 'status': 'not_requested'}
    write_json('jadx_status.json', jadx)
    inputs = []
    if apk:
        h = hashlib.sha256()
        with apk.open('rb') as f:
            for chunk in iter(lambda: f.read(8 * 1024 * 1024), b''):
                h.update(chunk)
        inputs.append({'file': rel(apk), 'size': apk.stat().st_size, 'sha256': h.hexdigest(), 'read_only': True})
    findings = derived_findings(manifest, config)
    full_status = (findings.get('full_decompilation') or {}).get('status', 'not_requested')
    status = 'completed_with_limitations' if ERRORS or full_status in ('nonzero_partial_output_retained', 'failure_partial_output_retained') else 'completed'
    write_json('run_summary.json', {'status': status, 'phase': args.phase, 'inputs': inputs, 'manifest_parsed': bool(manifest), 'configs': config['count'], 'dex_files': len(dex), 'classes': len(classes), 'jadx': jadx['status'], 'jadx_full': full_status, 'errors': len(ERRORS), 'network_access': False, 'apk_execution': False, 'unity_or_il2cpp_analysis': False})
    write_json('errors.json', ERRORS)
    report(manifest, config, supplemental, dex, classes, sdk, cert, jadx, archive_rows)
    print(json.dumps({'status': status, 'report': rel(REPORT), 'config_count': config['count'], 'dex_class_count': len(classes), 'errors': len(ERRORS), 'jadx': jadx['status'], 'jadx_full': full_status}, ensure_ascii=False))

if __name__ == '__main__':
    main()
