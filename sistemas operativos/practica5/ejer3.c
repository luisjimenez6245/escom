#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define NHILOS 2

int number;

void *increase(void *arg)
{
    int lim = *(int *)arg;
    int i;
    for (i = 0; i < lim; i++)
    {
        number++;
        printf("+1: %i\n", number);
    }
    pthread_exit(arg);
}

void *decrease(void *arg)
{
    int lim = *(int *)arg;
    int i;
    for (i = 0; i < lim; i++)
    {
        number--;
        printf("-1: %i\n", number);
    }
    pthread_exit(arg);
}

int main(int argc, const char **argv)
{
    int a, b, status, *exit_code, i;
    number = 0;

    pthread_t threads[NHILOS];

    if (argc > 2)
    {
        a = atoi(argv[1]);
        b = atoi(argv[2]);

        status = pthread_create(&threads[0], NULL, increase, &a);

        if (status)
        {
            printf("\nError en pthread_create %i\n", status);
            exit(-1);
        }

        status = pthread_create(&threads[1], NULL, decrease, &b);

        if (status)
        {
            printf("\nError en pthread_create %i\n", status);
            exit(-1);
        }

        for (i = 0; i < NHILOS; i++)
        {
            pthread_join(threads[i], (void **)&exit_code);
            printf("\nEl hilo terminó con valor %i\n", *exit_code);
        }

        printf("\nEl valor final es: %i\n", number);
    }
    else
    {
        printf("Por favor coloca los argumentos A y B\n");
    }
    return 0;
}
