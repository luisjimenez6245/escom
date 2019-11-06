#include <stdio.h>
#include <stdlib.h>
#include "TADColaDin.h"

int main(){
    char a [] = "rbrbr";
    for
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
    elaux.x = elaux.x -1;
    elaux.y = elaux.y -1;
    int parent = e.parent, i = 0;
    while (elaux.x != -1 && elaux.y != -1)
    {
        elaux = getEntity(elaux.x, elaux.y, elaux.x , elaux.y , toEval);
        if ( elaux.x != -1 && elaux.y != -1)
        {
            printf("x = %i , y = %i\n", e.x, e.y);
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
    if (startY < 0)
    {
        startY = 0;
    }
    for (i = startX; i < 3; ++i)
    {
        for (j = startY; j < 3; ++j)
        {
            if (matrixContainer[i][j] == toSearch && i != evitX && j != evitY){
                printf("x = %i , y = %i\n", i, j);
                return createElemento(i, j);
                }
        }
    }
    return createElemento(-1, -1);
}