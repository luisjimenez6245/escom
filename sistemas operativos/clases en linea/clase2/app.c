#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define NHILOS 4

void *function(void *);
int var = 0;

int main()
{
    pthread_t hilos[NHILOS];
    int status, i, id[NHILOS], *salida;

    for (i = 0; i < NHILOS; i++)
    {
        id[i] = i;
        status = pthread_create(&hilos[i], NULL, function, &id[i]);
        if (status)
        {
            printf("\nError en thread %i\n", status);
            exit(-1);
        }
    }

    for (i = 0; i < NHILOS; i++)
    {
        pthread_join(hilos[i], (void **)&salida);
        printf("\nHilo %i termino con código: %i\n", i, *salida);
    }

    return 0;
}

void *function(void *arg)
{
    int i;
    for (i = 1; i <= 5; i++)
    {
        printf("HILO: %i, variable local: %i, variable global: %i\n", *(int *)arg, i, var++);
        sleep(1);
    }
    pthread_exit(arg);
}