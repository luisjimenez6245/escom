#include <stdio.h>
#include <stdlib.h>
#include "TADColaDin.h"

/*

*/

char getChar();
void fillContainer();
void isValidProcess(char initialChar);
void destroyProcess(cola *porHacer, cola *listos);
elemento createElemento(int x, int y);
int manageProcess(cola *porHacer, elemento e, char toEval);
void moveToAnswer(elemento e);
elemento getEntity(int startX, int startY, int evitX, int evitY, char toSearch);
FILE *fp;
FILE *fhelper;
FILE *fanswer;
char matrixContainer[3][3];

int main(int argc, const char **argv)
{
    fillContainer();
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

void fillContainer()
{
    int i, j, counter = 0;
    for (i = 0; i < 3; ++i)
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
                    printf("%c \t",matrixContainer[i][j] );
            ++counter;
        }
        printf("\n");
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
    manageProcess(&listos, createElemento(0, 0), initialChar);
    fhelper = fopen("./helper.txt", "w+");
    while (!Empty(&listos))
    {
        printf("%c \n", initialChar);
        while (!Empty(&listos))
        {
            manageProcess(&porHacer, Dequeue(&listos), initialChar);
        }
        if (initialChar == ' ' || initialChar == '\n' || initialChar == EOF)
        {
            while (!Empty(&porHacer))
            {
                elemento e = Dequeue(&porHacer);
                printf("x = %i , y = %i\n", e.x, e.y);
                if (e.x == 2 && e.y == 2)
                {
                    moveToAnswer(e);
                }
            }
            destroyProcess(&porHacer, &listos);
            return;
        }
        while (!Empty(&porHacer))
        {
            Queue(&listos, Dequeue(&porHacer));
        }
        initialChar = getChar();
    }
    printf("aaaaalc\n");
    destroyProcess(&porHacer, &listos);
    return;
}

void moveToAnswer(elemento e)
{
    printf("x = %i , y = %i\n", e.x, e.y);
    /*rewind(fhelper);
    char toWork = (char)fgetc(fhelper);
    while (toWork != EOF)
    {
        fputc(toWork, fanswer);
        toWork = (char)fgetc(fhelper);
    }
    fputc('\n', fanswer);*/
}

void destroyProcess(cola *porHacer, cola *listos)
{
    Destroy(porHacer);
    Destroy(listos);
    fclose(fhelper);
    remove("./helper.txt");
}

elemento createElemento(int x, int y)
{
    elemento e;
    e.x = x;
    e.y = y;
    return e;
}

int manageProcess(cola *porHacer, elemento e, char toEval)
{
    elemento elaux = e;
    elaux.x = elaux.x -2;
    elaux.y = elaux.y -2;
    int parent = e.parent, i = 0;
    while (elaux.x != -3 && elaux.y != -3)
    {
        printf("--> x = %i , y = %i\n", elaux.x, elaux.y);
        elaux = getEntity(elaux.x + 1, elaux.y, e.x, e.y, toEval);
        if ( elaux.x != -3 && elaux.y != -3)
        {
            printf("x = %i , y = %i\n", elaux.x, elaux.y);
            elaux.parent = parent;
            elaux.line = i;
            Queue(porHacer, elaux);
            ++i;
        }
    }
    return 0;
}

elemento getEntity(int startX, int startY, int evitX, int evitY, char toSearch)
{
    int i, j;
    if (startX < 0)
    {
        startX = 0;
    }
    if (startX > 3)
    {
        startX = 0;
        startX = startY + 1;
    }
    if (startY < 0)
    {
        startY = 0;
    }
    for (i = startY; i < 3; ++i)
    {
        for (j = startX; j < 3; ++j)
        {
            if(j >= (evitY + 1))
                break;
            if(j <= (evitY - 1))
                break;
            if (matrixContainer[i][j] == toSearch && i != evitY && j != evitX){
                return createElemento(i, j);
            }
            
        }
        if(i > evitX + 1)
            break;
    }
    return createElemento(-3, -3);
}