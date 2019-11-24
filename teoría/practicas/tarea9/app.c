#include <stdio.h>
#include <stdlib.h>
#include "Const.h"
#include "TADPilaDin.h"
#include "TADColaDin.h"

/*
Cadena 0000000000011111111111
Compile: gcc app.c TADPilaDin.c TADColaDin.c Const.c -o a.out
*/

FILE *fp;
FILE *fanswer;
FILE *fstates;

void generateString(char *, int);
boolean isValidProcess();
boolean checkProcess(stack *, char);
char getChar();
stack* cloneStack(stack* , stack*);

int main(int argc, const char **argv)
{
    char *file_name = "./file.txt";
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
    stack container, container1, container2;
    Initialize(&container);
    char toWork = getChar();
    while (toWork != EOF)
    {
        toWork = getChar();
    }
    return FALSE;
}
boolean checkProcess(stack* pila, char toEval){
    if(Top(pila).c == toEval)
    {

    }
    else
    {

    }
}

stack* cloneStack(stack* , stack*)
{

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