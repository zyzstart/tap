"""Host-only checks of recursive companion-derived candidates."""
import copy, csv, hashlib, json, struct, sys, unittest
import recover_recursive_variants as r
import decode_resbin_extended as d

class RecursiveVariantTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.schemas={p.stem:json.loads(p.read_text(encoding='utf-8')) for p in (r.ROOT/'derived/config-extended/schemas').glob('*.json')}
    def test_every_archived_candidate_roundtrips_and_matches_companion(self):
        index=json.loads((r.OUT/'layout-index.json').read_text(encoding='utf-8'))
        for item in index:
            if item['status']!=r.STATUS:continue
            with self.subTest(table=item['name']):
                raw=(r.ROOT/item['export']).read_bytes()
                self.assertEqual(hashlib.sha256(raw).hexdigest(),item['sha256'])
                schemas=r.transfer(self.schemas,'_resbin_fp_' in item['bundle'])
                codec=d.Codec(schemas);header,decoded,validation=codec.decode(raw,item['companion_schema'])
                doc=json.loads((r.ROOT/item['decoded_json']).read_text(encoding='utf-8'))
                src=json.loads((r.ROOT/item['companion_json']).read_text(encoding='utf-8'))
                self.assertEqual(decoded,doc['records'])
                self.assertEqual(codec.encode_payload(doc['records'],item['companion_schema']),raw[20:])
                self.assertEqual(r.check_values(decoded,src['records'],self.schemas,schemas,item['companion_schema']),item['named_value_checks'])
                with (r.ROOT/item['decoded_csv']).open(encoding='utf-8-sig',newline='') as f:csvrows=list(csv.DictReader(f))
                self.assertEqual(len(csvrows),len(decoded))
                for row,csvrow in zip(decoded,csvrows):
                    self.assertEqual({k:str(d.safe_csv_cell(v)) for k,v in row.items()},csvrow)
    def fixture(self):
        source={'T':{'layout':[{'name':'N','type':'uint','kind':'scalar','wire_type':'uint','count':1},{'name':'Rates','type':'FP[]','kind':'array','wire_type':'FP','count':2}]}}
        target=r.transfer(source,False)
        src=[{'N':7,'Rates__raw_int64':[1<<32,-(1<<31)]}]
        rows=[{'N':7,'Rates':[1.0,-0.5]}]
        return source,target,src,rows
    def test_array_width_transfer_and_original_unchanged(self):
        src,target,source_rows,rows=self.fixture()
        self.assertEqual(src['T']['layout'][1]['wire_type'],'FP')
        self.assertEqual(target['T']['layout'][1]['wire_type'],'float')
        self.assertEqual(target['T']['layout'][1]['type'],'float[]')
        self.assertEqual(r.check_values(rows,source_rows,src,target,'T'),{'exact_named_value':1,'FP_to_float32_projection':2})
    def test_value_count_and_field_mismatches_rejected(self):
        src,target,srows,rows=self.fixture()
        for bad in [[],[{'N':8,'Rates':[1.0,-0.5]}],[{'N':7,'Rates':[1.0]}],[{'N':7,'Rates':[1.0,0.5]}]]:
            with self.assertRaises(ValueError):r.check_values(bad,srows,src,target,'T')
    def test_nested_leaf_value_mismatch_not_ignored(self):
        source={'T':{'layout':[{'name':'Child','type':'C','kind':'scalar','wire_type':'nested','count':1,'nested_schema':'C'}]},'C':{'layout':[{'name':'X','type':'FP','kind':'scalar','wire_type':'FP','count':1}]}}
        target=r.transfer(source,False)
        a=[{'Child':{'X__raw_int64':1<<32}}]
        b=[{'Child':{'X':1.0}}]
        self.assertEqual(r.check_values(b,a,source,target,'T'),{'FP_to_float32_projection':1})
        b[0]['Child']['X']=2.0
        with self.assertRaises(ValueError):r.check_values(b,a,source,target,'T')

if __name__=='__main__':
    result=unittest.TextTestRunner(stream=sys.stdout,verbosity=2).run(unittest.defaultTestLoader.loadTestsFromTestCase(RecursiveVariantTests))
    raise SystemExit(0 if result.wasSuccessful() else 1)
