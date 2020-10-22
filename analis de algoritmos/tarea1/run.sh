#!/bin/bash

array[0]=-1
array[1]=0
array[2]=1
array[3]=2
array[4]=3
array[5]=5
array[6]=15
array[7]=20
array[8]=100
array[9]=409
array[10]=500
array[11]=593
array[12]=1000
array[13]=1471
array[14]=1500
array[15]=2801
array[16]=3000
array[17]=5000
array[18]=10000
array[19]=20000


echo "" > "./$1/res.txt"
for i in ${array[*]}
do
    ./$1/a.out "$i" >> "./$1/res.txt"
    echo "" >> "./$1/res.txt"
done

