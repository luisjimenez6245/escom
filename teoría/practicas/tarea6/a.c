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
void manageProcess(elemento e, char toEval);
void moveToAnswer(elemento e);
elemento fixElement(elemento toFix);
elemento getEntity(elemento reference, elemento lastFound, char toSearch);
int coordToInt(int x, int y);

void shouldAccept(cola *porHacer, elemento e);

FILE *fp;
FILE *fanswer;
int line = 0;
int turn = 0;

char matrixContainer[3][3];

int main(int argc, const char **argv)
{
    fillContainer();
    fp = fopen("./file.txt", "r");
    fanswer = fopen("./answer.txt", "w");
    char toWork = (char)fgetc(fp);
    while (toWork != EOF)
    {
        elemento e;
        e = createElemento(1, 1);
        manageProcess(e, toWork);
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
                matrixContainer[i][j] = 'b';
            }
            else
            {
                matrixContainer[i][j] = 'r';
            }
            printf("%c \t", matrixContainer[i][j]);
            ++counter;
        }
        printf("\n");
    }
}

char getChar()
{
    line = 0;
    turn = (turn +1) %2;
    return (char)fgetc(fp);
}

void isValidProcess(char initialChar)
{

    return;
}

void manageProcess(elemento e, char toEval)
{
    elemento aux = e;
    aux.x = aux.x -1;
    aux.y = aux.y -1;

    while (aux.x != -3 && aux.y != -3)
    {
        aux = getEntity(e, aux, toEval);
        if(aux.x != -3 && aux.y != -3){
            printf("x= %i, y = %i , val = %i\n", aux.x, aux.y ,coordToInt(aux.x, aux.y) );
        }
    }
}

void shouldAccept(cola *porHacer, elemento e)
{
    cola helper;
    boolean valid = TRUE;
    Initialize(&helper);
    while (!Empty(porHacer))
    {
        elemento el =  Dequeue(porHacer);
        if (e.x == el.x && e.y == el.y)
        {
            valid = FALSE;
        }
        Queue(&helper, el);
    }
    if(valid)
    {
        Queue(&helper, e);
    }
    while (!Empty(&helper))
    {
        elemento el =  Dequeue(&helper);
        Queue(porHacer, el);
    }
    Destroy(&helper);
}

elemento getEntity(elemento reference, elemento lastFound, char toSearch)
{
    elemento e = fixElement(lastFound);
    int startX = e.x;
    int startY = e.y;
    int i, j;
    if(toSearch == 'b')
    {
        printf("startY = %i, startX = %i\n", startY, startX);
    }
    for (i = startY; i < 3; i++)
    {
        if((i > (reference.y + 1)) || (i < (reference.y - 1))){
            break;
        }
        for (j = startX; j < 3; j++)
        {
            if(toSearch == 'b' && i == 0 && j == 0 && toSearch ==  matrixContainer[i][j])
            {
                printf("-->startY = %i, startX = %i\n", startY, startX);
            }
            if ((j > (reference.x + 1)) || (j < (reference.x - 1)))
            {
                break;
            }
            if (matrixContainer[i][j] == toSearch && (i != startY && j != e.x))
            {
                                printf("----->startY = %i, startX = %i\n", startY, startX);

                return createElemento(j, i);
            }
        }
        startX = 0;
    }
    return createElemento(-3, -3);
}

elemento fixElement(elemento toFix)
{
    elemento e;
    e.x = toFix.x;
    e.y = toFix.y;
    e.line = toFix.line;
    e.parent = toFix.parent;
    if (toFix.x < 0)
        e.x = 0;
    if (toFix.y < 0)
        e.y = 0;
    else
    {
        if (toFix.x > 2)
        {
            e.x = 0;
            e.y = e.y + 1;
        }
    }
    return e;
}

void destroyProcess(cola *porHacer, cola *listos)
{
    Destroy(porHacer);
    Destroy(listos);
}

int coordToInt(int x, int y)
{
    int i, j, counter = 1;
    for (i = 0; i < 3; ++i)
    {
        for (j = 0; j < 3; ++j)
        {
            if (i == y && j == x)
            {
                return counter;
            }
            ++ counter;
        }
    }
    return 0;
}

elemento createElemento(int x, int y)
{
    elemento e;
    e.x = x;
    e.y = y;
    e.parent = 0;
    e.line = 0;
    return e;
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