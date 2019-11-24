#include <stdio.h>
#include <stdlib.h>
/*
if(c){s}s
Compile: gcc app.c
*/
FILE *fanswer;

int getBool();
void generateString();
int getRandomNumber(int number);

int main()
{
    fanswer = fopen("./answer.txt", "w");
    int i = 10;
    while (i != 0)
    {
        generateString();
        --i;
    }
    fclose(fanswer);
}

void generateString()
{
    int length = getRandomNumber(5);
    while (length >= 0)
    {
        if (getBool())
        {
            if (getBool())
            {
                if (getBool())
                {
                    fputc('0', fanswer);
                }
                else
                {
                    fputc('0', fanswer);
                    fputc('1', fanswer);
                    length = length - 1;
                }
            }
            else
            {
                fputc('0', fanswer);
                fputc('1', fanswer);
                fputc('0', fanswer);
                length = length - 2;
            }
            length = length - 1;
        }
        fputc('1', fanswer);
        length = length - 1;
    }
    fputc('\n', fanswer);
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
