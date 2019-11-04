#include <stdio.h>
#include <stdlib.h>
#include "TADColaDin.h"

/*

*/

FILE *fp;
int lengthProcArr;

int main(int argc, const char **argv)
{
    char *fileName = "./file.txt";
    fp = fopen(fileName, "r");
    char toWork = (char)fgetc(fp);
    while (toWork != EOF)
    {
        isValidProcess(toWork);
        toWork = (char)fgetc(fp);
    }
    fclose(fp);
    return 0;
}

char getChar()
{
    return  (char)fgetc(fp);
}

void isValidProcess(char initialChar)
{
    cola listos, porHacer;
    Initialize(&listos);
    Initialize(&porHacer);
    manageProcess(&porHacer, createElemento(0));
    while (!Empty(&listos))
    {
        while (!Empty(&listos))
        {
            if (manageProcess(&porHacer, Dequeue(&listos)))
            {
            }
            else
            {
            }
        }
        if (!Empty(&porHacer))
        {
            while (!Empty(&porHacer))
            {
                Queue(&listos, Dequeue(&porHacer));
            }
        }
        initialChar 
    }
    Destroy(&finalizados);
    Destroy(&listos);
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
        if (toEval == '0')
        {
        }
        else
        {
            
        }
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