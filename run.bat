
set projectLocation=C:\GitHub\test-automation
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\MC_Sanity_TestSuite.xml
pause

