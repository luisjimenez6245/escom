#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char **argv)
{
    int n = 0, i = 0, j = 0;
    if (argc == 2)
    {
        n = atoi(argv[1]);
        for (j = n; j > 1; j /= 2)
        {
            if (j < (n / 2))
            {
                for (i = 0; i < n; i += 2)
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