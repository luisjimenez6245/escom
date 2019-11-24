#include <stdio.h>
#include <stdlib.h>
#include "TADPilaDin.h"

/*
Cadena 0000000000011111111111
Compile: gcc app.c TADPilaDin.c -o a.out
*/

FILE *fp;
FILE *fanswer;
FILE *fstates;

void generateString(char *, int);
boolean isValidProcess();
char getChar();

int main(int argc, const char **argv)
{
    char *file_name = "./prime.txt";
    if (argc == 2)
    {
        int n = atoi(argv[1]);
        generateString(file_name, n);
    }
    fp = fopen(file_name, "r");
    if (isValidProcess())
    {
        printf("Cadena valida\n");
    }
    else
    {
        printf("Cadena no valida\n");
    }
    fclose(fp);
    return 0;
}

boolean isValidProcess()
{
    stack container;
    Initialize(&container);
    char toWork = getChar();
    element e;
    while (toWork != EOF)
    {
        while (toWork == '0')
        {
            e.c = 'x';
            Push(&container, e);
            toWork = getChar();
        }
        while (toWork == '1')
        {
            if (!Empty(&container))
            {
                Pop(&container);
                toWork = getChar();
            }
            else
            {
                Destroy(&container);
                return FALSE;
            }
        }
        toWork = getChar();
    }
    if (Empty(&container))
    {
        Destroy(&container);
        return TRUE;
    }
    else
    {
        Destroy(&container);
        return FALSE;
    }
}

char getChar()
{
    return (char)fgetc(fp);
}

void generateString(char *fileName, int number)
{
    FILE *generate;
    generate = fopen(fileName, "w");
    int i;
    printf("Generado cadena");
    if (number % 2 == 1)
        ++number;
    for (i = 0; i < (number / 2); ++i)
    {
        fputc('0', generate);
    }
    if (number % 2 == 1)
        ++number;
    for (i = 0; i < (number / 2); ++i)
    {
        fputc('1', generate);
    }
    fputc('\n', generate);
    fclose(generate);
}