"""Audit additional pet pools. Only reads archives and existing conversions."""
from pathlib import Path
import collections
import json
import struct
from urllib.parse import unquote
import analyze_pet_migration as prior

BASE = Path('D:/VibeCoding/godotProj')
OUT = prior.OUT


def load(path):
    return json.loads(path.read_text(encoding='utf-8-sig'))


def local_url(url):
    return BASE / unquote(url.removeprefix('/files/')) if url else None


def glb_info(path):
    raw = path.read_bytes()
    assert raw[:4] == b'glTF' and struct.unpack_from('<I', raw, 8)[0] == len(raw)
    length, kind = struct.unpack_from('<II', raw, 12)
    assert kind == 0x4E4F534A
    d = json.loads(raw[20:20+length])
    external = [str(path.parent / r['uri']) for r in d.get('images', []) if 'uri' in r and not r['uri'].startswith('data:')]
    return dict(path=str(path), skins=len(d.get('skins', [])),
                clips=[r.get('name', '') for r in d.get('animations', [])],
                meshes=len(d.get('meshes', [])), images=len(d.get('images', [])),
                missing_external_images=[p for p in external if not Path(p).is_file()])


def main():
    OUT.mkdir(parents=True, exist_ok=True)
    editor = prior.base_data('dm/commons/datas/editor_model.py', prior.package_index())
    shop = prior.PACKAGE.parent / 'LocalData/OfficialShopResource'
    patch = load(shop / 'downloader_patchlist_windows64_normal.txt')['common']
    catalog = load(BASE / '资产预览/data/catalog.json')
    result = dict(date='2026-11-10', scope='Local configuration/file audit. No runtime migration.', games=[])
    for game in ['重生魔兽刷刷刷', '无尽挂神重生']:
        root = BASE / 'Y3地图-本地分析' / game
        entry = next(x for x in catalog['maps'] if x['name'] == game)
        assets = load(BASE / '资产预览' / entry['catalogUrl'].lstrip('/'))['assets']
        models = {r['id']: r for r in assets if r['kind'] == 'model'}
        icons = load(root / 'assets/icon_index.json')
        icons_by_id = {int(r['id']): r for r in icons}
        icons_by_name = collections.defaultdict(list)
        for r in icons:
            icons_by_name[r['name']].append(r)
        # Index the archive once; repeated globbing traverses thousands of dirs.
        rigs = collections.defaultdict(list)
        animations = collections.defaultdict(list)
        for path in (root/'original/custom').rglob('*'):
            if path.suffix not in ('.skeleton', '.anim'):
                continue
            for segment in path.parts:
                if segment.isdecimal():
                    (rigs if path.suffix == '.skeleton' else animations)[int(segment)].append(str(path))
        package_meshes = collections.defaultdict(set)
        for x in assets:
            if x.get('package') and x.get('glb'):
                path = local_url(x['glb'])
                if path.is_file():
                    package_meshes[x['package']].add(str(path))
        rows = []
        if game == '重生魔兽刷刷刷':
            config = load(root / 'config_tables/宠物-数据表.json')['rows']
            model_rows = {r['宠物ID']: r for r in load(root / 'config_tables/宠物-模型表.json')['rows']}
            for r in config:
                m = model_rows[r['宠物ID']]
                icon = next(iter(icons_by_name[r['名称']]), None)
                rows.append(dict(id=r['宠物ID'], name=r['名称'], tier=r['稀有度'],
                                 variant=False, model=m['模型'], scale=m['缩放倍率'],
                                 height_offset=m['离地高度'], attack_clip=m['攻击动画'],
                                 attack_type=r['攻击类型'], star_cap=r['星级'],
                                 icon=str(root/icon['png']) if icon else None))
        else:
            config = load(root / 'config_tables/pet_config.json')['rows']
            items = {r['id']: r for r in load(root / 'config_tables/pro2_config.json')['rows']}
            tiers = {r['key']: r['name'] for r in load(root / 'config_tables/pro_quality_config.json')['rows']}
            units = {r['id']: r for r in load(root / 'objects/section_25880.json')}
            for r in config:
                unit = units[str(r['pet_type'])]['data']
                item = items[r['key']]
                icon = icons_by_id.get(item['icon'])
                colors = {k: unit.get(k) for k in ['base_tint_color', 'use_base_tint_color', 'fresnel_color', 'use_fresnel', 'fresnel_emissive_color_strength']}
                rows.append(dict(id=r['key'], name=r['name'], item_name=item['name'],
                                 tier=tiers[item['quality']], variant=bool(r['is_by']),
                                 open=bool(r['is_open']), unit=r['pet_type'], model=unit['model'],
                                 scale=unit['body_size'], height_offset=unit['height_offset'],
                                 colors=colors, icon=str(root/icon['png']) if icon else None))
        for r in rows:
            model = models.get(str(r['model']))
            builtin = editor.get(r['model']) if model is None else None
            metadata = model.get('metadata', {}) if model else {}
            r['asset_name'] = model['name'] if model else 'Y3 公共模型'
            r['format'] = model['format'] if model else 'Y3 builtin'
            r['metadata'] = metadata if model else builtin
            r['model_url'] = model.get('glb') if model else None
            r['glb'] = None
            if r['model_url']:
                path = local_url(r['model_url'])
                if path.is_file():
                    r['glb'] = glb_info(path)
            r['native_mesh_glbs'] = sorted(package_meshes['custom_model/' + str(r['model'])])
            r['real_model'] = builtin.get('model_id') if builtin else r['model']
            if builtin:
                cached = [k for k in patch if k.startswith('Char/') and '/' + str(r['real_model']) + '/' in k and (shop/k).is_file()]
                r['skeleton_files'] = [str(shop/k) for k in cached if k.endswith('.skeleton')]
                r['animation_files'] = [str(shop/k) for k in cached if k.endswith('.anim')]
            else:
                r['skeleton_files'] = rigs[r['model']]
                r['animation_files'] = animations[r['model']]
            if r['glb'] and r['glb']['skins'] and r['glb']['clips']:
                r['readiness'] = '已有蒙皮和动作 GLB；未在本项目验收'
            elif r['native_mesh_glbs']:
                r['readiness'] = '已有静态网格 GLB；蒙皮、材质、动作需组装'
            elif r['skeleton_files'] and r['animation_files']:
                r['readiness'] = '找到公共骨架和动作缓存；完整网格链未验收'
            else:
                r['readiness'] = '配置引用存在；本次未找到完整转换套件'
        normal = [r for r in rows if not r['variant']]
        variants = [r for r in rows if r['variant']]
        pairs = []
        for r in variants:
            n = next((x for x in normal if x['id'] == r['id'] - 10000), None)
            if n:
                pairs.append(dict(normal=n['name'], variant=r['name'], same_model=n['model']==r['model'],
                                  normal_model=n['model'], variant_model=r['model']))
        summary = dict(rows=len(rows), normal=len(normal), variant=len(variants),
                       unique_models=len({r['model'] for r in rows}),
                       tiers=dict(collections.Counter(r['tier'] for r in rows)),
                       normal_tiers=dict(collections.Counter(r['tier'] for r in normal)),
                       animated_glbs=sum(bool(r['glb'] and r['glb']['skins'] and r['glb']['clips']) for r in rows),
                       native_mesh_sets=sum(bool(r['native_mesh_glbs']) for r in rows),
                       cached_rig_rows=sum(bool(r['skeleton_files'] and r['animation_files']) for r in rows))
        result['games'].append(dict(name=game, root=str(root), summary=summary, pets=rows, variant_pairs=pairs))
        print(game, summary, flush=True)
        for r in rows:
            print(r['name'], r['tier'], r['model'], r['readiness'],
                  'clips', len(r['glb']['clips']) if r['glb'] else len(r['animation_files']),
                  'native meshes', len(r['native_mesh_glbs']))
    earlier = load(OUT/'pet-coverage.json')
    models = {r['model_id'] for r in earlier['source']}
    for game in result['games']:
        models.update(r['model'] for r in game['pets'])
    result['combined_config_rows'] = len(earlier['source']) + sum(g['summary']['rows'] for g in result['games'])
    result['combined_unique_model_ids'] = len(models)
    (OUT/'extra-pet-coverage.json').write_text(json.dumps(result, ensure_ascii=False, indent=2), encoding='utf-8')
    print('COMBINED', result['combined_config_rows'], result['combined_unique_model_ids'])


if __name__ == '__main__':
    main()
