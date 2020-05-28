#!/bin/bash

#author: Luis Diego Jiménez Delgado

function suma
{
    a=`expr $1 + $2`
    echo "la suma de $1 y de $2 es $a"
    if [ $1 -gt $2 ]
    then 
        echo "$1 es mayor que $2"
    else
        echo "$2 es mayor que $1"
    fi
}

echo "El numero de argumentos es $#"
echo "Los argumentos son: $*"
echo "El argumento 1 es $1"
suma $1 $2

for i in `ls`
do 
    echo "Archivo: $i"
done

for i in `seq 0 5`
do 
    echo "$i"
done