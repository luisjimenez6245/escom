#include <stdio.h>
#include <stdlib.h>
#include "TADPilaDin.h"

/*
Cadena palindroma
Compile: gcc app.c TADPilaDin.c -o a.out
*/

char getChar();
void getString();
int getRandomNumber(int number);
int selectType();
int getBool();
void manageProcess();

FILE *fanswer;
FILE *fstates;
int length;

int main(int argc, const char **argv)
{
    int n = 100;
    arc4random();
    if (argc == 2)
    {
        n = atoi(argv[1]);
    }
    length = getRandomNumber(n);
    fanswer = fopen("./answer.txt", "w");
    manageProcess();
    fclose(fanswer);
    return 0;
}
void manageProcess()
{
    stack pila;
    Initialize(&pila);
    int type = selectType();
    element e;
    if (type == 1)
    {
        length = length - 2;
    }
    else
    {
        if (type == 2)
        {
            length = length - 2;
        }
        else
        {
            if (type == 3)
            {
                length = length - 1;
            }
            else
            {
                length = length - 1;
            }
        }
    }
    while (length >= 0)
    {
        if (getBool())
        {
            e.c = '0';
            Push(&pila, e);
            fputc('0', fanswer);
        }
        else
        {
            if (getBool())
            {
                e.c = '1';
                Push(&pila, e);
                fputc('1', fanswer);
            }
        }
        --length;
    }
    if (type == 1)
    {
        e.c = '0';
        Push(&pila, e);
        e.c = 'S';
        Push(&pila, e);
    }
    else
    {
        if (type == 2)
        {
            e.c = '1';
            Push(&pila, e);
            e.c = 'S';
            Push(&pila, e);
        }
        else
        {
            if (type == 3)
            {
                e.c = '0';
                Push(&pila, e);
            }
            else
            {
                e.c = '0';
                Push(&pila, e);
            }
        }
    }
    while (!Empty(&pila))
    {
        e = Pop(&pila);
        fputc(e.c, fanswer);
    }
    Destroy(&pila);
}
int selectType()
{
    return getRandomNumber(5);
}

int getBool()
{
    return getRandomNumber(2);
}

int getRandomNumber(int number)
{
    int res = rand();
    if (number > 0)
        res = rand() % number;
    return res;
}