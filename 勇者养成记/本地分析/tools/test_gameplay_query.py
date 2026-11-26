"""Read-only tests of local gameplay query semantics and catalog entries."""
import contextlib, io, json, sys, unittest
from unittest.mock import patch
import query_gameplay as q

class GameplayQueryTests(unittest.TestCase):
    def test_nested_and_exact_numeric_filters(self):
        row={'ItemID':11101,'ImpactData':[{'Value':60.0}],'Text':'狼牙长矛'}
        self.assertTrue(q.matches(row,['ItemID=11101','ImpactData.0.Value=60','Text=狼牙长矛']))
        self.assertFalse(q.matches(row,['ItemID=11102']))
        self.assertFalse(q.matches(row,['ImpactData.2.Value=60']))
    def test_missing_fields_fail_closed(self):
        self.assertFalse(q.matches({'A':1},['Missing=1']))
        with self.assertRaises(ValueError):q.matches({'A':1},['A'])
    def test_int64_exact_no_float_coercion(self):
        n=(1<<63)-1
        self.assertTrue(q.matches({'raw':n},['raw='+str(n)]))
        self.assertFalse(q.matches({'raw':n},['raw='+str(n-1)]))
    def test_actual_core_catalog_queries(self):
        catalog=json.loads((q.ROOT/'derived/gameplay-catalog/catalog.json').read_text(encoding='utf-8'))
        expected=[('ResDef.EquipConfig','ItemID=11101','Name','狼牙长矛'),('ResDef.SkillBaseConfg','SkillID=1001','SkillName','剑普攻')]
        for schema,where,key,value in expected:
            with self.subTest(schema=schema):
                tables=[x for x in catalog['tables'] if x.get('schema')==schema and x['status'] in q.NATIVE]
                self.assertEqual(len(tables),1)
                rows=json.loads((q.ROOT/tables[0]['decoded_json']).read_text(encoding='utf-8'))['records']
                hits=[x for x in rows if q.matches(x,[where])]
                self.assertEqual(len(hits),1);self.assertEqual(hits[0][key],value)
    def test_cli_candidate_gate_and_explicit_opt_in(self):
        catalog=json.loads((q.ROOT/'derived/gameplay-catalog/catalog.json').read_text(encoding='utf-8'))
        item=next(x for x in catalog['tables'] if x['status']=='cross-variant-layout-candidate')
        argv=['query_gameplay.py','--table',item['schema'],'--variant',item['variant'],'--limit','1']
        with patch.object(sys,'argv',argv),contextlib.redirect_stderr(io.StringIO()):
            with self.assertRaises(SystemExit) as error:q.run()
        self.assertEqual(error.exception.code,2)
        buf=io.StringIO()
        with patch.object(sys,'argv',argv+['--allow-candidate']),contextlib.redirect_stdout(buf):self.assertEqual(q.run(),0)
        result=json.loads(buf.getvalue())
        self.assertEqual(result['evidence_status'],'cross-variant-layout-candidate')
        self.assertEqual(result['returned_records'],1)
    def test_cli_ambiguous_namespace_rejected(self):
        with patch.object(sys,'argv',['query_gameplay.py','--table','EquipConfig']),contextlib.redirect_stderr(io.StringIO()):
            with self.assertRaises(SystemExit) as error:q.run()
        self.assertEqual(error.exception.code,2)
    def test_candidate_never_counted_native(self):
        catalog=json.loads((q.ROOT/'derived/gameplay-catalog/catalog.json').read_text(encoding='utf-8'))
        candidates=[x for x in catalog['tables'] if x['status']=='cross-variant-layout-candidate']
        self.assertTrue(candidates)
        self.assertTrue(all(x['status'] not in q.NATIVE for x in candidates))

if __name__=='__main__':
    result=unittest.TextTestRunner(stream=sys.stdout,verbosity=2).run(unittest.defaultTestLoader.loadTestsFromTestCase(GameplayQueryTests))
    raise SystemExit(0 if result.wasSuccessful() else 1)
