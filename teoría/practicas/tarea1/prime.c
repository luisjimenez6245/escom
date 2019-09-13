#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void getWord(int length, int number);
int isPrime(int number);
FILE *fp;

int main(int argc, const char **argv)
{
    char *file_name = "/Volumes/FILES/files/prime.txt";
    int n = 100000, i, counter, j = 1;
    if (argc == 2)
    {
        n = atoi(argv[1]);
    }
    fp = fopen(file_name, "wb");
    fclose(fp);
    fp = fopen(file_name, "ab");
    for (i = 2; i <= n; ++i)
    {
        if((i % (10*j)) == 0)
        {
            j += 1;
        }
        if(isPrime(i))
        {
            getWord(j, i);
        }
    }
    fclose(fp);
    return 0;
}

int isPrime(int number)
{
    int i = 2, res = 1;
    for(i = 2; i <= number/2; ++i)
    {
        if((number%i) == 0)
        {
            res = 0;
            break;
        }
    }
    return res;
}

void getWord(int length, int number)
{
    char res[length + 2];
    res[length + 1] = '\n';
    res[length + 2] = '\0';
    int i, aux;
    for (i = length; i >= 0; --i)
    {
        aux = number >> i;
        if (aux & 1)
            res[i] = '1';
        else
            res[i] = '0';
    }
    fputs(res, fp);
}