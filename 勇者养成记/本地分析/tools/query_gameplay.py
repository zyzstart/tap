"""Query the archived merged gameplay catalog, without running or contacting the game."""
from pathlib import Path
import argparse, json, sys
ROOT=Path(__file__).resolve().parents[1]
NATIVE={'decoded-validated-static','decoded-validated-native-recursive'}

def get_path(row,path):
    value=row
    for part in path.split('.'):
        value=value[int(part)] if isinstance(value,list) else value[part]
    return value

def matches(row,filters):
    for expression in filters:
        if '=' not in expression:raise ValueError('--where requires Field=value')
        field,text=expression.split('=',1)
        try:expected=json.loads(text)
        except json.JSONDecodeError:expected=text
        try:value=get_path(row,field)
        except (KeyError,IndexError,ValueError,TypeError):return False
        if value!=expected:return False
    return True

def run():
    ap=argparse.ArgumentParser(description=__doc__)
    ap.add_argument('--list',action='store_true',help='List tables and evidence categories')
    ap.add_argument('--table',help='Exact Namespace.Type or table name; ambiguous matches are rejected')
    ap.add_argument('--variant',choices=['fp','nonfp'])
    ap.add_argument('--allow-candidate',action='store_true',help='Explicitly allow companion-derived, non-native-proven layouts')
    ap.add_argument('--where',action='append',default=[],help='Exact field equality; nested path like ImpactData.0.Value=60')
    ap.add_argument('--contains',help='Substring search over one row JSON, not a semantic join')
    ap.add_argument('--limit',type=int,default=20)
    args=ap.parse_args()
    if not 1<=args.limit<=100000:ap.error('--limit must be 1..100000')
    catalog=json.loads((ROOT/'derived/gameplay-catalog/catalog.json').read_text(encoding='utf-8'))
    if args.list:
        rows=[{k:t.get(k) for k in ['schema','name','variant','status','decoded_record_count','decoded_json']} for t in catalog['tables']]
        if args.table:rows=[x for x in rows if args.table in (x['schema'],x['name'])]
        print(json.dumps({'summary':catalog['summary'],'tables':rows},ensure_ascii=False,indent=2));return 0
    if not args.table:ap.error('Use --list or --table')
    tables=[x for x in catalog['tables'] if args.table in (x.get('schema'),x['name']) and (not args.variant or x['variant']==args.variant)]
    tables=[x for x in tables if x['status'] in NATIVE or args.allow_candidate and x['status']=='cross-variant-layout-candidate']
    if len(tables)!=1:
        ap.error('Expected exactly one accessible table, got '+str(len(tables))+'. Use --list, exact Namespace.Type and --variant; candidates require --allow-candidate.')
    table=tables[0];doc=json.loads((ROOT/table['decoded_json']).read_text(encoding='utf-8'))
    hits=[];count=0
    for row in doc['records']:
        try:good=matches(row,args.where)
        except ValueError as exc:ap.error(str(exc))
        if not good or args.contains and args.contains not in json.dumps(row,ensure_ascii=False):continue
        count+=1
        if len(hits)<args.limit:hits.append(row)
    print(json.dumps({'source':table['decoded_json'],'schema':table.get('schema'),'variant':table['variant'],'evidence_status':table['status'],'matched_records':count,'returned_records':len(hits),'records':hits,'limits':['No runtime execution; this query exposes archived values, not final gameplay results.','Source rows retain raw FP and precision mirrors; no implicit unit conversion or drop-rate normalization.']},ensure_ascii=False,indent=2,allow_nan=False))
    return 0

if __name__=='__main__':sys.exit(run())
