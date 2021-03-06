#include <stdio.h>
#include <stdlib.h>
/*
if(c){s}s
Compile: gcc app.c
*/
int getBool();
void generateString();
void getString();
int getRandomNumber(int number);

FILE *fanswer;
FILE *fstates;
int length;


int main(int argc, const char **argv)
{
    int n = 100;
    arc4random();
    if (argc == 2)
    {
        n = atoi(argv[1]);
    }
    length = getRandomNumber(n);
    fanswer = fopen("./answer.c", "w");
    fstates = fopen("./states.txt", "w");

    generateString();
    fclose(fanswer);
    fclose(fstates);
}

void generateString()
{
    printf("length: %i\n", length);
    while (length >= 0)
    {
       getString();
    }
    fputc('\n', fanswer);
}

void getString(){
    if (getBool())
    {
        --length;
        fputs("if(/*condition*/)\n{\n", fanswer);
        fputs("S->iCtSA\n", fstates);
        if(getBool())
        {
            getString();
        }
        fputs("\n}\n", fanswer);
        if(getBool())
        {
            fputs("A-> eS\n", fstates);   
            fputs("else\n{\n", fanswer);
            if(getBool()){
                getString();
            }
            fputs("\n}\n", fanswer);
        }
        else{
            fputs("A-> ε\n", fstates);   
        }
    }
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
