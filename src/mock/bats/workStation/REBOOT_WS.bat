@echo OFF
echo ************************* INICIO REBOOT BAT *************************

set serverName=%1
set user=%2
set pwd=%3

::Prod
cd vendor\PsExec
::Test
::cd ..\OteoServices-ControlWorkStations\src\mock\vendor\PsExec

psexec \\%serverName% -u %user% -p %pwd% -i shutdown -r -t 2

echo.
echo ************************* FINAL REBOOT BAT ************************** 