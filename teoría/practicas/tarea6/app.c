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
    boolean isValidString = FALSE;
    while (!Empty(&listos))
    {
        if (initialChar == '0' || initialChar == '1')
        {
            isValidString = manageCola(&listos, &porHacer, initialChar)
        }
        else
        {
            if(isValidString)
            {
                
            }
        }
        initialChar = getChar();
    }
    Destroy(&finalizados);
    Destroy(&listos);
}

boolean manageCola(cola *listos, cola *porHacer, char c)
{
    while (!Empty(listos))
    {
        if (manageProcess(porHacer, Dequeue(listos)))
        {
        }
        else
        {
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

elemento createElemento(int state)
{
    elemento e;
    e.state = state;
}

boolean manageProcess(cola *porHacer, elemento e, char toEval)
{
    if (e.state == 0)
    {
    }
    else if (e.state == 1)
    {
        if ()
    }
    else if (e.state == 2)
    {
    }
    else if (e.state == 3)
    {
    }
    else if (e.state == 4)
    {
        return TRUE;
    }
    return FALSE;
}