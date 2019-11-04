#include <stdio.h>
#include <stdlib.h>
#include "TADColaDin.h"

/*

*/

FILE *fp;
int lengthProcArr;
char matrixContainer[3][3];

int main(int argc, const char **argv)
{
    char *fileName = "./file.txt";
    fp = fopen(fileName, "r");
    char toWork = (char)fgetc(fp);
    fillContainer();
    while (toWork != EOF)
    {
        isValidProcess(toWork);
        toWork = (char)fgetc(fp);
    }
    fclose(fp);
    return 0;
}

void fillContainer()
{
    int i, j, counter = 0;
    for (i (i = 0; i < 3; ++i)
    {
        for (j = 0; j < 3; ++j)
        {
            if (counter % 2 == 0)
            {
                matrixContainer[i][j] = 'r';
            }
            else
            {
                matrixContainer[i][j] = 'b';
            }
            ++counter;
        }
    }
}

char getChar()
{
    return (char)fgetc(fp);
}

void isValidProcess(char initialChar)
{
    cola listos, porHacer;
    Initialize(&listos);
    Initialize(&porHacer);
    manageProcess(&porHacer, createElemento(0));
    while (!Empty(&listos))
    {
        if (initialChar == 'r' || initialChar == 'b')
        {
            manageCola(&listos, &porHacer, initialChar)
        }
        else
        {
        }
        initialChar = getChar();
    }
    Destroy(&finalizados);
    Destroy(&listos);
}

void manageCola(cola *listos, cola *porHacer, char c)
{
    while (!Empty(listos))
    {
        if (manageProcess(porHacer, Dequeue(listos)))
        {
        }
        else
        {
            //printf("");
        }
    }
    if (!Empty(porHacer))
    {
        while (!Empty(porHacer))
        {
            Queue(listos, Dequeue(porHacer));
        }
    }
}

elemento createElemento(int x, int y)
{
    elemento e;
    e.x = x;
    e.y = y;
    return e;
}

boolean manageProcess(cola *porHacer, elemento e, char toEval)
{
    if (toEval == 'r')
    {
        e
    }
    else
    {
    }
}

elemento getEntity(int startX, int startY, char toSearch)
{
    int i, j;
    if
    for (i = 0; i < 3; ++i)
    {
        for (j = startY; j < 3; ++j)
        {
            if (matrixContainer[i][j] == toSearch)
                return createElemento(i, j);
        }
    }
    return NULL;
}