#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#define NTHREADS 2

typedef struct
{
    int i;
    char *word;
} create_thread_container;

void *create_thread(void *args);

int main()
{
    create_thread_container *msjs[NTHREADS];
    pthread_t threads[NTHREADS];
    int status, i, *exit_code;
    for (i = 0; i < NTHREADS; i++)
    {
        msjs[i] = malloc(sizeof(*msjs[i]));
        msjs[i]->i = i;
        printf("Ingresa mensaje %i: \n", i);
        msjs[i] -> word = malloc(100  * sizeof(char));
        scanf("%[^\n]", msjs[i]->word);
        fflush(stdin);
    }
    for (i = 0; i < NTHREADS; i++)
    {
        status = pthread_create(&threads[i], NULL, create_thread, msjs[i]);
        if (status)
        {
            printf("\nError en thread %i\n", status);
            exit(-1);
        }
    }
    for (i = 0; i < NTHREADS; i++)
    {
        pthread_join(threads[i], (void **)&exit_code);
        printf("\nHilo %i termino con código: %i\n", i, *exit_code);
    }
    return 0;
}

void *create_thread(void *args)
{
    create_thread_container *actual_args = args;
    int length = strlen(actual_args->word);
    int i;
    for (i = 0; i < length; i++)
    {
        printf("Hilo %i: %c\n", actual_args->i, actual_args->word[i]);
    }
    pthread_exit(args);
}