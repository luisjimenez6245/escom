#include <stdio.h>
#include <stdlib.h>
#include "TADColaDin.h"

/*
01
*/

char getChar();
void isValidProcess(char initialChar);
void destroyProcess(cola *porHacer, cola *listos);
elemento createElemento(int state);
int manageProcess(cola *porHacer, elemento e, char toEval);
void moveToAnswer();

FILE *fp;
FILE *fhelper;
FILE *fanswer;

int main(int argc, const char **argv)
{
    fp = fopen("./file.txt", "r");
    fanswer = fopen("./answer.txt", "w");
    char toWork = (char)fgetc(fp);
    while (toWork != EOF)
    {
        isValidProcess(toWork);
        toWork = (char)fgetc(fp);
    }
    fclose(fp);
    fclose(fanswer);
    return 0;
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
    manageProcess(&listos, createElemento(0), initialChar);
    fhelper = fopen("./helper.txt", "w+");
    while (!Empty(&listos))
    {
        while (!Empty(&listos))
        {
            int helper = manageProcess(&porHacer, Dequeue(&listos), initialChar);
            if (helper == 1)
            {
                moveToAnswer();
                destroyProcess(&porHacer,&listos);
                return;            
            }
            else
            {
                if (helper == -1)
                {
                    destroyProcess(&porHacer,&listos);
                    return;               
                }
            }
        }
        if (toEval == ' ' || toEval == '\n' || toWork == EOF){
            destroyProcess(&porHacer,&listos);
            return;
        }
        while (!Empty(&porHacer))
        {
            Queue(&listos, Dequeue(&porHacer));
        }
        fputc(initialChar, fhelper);
        initialChar = getChar();
    }
    destroyProcess(&porHacer,&listos);
    return;
}

void moveToAnswer()
{
    rewind(fhelper);
    char toWork = (char)fgetc(fhelper);
    while (toWork != EOF)
    {
        fputc(toWork, fanswer);
        toWork = (char)fgetc(fhelper);
    }

    fputc('\n', fanswer);
}

void destroyProcess(cola *porHacer, cola *listos){
    Destroy(porHacer);
    Destroy(listos);
    fclose(fhelper);
    remove("./helper.txt");
}

elemento createElemento(int state)
{
    elemento e;
    e.state = state;
    return e;
}

int manageProcess(cola *porHacer, elemento e, char toEval)
{
    if (e.state == 0)
    {
        if (toEval == '1' || toEval == '0')
        {
            Queue(porHacer, createElemento(0));
            if(toEval == '0'){
                Queue(porHacer, createElemento(1));
            }
        }
    }
    else if(e.state ==1){
        if (toEval == '1')
        {
                        Queue(porHacer, createElemento(2));
        }
    }
    else if (e.state == 2)
    {
        if (toEval == ' ' || toEval == '\n'){
            return 1;
        }
    }
    return 0;
}