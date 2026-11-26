"""Read-only pet coverage audit. Never executes archived game/client code."""
from pathlib import Path
import collections
import dis
import json
import marshal
import struct
import zlib

ROOT = Path(__file__).resolve().parents[2]
GAME = ROOT / '勇者养成记-UrhoX'
GODOT = Path('D:/VibeCoding/godotProj')
SOURCE = GODOT / 'Y3地图-本地分析/无尽修仙刷刷刷'
PACKAGE = Path('D:/kkduizhan/Games/y3/2.0/game/Package')
OUT = ROOT / '本地分析/derived/pet-migration'


def read(path):
    return json.loads(path.read_text(encoding='utf-8-sig'))


def literal_data(code):
    """Interpret literal construction only; rejects calls, imports and jumps."""
    stack, names = [], {}
    for i in dis.get_instructions(code):
        op, n = i.opname, i.arg
        if op in ('RESUME', 'EXTENDED_ARG'):
            continue
        if op in ('LOAD_CONST', 'LOAD_SMALL_INT'):
            stack.append(i.argval)
        elif op == 'LOAD_NAME':
            stack.append(names[i.argval])
        elif op == 'STORE_NAME':
            names[i.argval] = stack.pop()
        elif op in ('BUILD_MAP', 'BUILD_TUPLE', 'BUILD_LIST'):
            count = n * 2 if op == 'BUILD_MAP' else n
            values = stack[-count:] if count else []
            if count:
                del stack[-count:]
            stack.append(dict(zip(values[::2], values[1::2])) if op == 'BUILD_MAP'
                         else tuple(values) if op == 'BUILD_TUPLE' else list(values))
        elif op == 'MAP_ADD':
            value, key = stack.pop(), stack.pop()
            stack[-n][key] = value
        elif op == 'DICT_UPDATE':
            value = stack.pop()
            stack[-n].update(value)
        elif op == 'LIST_APPEND':
            value = stack.pop()
            stack[-n].append(value)
        elif op == 'CALL_INTRINSIC_1' and i.argrepr == 'INTRINSIC_LIST_TO_TUPLE':
            stack.append(tuple(stack.pop()))
        elif op == 'RETURN_VALUE':
            break
        else:
            raise ValueError(f'Non-literal instruction rejected: {op} {i.argrepr}')
    return names['data']


def package_index():
    raw = (PACKAGE / 'Resources.mpkinfo').read_bytes()
    entries, pos = {}, 8
    for _ in range(struct.unpack_from('<I', raw, 4)[0]):
        n = struct.unpack_from('<H', raw, pos)[0]
        pos += 2
        name = raw[pos:pos+n].decode()
        pos += n
        entries[name] = struct.unpack_from('<III', raw, pos)
        pos += 12
    return entries


def base_data(filename, entries):
    index = read(GODOT / 'Y3地图-本地分析/tools/engine-evidence/index.json')
    meta = next(x for x in index if x['filename'] == filename)
    off, size, part = entries[meta['package_name']]
    with (PACKAGE / f'Resources{part if part else ""}.mpk').open('rb') as f:
        f.seek(off)
        raw = f.read(size)
    n = meta['xor_prefix']
    payload = zlib.decompress(raw[:n].translate(bytes(i ^ 0x9a for i in range(256))) + raw[n:])
    return literal_data(marshal.loads(payload[8:]))


def mesh_points(path):
    raw = path.read_bytes()
    assert raw[:4] == b'UMD2'
    buffers, count, element_count = struct.unpack_from('<III', raw, 4)
    assert buffers == 1
    elements = struct.unpack_from('<' + 'I' * element_count, raw, 16)
    sizes = {2: 8, 3: 12, 4: 16, 5: 4}
    stride = sum(sizes[e & 255] for e in elements)
    pos = 16 + element_count * 4 + 8
    return [struct.unpack_from('<3f', raw, pos + i * stride) for i in range(count)]


def transform(v, pose):
    # UrhoX quaternion order is w,x,y,z; poses are read from the live importer.
    x, y, z = (v[i] * pose['scale'][i] for i in range(3))
    w, qx, qy, qz = pose['rotation']
    tx, ty, tz = 2*(qy*z-qz*y), 2*(qz*x-qx*z), 2*(qx*y-qy*x)
    return [x+w*tx+qy*tz-qz*ty+pose['position'][0],
            y+w*ty+qz*tx-qx*tz+pose['position'][1],
            z+w*tz+qx*ty-qy*tx+pose['position'][2]]


def prefab_bounds(prefab, scale):
    points = []
    for node in prefab['nodes']:
        if not node['enabled']:
            continue
        for v in mesh_points(GAME / 'assets' / node['model']):
            points.append([x*scale for x in transform(transform(v, node), prefab['root'])])
    low = [min(v[i] for v in points) for i in range(3)]
    high = [max(v[i] for v in points) for i in range(3)]
    return dict(min=low, max=high, dimensions_m=[round(high[i]-low[i], 4) for i in range(3)],
                method='Transformed bind-pose vertices, prefab root and ModelScale; excludes animation and effects.')


def main():
    OUT.mkdir(parents=True, exist_ok=True)
    config = GAME / 'assets/config'
    load = lambda n: read(next(config.glob('ResDef.' + n + '__*.json')))
    bases, qualities = load('PetBaseConfig'), load('PetQualityConfig')
    models = {r['ModelID']: r for r in load('ModelConfig')}
    prefabs = read(GAME / 'assets/original/models/index.json')
    current = []
    for row in bases:
        mid = row['ModelID']
        model = models[mid]
        prefab = read(GAME / 'assets' / prefabs[model['ModelFile'].lower()])
        q = next(r for r in qualities if r['PetID'] == row['PetID'] and r['Quality'] == 1 and r['Prefix'] == 1)
        attack = next(a['Value'] for a in q['Attr'] if a['DataType'] == 2 and a['AddType'] == 1)
        current.append(dict(id=row['PetID'], name=row['PetName'], type=row['PetType'],
                            order=row['Order'], unlock=row['MinRoleLev'], base_attack=attack,
                            max_level=q['MaxLevel'], model_id=mid, model=model['ModelFile'],
                            scale=model['ModelScale'], variation=models[row['VariationModelID']]['ModelFile'],
                            bounds=prefab_bounds(prefab, model['ModelScale'])))
    source_rows = read(SOURCE / 'config_tables/灵兽类型表.json')['rows']
    tiers = {r['key']: r for r in read(SOURCE / 'config_tables/灵兽品质表.json')['rows']}
    units = {r['id']: r for r in read(SOURCE / 'objects/section_25880.json')}
    icons = {int(r['id']): r for r in read(SOURCE / 'assets/icon_index.json')}
    entries = package_index()
    editor = base_data('dm/commons/datas/editor_model.py', entries)
    resource = base_data('dm/commons/datas/res_model.py', entries)
    shop = PACKAGE.parent / 'LocalData/OfficialShopResource'
    patch = read(shop / 'downloader_patchlist_windows64_normal.txt')['common']
    source = []
    for row in source_rows:
        unit = units[str(row['灵兽单位类型'])]
        mid = unit['data']['model']
        real_id = editor[mid]['model_id']
        cached_paths = [k for k in patch if k.startswith('Char/') and '/'+str(real_id)+'/' in k]
        physical = [k for k in cached_paths if (shop/k).is_file()]
        source.append(dict(id=row['key'], name=row['灵兽名'], tier=tiers[row['品质']]['品质'],
                           unit_id=row['灵兽单位类型'], model_id=mid, body_size=unit['data']['body_size'],
                           attack_animation=row['攻击动作'], portrait=str(SOURCE / icons[row['立绘']]['png']),
                           editor_metadata=editor.get(mid), resource_metadata=resource.get(real_id),
                           real_model_id=real_id, cached_paths=physical,
                           skeleton_files=[str(shop/k) for k in physical if k.endswith('.skeleton')],
                           animation_files=[str(shop/k) for k in physical if k.endswith('.anim')]))
    result = dict(date='2026-11-10', current_root=str(GAME), source_root=str(SOURCE),
                  current=current, source=source,
                  current_unique_models=len({r['model_id'] for r in current}),
                  source_tiers=dict(collections.Counter(r['tier'] for r in source)),
                  scope='Configuration and local file audit; no runtime migration or visual acceptance.')
    assignments = [
        (401, 1, '较接近：飞猪对应飞猪；小瓜配置使用 idle1 发动攻击。'),
        (402, 3, '轮廓差异：飞鸟改为狐狸；本次未找到天灵狐骨架与动作缓存。'),
        (403, 2, '较接近：狼对应犬；保留本项目远程攻击规则。'),
        (404, 4, '轮廓差异：小恐龙改为四足豹，需重做朝向与攻击表现。'),
        (405, 5, '轮廓差异：鳄鱼改为牛魔，身体比例和站姿不同。'),
        (406, 6, '轮廓差异：有翼小龙改为多尾狐，需约束尾巴占屏宽度。'),
        (407, 9, '题材接近但站姿不同：海龙对应龙人法师。'),
        (408, 7, '轮廓差异明显：彩鼬改为熊猫人；这是保评级、牺牲物种的一项。'),
        (409, 8, '植物主题接近：曼陀罗对应树人；体块差异需缩放。'),
        (410, 10, '龙主题接近：妖灵龙对应青龙；长身体应优先约束宽深。'),
        (411, 12, '飞行轮廓近似：蝶翼灵龙对应朱雀；翅展需要单独限宽。'),
    ]
    current_by_id = {r['id']: r for r in current}
    source_by_id = {r['id']: r for r in source}
    result['mapping'] = [dict(current_id=a, current_name=current_by_id[a]['name'],
                              alias_ids=[a, a+100], source_id=b, source_name=source_by_id[b]['name'],
                              tier=source_by_id[b]['tier'], note=note,
                              current_dimensions_m=current_by_id[a]['bounds']['dimensions_m'])
                         for a, b, note in assignments]
    result['spares'] = ['白虎 EX', '玄武 EX']
    result['conclusions'] = dict(
        normal_appearance_coverage='13 source species cover 11 active model appearances by tier, with shape compromises.',
        distinct_variation_coverage='22 independent normal+variation appearances need at least 9 additional distinct sets; not currently a live runtime requirement.',
        cached_skeleton_and_animation_sets=sum(bool(r['skeleton_files'] and r['animation_files']) for r in source),
        source_asset_readiness='12/13 have cached skeleton/animation references; complete mesh-material-skin-animation chains are not verified.',
        scale_readiness='Target bind-pose dimensions measured; source mesh bounds and in-engine silhouette comparison remain unverified.',
        game_changes='No runtime game files or asset mappings changed.')
    (OUT / 'pet-coverage.json').write_text(json.dumps(result, ensure_ascii=False, indent=2), encoding='utf-8')
    print('saved', OUT / 'pet-coverage.json')
    for row in current[:11]:
        print('CURRENT', row['id'], row['name'], row['bounds']['dimensions_m'])
    for row in source:
        print('SOURCE', row['name'], row['tier'], row['model_id'], 'real', row['real_model_id'],
              'skeletons', len(row['skeleton_files']), 'animations', len(row['animation_files']))


if __name__ == '__main__':
    main()
