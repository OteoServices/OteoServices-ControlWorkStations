@echo OFF
echo ************************* INICIO WAKEUP BAT ************************* 

set macAddress=%1
set serverName=%2
set subNetMask=%3
set port=%4

::Prod
cd vendor\Wolcmd
::Test
::cd ..\OteoServices-ControlWorkStations\src\mock\vendor\Wolcmd

wolcmd %macAddress% %serverName% %subNetMask% %port%

ECHO.
echo ************************* FINAL WAKEUP BAT **************************
