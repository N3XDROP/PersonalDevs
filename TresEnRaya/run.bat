@echo off
title Ejecutar TresEnRaya (Proyecto Java)
echo ==========================================
echo  Compilando proyecto TresEnRaya...
echo ==========================================

rem Crear carpeta de salida si no existe
if not exist out mkdir out

rem Compilar todos los archivos Java
javac -d out src\com\julian\tresenraya\*.java

if %errorlevel% neq 0 (
  echo.
  echo ❌ Error de compilacion. Revisa el codigo en src\com\julian\tresenraya\
  pause
  exit /b
)

echo.
echo ✅ Compilacion exitosa.
echo ==========================================
echo  Ejecutando programa...
echo ==========================================
echo.

java -cp out com.julian.tresenraya.Main

echo.
echo ==========================================
echo  Programa finalizado.
echo ==========================================
pause
