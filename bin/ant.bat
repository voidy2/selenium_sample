set SCRIPT_DIR=%~dp0
set SELENIUM_TEST_BROWSER=%1
set ANT_HOME=%SCRIPT_DIR%bin\apache-ant-1.8.2/
set PATH=%PATH%;%ANT_HOME%\bin
shift
ant %*
