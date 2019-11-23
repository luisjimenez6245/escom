#include <stdio.h>
#include <stdlib.h>
#include "TADPilaDin.h"

/*
Cadena 0000000000011111111111
*/

FILE *fp;
FILE *f_answer;

void generateString(char *, int );
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
    if(isValidProcess()){
            printf("Cadena valida\n");
    }
    else{
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
    int c = 0;
    element e;
    while (toWork != EOF)
    {
        while(toWork == '0')
        {
            e.c = 'x';
            ++c;
            printf("%i\n", c);
            Push(&container, e);
            toWork = getChar();
        }
        while(toWork == '1' && !Empty(&container))
        {
            --c;
            printf("%i\n", c);
            Pop(&container);
            toWork = getChar();
        }
        toWork = getChar();
    }
    if(Empty(&container))
    {
        Destroy(&container);
        return TRUE;
    }
    else
    {
        Destroy(&container);
        return TRUE;
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
    if(number % 2 == 1)
        ++number;
    for(i = 0; i < (number/2); ++i)
    {
        fputc('0', generate);
    }
    for(i = 0; i < (number/2); ++i)
    {
        fputc('1', generate);
    }
    fputc('\n', generate);
    fclose(generate);
}