#include <stdio.h>
#include <stdlib.h>

FILE *fanswer;

int getBool();
void generateString();
int getRandomNumber(int number);

int main()
{
    fanswer = fopen("./answer.txt", "w");
    int i = 20;
    while (i != 0)
    {
        generateString();
        --i;
    }
    fclose(fanswer);
}

void generateString()
{
    int length = getRandomNumber(100000);
    while (length >= 0)
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
    if (res > 1)
        printf("%i\n", res);
    return res;
}
