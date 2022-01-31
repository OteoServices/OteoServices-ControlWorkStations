@echo OFF
echo **Conexion remota a ZOTAC se inicio correctamente**
echo.

set serverName=%1

mstsc /v:%serverName%

echo **Conexion remota con ZOTAC se termino correctamente**
echo.