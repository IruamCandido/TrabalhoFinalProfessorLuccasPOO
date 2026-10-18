@REM ----------------------------------------------------------------------------
@ondas Apache Maven Wrapper startup script for Windows
@REM ----------------------------------------------------------------------------

@setlocal

set MAVEN_PROJECT_BASEDIR=%~dp0
mvn -version >nul 2>&1
if %ERRORLEVEL% EQU 0 (
    goto run
)

echo Apache Maven is not installed. Please install Maven or use an IDE with Maven support.
exit /b 1

:run
mvn %*
endlocal