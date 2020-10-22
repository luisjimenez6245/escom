#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char **argv)
{
    int n = 0, i = 0;
    long imprt = 0;
    if (argc == 2)
    {
        n = atoi(argv[1]);
        for (i = 10; i < n * 5; i *= 2)
        {
            //printf("Algoritmos\n");
            imprt++;
        }
        printf("%ld", imprt);
    }
    else
    {
        exit(-1);
    }
    return 0;
}