#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char **argv)
{
    int n = 0, i = 0, j = 0, k = 0;
    if (argc == 2)
    {
        n = atoi(argv[1]);
        for (i = 0; i < n * 5; i += 2)
        {
            for (j = 0; j < 2 * n; j++)
            {
                for (k = j; k < n; k++)
                {
                    printf("Algoritmos\n");
                }
            }
        }
    }
    else
    {
        exit(-1);
    }
    return 0;
}