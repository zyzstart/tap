; RVA 0x1753bf0, file offset 0x1753bf0, conservative end 0x1753c04
; SHA256 3e26ba758381590817a887a50f5521a69794cf6676063da62cbae0eca0bee10a
; All aliases at this entry: A3BattleCore.ActorAttrImpactMgr$$SetDirty :: void A3BattleCore_ActorAttrImpactMgr__SetDirty (A3BattleCore_ActorAttrImpactMgr_o* __this, const MethodInfo* method);
; Upper bound = next distinct known executable method start / segment end / 64 KiB cap.
; Linear decode; branch edges beyond bound are tail calls or unresolved extents, not auto-merged.
01753bf0  000840f9  ldr      x0, [x0, #0x10]
01753bf4  600000b4  cbz      x0, #0x1753c00
01753bf8  e1031faa  mov      x1, xzr
01753bfc  0dc22914  b        #0x21c4430 ; System.Action$$Invoke
01753c00  c0035fd6  ret      
