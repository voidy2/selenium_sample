set SCRIPT_DIR=%~dp0
java -XX:MaxPermSize=256m -Xmx512M -jar "%SCRIPT_DIR%sbt-launch.jar" %*
