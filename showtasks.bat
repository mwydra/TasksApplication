call runcrud.bat
if %ERRORLEVEL% == 0 goto start
echo.
echo RUNCRUD has errors - breaking work

:start
start chrome http://localhost:8080/crud/v1/task/getTasks

:end
echo.
echo Work is finished