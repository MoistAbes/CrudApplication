call runcrud.bat
if  "%ERRORLEVEL%" == "0" goto openwebbrowser
echo.
echo runcrud.bat error




:openwebbrowser
start "" http://localhost:8080/crud/v1/tasks
goto end




:end
echo.
echo Work is finished
