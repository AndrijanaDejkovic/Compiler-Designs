@echo off
REM ********   PODESAVANJA - MENJA STUDENT *********
set JCUP_HOME="C:\Users\Andrijana\Desktop\cup"
set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_311"
set PARSER_CLASS_NAME="MPParser"
set CUP_SPEC_NAME="MPParser.cup"


REM ********   POZIV JAVA CUP APLIKACIJE  ***********
@echo on
%JAVA_HOME%\bin\java -classpath %JCUP_HOME% java_cup.Main -parser %PARSER_CLASS_NAME% -symbols sym < %CUP_SPEC_NAME%

PAUSE
