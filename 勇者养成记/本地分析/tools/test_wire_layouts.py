"""Host-only tests of the cross-variant candidate decoder; no game code execution."""
import json, struct, unittest, zlib
import recover_wire_layouts as w

def header(payload,count):
    return struct.pack('>5I',0x2def,len(payload)+20,1,count,zlib.crc32(payload)^0xffffffff)+payload

class LayoutTests(unittest.TestCase):
    def setUp(self):
        self.source_fields=[{'name':'ID','type':'uint'},{'name':'Rate','type':'FP'}]
        self.target_fields=[{'name':'ID','type':'uint'},{'name':'Rate','type':'float'}]
    def test_exact_fp_projection_and_roundtrip(self):
        raw=header(struct.pack('>If',7,-1.25),1)
        self.assertEqual(w.check_header(raw),1)
        rows=w.decode(raw,self.target_fields,1)
        checks=w.compare(rows,self.target_fields,[{'ID':7,'Rate__raw_int64':-5*(1<<30)}],self.source_fields)
        self.assertEqual(checks['FP_to_float32_projection'],1)
        self.assertEqual(w.encode(rows,self.target_fields),raw[20:])
    def test_no_epsilon_acceptance(self):
        raw=header(struct.pack('>If',7,1.0),1)
        rows=w.decode(raw,self.target_fields,1)
        with self.assertRaises(ValueError):
            w.compare(rows,self.target_fields,[{'ID':7,'Rate__raw_int64':2*(1<<32)}],self.source_fields)
    def test_utf8_and_opaque_preserved(self):
        fields=[{'name':'ID','type':'int'},{'name':'unknown','type':'opaque4'},{'name':'tail','type':'string'}]
        text='IOS马甲包'.encode('utf-8')+b'\0'
        raw=header(struct.pack('>i',-1)+bytes.fromhex('ff0000fe')+struct.pack('>i',len(text))+text,1)
        rows=w.decode(raw,fields,1)
        self.assertEqual(rows[0]['unknown'],'ff0000fe')
        self.assertEqual(rows[0]['tail'],'IOS马甲包')
        self.assertEqual(w.encode(rows,fields),raw[20:])
    def test_bad_header(self):
        raw=header(b'\0'*8,1)
        for data in [raw[:-1],raw[:19],raw[:20]+b'x'+raw[21:]]:
            with self.assertRaises(ValueError):w.check_header(data)
    def test_version_count_limits_and_csv_precision(self):
        raw=bytearray(header(b'\0'*8,1))
        struct.pack_into('>I',raw,8,2)
        with self.assertRaises(ValueError):w.check_header(raw)
        struct.pack_into('>I',raw,8,1);struct.pack_into('>I',raw,12,1_000_001)
        with self.assertRaises(ValueError):w.check_header(raw)
        self.assertTrue(str(w.csv_safe((1<<63)-1)).startswith("'"))
        self.assertTrue(str(w.csv_safe('=SUM(A1)')).startswith("'"))
        self.assertEqual(w.csv_safe(60.0),60.0)
    def test_bad_payloads(self):
        fields=[{'name':'Text','type':'string'}]
        for data in [struct.pack('>i',0),struct.pack('>i',-1),struct.pack('>i',2)+b'A!',struct.pack('>i',2)+b'\xff\0']:
            with self.assertRaises(ValueError):w.decode(header(data,1),fields,1)
        with self.assertRaises(ValueError):w.decode(header(struct.pack('>I',1)+b'x',1),[{'name':'ID','type':'uint'}],1)
        with self.assertRaises(ValueError):w.decode(header(struct.pack('>f',float('nan')),1),[{'name':'X','type':'float'}],1)
    def test_row_count_and_named_value_mismatch_rejected(self):
        with self.assertRaises(ValueError):w.compare([],self.target_fields,[{'ID':1,'Rate__raw_int64':0}],self.source_fields)
        with self.assertRaises(ValueError):w.compare([{'ID':2,'Rate':0.0,'_record_index':0}],self.target_fields,[{'ID':1,'Rate__raw_int64':0}],self.source_fields)
    def test_archived_candidates_independently_reencoded(self):
        index=json.loads((w.OUT/'layout-index.json').read_text(encoding='utf-8'))
        for item in index:
            if item['status']!=w.STATUS:continue
            raw=(w.ROOT/item['export']).read_bytes()
            doc=json.loads((w.ROOT/item['decoded_json']).read_text(encoding='utf-8'))
            source=json.loads((w.ROOT/item['companion_json']).read_text(encoding='utf-8'))
            self.assertEqual(w.check_header(raw),len(doc['records']))
            self.assertEqual(w.encode(doc['records'],item['fields']),raw[20:])
            self.assertEqual(w.compare(doc['records'],item['fields'],source['records'],source['source']['schema']['fields']),item['named_value_checks'])

if __name__=='__main__':
    import sys
    suite=unittest.defaultTestLoader.loadTestsFromTestCase(LayoutTests)
    result=unittest.TextTestRunner(stream=sys.stdout,verbosity=2).run(suite)
    raise SystemExit(0 if result.wasSuccessful() else 1)
