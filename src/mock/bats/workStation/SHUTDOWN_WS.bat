@echo OFF
echo ************************* INICIO SHUTDOWN BAT ************************* 

set serverName=%1
set user=%2
set pwd=%3

cd vendor\PsExec

psexec \\%serverName% -u %user% -p %pwd% -i shutdown -f -p

echo. 
echo ************************* FINAL SHUTDOWN BAT **************************