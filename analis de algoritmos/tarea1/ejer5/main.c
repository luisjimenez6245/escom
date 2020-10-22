#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char **argv)
{
    int n = 0, i = 0, j = 0, k = 0;
    if (argc == 2)
    {
        n = atoi(argv[1]);
        for (i = 1; i < 4 * n; i *= 2)
        {
            for (j = i; j < 5 * n; j += 3)
            {
                printf("Algoritmos\n");
            }
        }
    }
    else
    {
        exit(-1);
    }
    return 0;
}