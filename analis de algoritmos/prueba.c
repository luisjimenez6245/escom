#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char **argv)
{
    int n = 0, i = 0;
    long imprt = 0;
    if (argc == 2)
    {
        n = atoi(argv[1]);
        for (i = 1; i < n; ++i)
        {
            printf("%i", i);
        }
    }
    else
    {
        exit(-1);
    }
    return 0;
}

f += 1 + n + n + 1;
for (i = 1; i < n; i++)
{
    f += 1 + n / 2 + n / 2 + 1;
    for (j = n; j > 1; j /= 2)
    {
        temp = A[j];
        A[j] = A[j + 1];
        A[j + 1] = temp;
        f += 5;
    }
}