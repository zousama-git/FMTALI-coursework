@echo off
chcp 65001 > nul
cd /d "%~dp0BMI Calculator"
javac -d . Main.java utils\*.java
java Main
pause