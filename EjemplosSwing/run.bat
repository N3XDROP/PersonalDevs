@echo off
title Ejecutar EjemplosSwing (Java)
echo Compilando...
if not exist out mkdir out
javac -d out src\com\julian\ejemploswing\*.java
if %errorlevel% neq 0 (
  echo ❌ Error de compilacion.
  pause
  exit /b
)
echo ✅ Compilacion exitosa.
java -cp out com.julian.ejemploswing.Main
pause