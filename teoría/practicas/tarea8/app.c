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
void printStack(stack *from);

int main(int argc, const char **argv)
{
    char *file_name = "./prime.txt";
    if (argc == 2)
    {
        int n = atoi(argv[1]);
        generateString(file_name, n);
    }
    fp = fopen(file_name, "r");
    fstates = fopen("states.txt", "w");
    fanswer = fopen("answer.txt", "w");
    if (isValidProcess())
    {
        printf("Cadena valida\n");
    }
    else
    {
        printf("Cadena no valida\n");
    }
    fclose(fanswer);
    fclose(fstates);
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
            printStack(&container);
            toWork = getChar();
        }
        while (toWork == '1')
        {
            if (!Empty(&container))
            {
                Pop(&container);
                printStack(&container);
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
    printf("Generado cadena\n");
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

void printStack(stack *from)
{
    stack helper1, helper2;
    Initialize(&helper1);
    Initialize(&helper2);
    printf("\nPila\n");
    while (!Empty(from))
    {
        element el;
        el = Pop(from);
        printf("-------\n");
        printf("---%c---\n", el.c);
        printf("-------\n");
        Push(&helper1, el);
    }
    printf("-------\n\n");
    while (!Empty(&helper1))
    {
        Push(&helper2, Pop(&helper1));
    }
    while (!Empty(&helper2))
    {
        element el;
        el = Pop(&helper2);
        Push(from, el);
    }
    Destroy(&helper1);
    Destroy(&helper2);
}