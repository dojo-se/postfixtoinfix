#!/bin/bash

# Script para facilitar o processo de testes unitários para o Java no Coding Dojo

dir=$(dirname "$0")
cd "$dir" # caminha para o diretório do projeto

testclass="$1"

if [ -d "src" ] && [ -f "test/$testclass.java" ]
then
    rm -rf bin/* 2> /dev/null
    junitpath='/usr/share/java/junit4.jar'

    # Compila os arquivos java com destino para o diretório 'bin'
    javac -cp $junitpath -sourcepath src -d bin "test"/*.java
    # Executa o teste unitário
    java -cp bin:$junitpath org.junit.runner.JUnitCore "$testclass"
else
    echo "Erro nos parâmetros"
fi
