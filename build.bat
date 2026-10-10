@echo off
if not exist bin mkdir bin
javac -d bin src\com\gdb\domain\*.java src\com\gdb\exceptions\*.java src\com\gdb\tests\*.java
java -cp bin com.gdb.tests.TestInterfaceFactory
pause
