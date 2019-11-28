#include <stdio.h>
#include <stdlib.h>
#include "TADListaDL.h"

/*
Maquina de Turing para 000111
Compile: gcc app.c TADListaDL.c -o a.out
*/

typedef struct container
{
    int to;
    char change;
    int state;
} container;

FILE *fp;
FILE *fanswer;
FILE *fstates;
int aState;

container evaluation(char c, int state);
container evaluation0(int state);
container evaluation1(int state);
container evaluationX(int state);
container evaluationY(int state);
container evaluationB(int state);

boolean validChar(char c);
boolean isValidProcess();

char getChar();

void stateChange(int from, int to);
void generateString();
void generateString(char *, int);
void printContainer(container c);
void printChanges(lista* l);

int getBool();
int getRandomNumber(int number);

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
    lista l;
    Initialize(&l);
    container con;
    elemento e;
    posicion p;
    int counter = 0;
    con.state = 0;
    char c = getChar();
    e.c = c;
    Add(&l, e);
    con.to = 1;
    while (con.state != 4 && validChar(c))
    {
        printChanges(&l);
        aState = con.state;
        con = evaluation(c, con.state);
        if (con.state >= 4)
        {
            stateChange(aState, 4);
            break;
        }
        stateChange(aState, con.state);
        e.c = con.change;
        Replace(&l, ElementPosition(&l, counter + 1), e);
        counter += con.to;
        if (con.to == 1)
        {
            if ((Size(&l) - 1) < counter)
            {
                c = getChar();
                if (validChar(c))
                {
                    e.c = c;
                    Add(&l, e);
                }
                else
                {
                    c = 'B';
                }
            }
            else
            {
                p = ElementPosition(&l, counter + 1);
                c = Position(&l, p).c;
            }
        }
        else
        {
            if (Size(&l) < counter)
            {
                c = 'B';
            }
            else
            {
                p = ElementPosition(&l, counter + 1);
                c = Position(&l, p).c;
            }
        }
    }
    if (con.state == 4 && !validChar(getChar()))
    {
        while (!Empty(&l))
        {
            p = First(&l);
            fputc(Position(&l, p).c, fanswer);
            Remove(&l, p);
        }
        Destroy(&l);
        return TRUE;
    }
    Destroy(&l);
    return FALSE;
}

container evaluation(char c, int state)
{
    container res;
    if (c == '0')
    {
        res = evaluation0(state);
    }
    else if (c == '1')
    {
        res = evaluation1(state);
    }
    else if (c == 'X')
    {
        res = evaluationX(state);
    }
    else if (c == 'Y')
    {
        res = evaluationY(state);
    }
    else if (c == 'B')
    {
        res = evaluationB(state);
    }
    return res;
}

container evaluation0(int state)
{
    container res;
    if (state == 0)
    {
        res.change = 'X';
        res.state = 1;
        res.to = 1;
    }
    else if (state == 1)
    {
        res.change = '0';
        res.state = 1;
        res.to = 1;
    }
    else if (state == 2)
    {
        res.change = '0';
        res.state = 2;
        res.to = -1;
    }
    return res;
}

container evaluation1(int state)
{
    container res;
    res.state = 5;
    if (state == 1)
    {
        res.change = 'Y';
        res.state = 2;
        res.to = -1;
    }
    return res;
}

container evaluationX(int state)
{
    container res;
    res.state = 5;
    if (state == 2)
    {
        res.change = 'X';
        res.state = 0;
        res.to = 1;
    }
    return res;
}

container evaluationY(int state)
{
    container res;
    res.change = 'Y';
    res.to = 1;
    if (state == 0)
    {
        res.state = 3;
    }
    else if (state == 1)
    {
        res.state = 1;
    }
    else if (state == 2)
    {
        res.state = 2;
        res.to = -1;
    }
    else if (state == 3)
    {
        res.state = 3;
    }
    return res;
}

container evaluationB(int state)
{
    container res;
    res.state = 5;
    if (state == 3)
    {
        res.change = 'B';
        res.state = 4;
        res.to = 1;
    }
    return res;
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

void printContainer(container c)
{
    printf("\nc: %c\n", c.change);
    printf("state: %d \n", c.state);
    printf("to: %i\n", c.to);
}

boolean validChar(char c)
{
    return (c != '\n' && c != '\t' && c != EOF && c != ' ');
}

void printChanges(lista *l)
{
    int i = 0;
    printf("Cinta \n");
    for(i  = 0; i < Size(l); ++i)
    {
        printf("-------\n");
        printf("---%c---\n", (Position(l,ElementPosition(l, i + 1)).c));
        printf("-------\n");
    }
    printf("-------\n\n");

}

void stateChange(int from, int to)
{
    fprintf(fstates, "q%i -> q%i\n", from, to);
}

int getBool()
{
    return getRandomNumber(2);
}

int getRandomNumber(int number)
{
    int res = rand();
    if (number > 0)
        res = rand() % number;
    return res;
}
