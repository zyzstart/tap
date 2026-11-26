param(
    [ValidateSet('Extract','Android','Unity','Native','Dump','Index','ParserCalls','ResBin','ResBinExtended','Variants','RecursiveVariants','Catalog','Algorithms','GameplayValidate','Validate','SelfTest','Verify')][string]$Stage = 'Verify',
    [string]$Python = 'C:\Users\Admin\.dsh\dsh-runtimes\dsh-primary-runtime\dependencies\python\python.exe',
    [ValidateSet('arm64-v8a','armeabi-v7a')][string]$Abi = 'arm64-v8a'
)
$ErrorActionPreference = 'Stop'
$Root = Split-Path $PSScriptRoot -Parent
$Project = Split-Path $Root -Parent
$Apk = Join-Path $Project 'com.tencent.tmgp.yzycj_227.apk'
$env:PYTHONUTF8 = '1'
$env:PYTHONDONTWRITEBYTECODE = '1'
# Trusted analysis tools only. This script never installs or launches the APK.
# Extract/analysis stages regenerate derived outputs. Verify is the default.
if (-not (Test-Path -LiteralPath $Python -PathType Leaf)) { throw 'Provide the installed Python 3.12 executable using -Python.' }
$ScriptMap = @{'Extract'='extract_apk.py';'Android'='analyze_android.py';'Unity'='analyze_unity.py';'Native'='analyze_native.py';'Index'='index_il2cpp.py';'ParserCalls'='inspect_unpack_calls.py';'ResBin'='decode_resbin.py';'ResBinExtended'='decode_resbin_extended.py';'Variants'='recover_wire_layouts.py';'RecursiveVariants'='recover_recursive_variants.py';'Catalog'='build_gameplay_catalog.py';'Algorithms'='recover_client_algorithms.py';'GameplayValidate'='validate_gameplay_outputs.py';'Validate'='validate_outputs.py';'SelfTest'='test_extractor.py';'Verify'='verify_archive.py'}
Push-Location $Project
try {
    if ($Stage -eq 'Dump') {
        $Dumper = Join-Path $PSScriptRoot 'il2cppdumper\Il2CppDumper.dll'
        $So = Join-Path $Root "unpacked\lib\$Abi\libil2cpp.so"
        $Metadata = Join-Path $Root 'unpacked\assets\bin\Data\Managed\Metadata\global-metadata.dat'
        $Destination = Join-Path $Root "derived\il2cpp\$Abi"
        New-Item -ItemType Directory -Force -Path $Destination | Out-Null
        & dotnet $Dumper $So $Metadata $Destination
    } elseif ($Stage -eq 'Extract') {
        & $Python (Join-Path $PSScriptRoot $ScriptMap[$Stage]) $Apk
    } else {
        & $Python (Join-Path $PSScriptRoot $ScriptMap[$Stage])
    }
    if ($LASTEXITCODE -ne 0) { throw "Stage $Stage returned exit code $LASTEXITCODE; inspect logs and do not treat it as complete." }
} finally { Pop-Location }
