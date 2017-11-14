
set projectLocation=C:\GitHub\test-automation

cd %MAVEN_HOME%

cd %projectLocation%

java org.testng.TestNG %projectLocation%\MC_Sanity_TestSuite.xml
pause

