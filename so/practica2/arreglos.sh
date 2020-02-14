#!/bin/bash

#author: Luis Diego Jiménez Delgado

array[0]=15
array[1]=12
array[2]=1
array[3]=10
array[4]=9


echo "el tamaño del arreglo es: ${#array[*]}"
echo "el contenido del arreglo es: ${array[*]}"
echo "el primer valor del arreglo es: ${array[0]}"

for i in ${array[*]}
do
    echo "$i"
done