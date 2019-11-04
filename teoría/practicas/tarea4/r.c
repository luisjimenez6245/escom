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
        printf("%c", toWork);
        toWork = (char)fgetc(fp);
    }
    fclose(fp);
    return 0;
}

void isValidProcess()
{
    cola listos, porHacer;
    Initialize(&listos);
    Initialize(&porHacer);
    while (!Empty(&listos))
    {
        while (!Empty(&listos))
        {
            if(manageProcess(&porHacer, Dequeue(&listos)))
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
    }
    Destroy(&finalizados);
    Destroy(&listos);
}

boolean manageProcess(cola *porHacer, elemento e)
{
    if(e.state == 4)
    {
        return FALSE;
    }
}