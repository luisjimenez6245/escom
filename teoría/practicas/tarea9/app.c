#include <stdio.h>
#include <stdlib.h>
#include "Const.h"
#include "TADColaDin.h"

/*
Cadena palindroma
Compile: gcc app.c TADColaDin.c Const.c -o a.out
*/

FILE *fp;
FILE *fanswer;
FILE *fstates;

void generateString(char *, int);
boolean isValidProcess();
boolean checkProcess(stack *pila, char toEval, cola* processManager);
char getChar();
stack *cloneStack(stack *, stack );
stack createStack();

int main(int argc, const char **argv)
{
    char *file_name = "./file.txt";
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
    cola processManager;
    InitializeC(&processManager);
    char toWork = getChar();
    elemento e;
    stack s = createStack();
    e.pila = &s;
    element el;
    el.c = toWork;
    Push(e.pila, el);
    QueueC(&processManager, e);
    while (toWork != EOF)
    {
        if(toWork != ' ' && toWork != '\n'){
            int counter = 0 ;
            while (!EmptyC(&processManager))
            {
                printf("counter: %i", counter);
                e = DequeueC(&processManager);
                if(checkProcess(e.pila, toWork, &processManager))
                {
                                        el.c = toWork;
                    Push(e.pila, el);
                }
                else
                {
                    Pop(e.pila);
                }
                ++counter;
            }
        }
        toWork = getChar();
    }
    DestroyC(&processManager);
    return FALSE;
}

stack createStack(){
    stack s;
    Initialize(&s);
    return s;
}

boolean checkProcess(stack *pila, char toEval, cola* processManager)
{
    if (Top(pila).c != toEval)
    {
        stack* s = cloneStack(pila, createStack());
        Pop(s);
        elemento e;
        e.pila = s;
        QueueC(processManager, e);
        return FALSE;
    }
    else
    {
        return TRUE;
    }
}

stack *cloneStack(stack * from, stack to)
{
    stack helper1, helper2;
    Initialize(&helper1);
    Initialize(&helper2);
    while(!Empty(from))
    {
        Push(&helper1, Pop(from));
    }
    while(!Empty(&helper1))
    {
        Push(&helper2, Pop(&helper1));
    }
     while(!Empty(&helper2))
    {
        element el;
        el =  Pop(&helper2);
        Push(from, el);
        Push(&to, el);
    }
    Destroy(&helper1);
    Destroy(&helper2);
    return &to;
}

char getChar()
{
    return (char)fgetc(fp);
}
