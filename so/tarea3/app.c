#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <stdlib.h>

#define NTHREADS 10

typedef struct
{
    int id;
} create_thread_container;

int process_count = 0;
pthread_mutex_t barrera = PTHREAD_MUTEX_INITIALIZER;
sem_t semaphore;

void sync(void);
void *manage_thread(void *argc);

int main(int argc, const char **argv)
{
    pthread_t threads[NTHREADS];
    int i, *exit_code;
    sem_init(&semaphore, 0, 1);
    create_thread_container *con = malloc(sizeof(*con));
    for (i = 0; i < NTHREADS; ++i)
    {
        con->id = i;
        if (pthread_create(&threads[i], NULL, manage_thread, con))
        {
            printf("\nError al  crear el hilo %i\n", i);
            exit(-1);
        }
    }
    for (i = 0; i < NTHREADS; ++i)
    {
        pthread_join(threads[i], (void **)&exit_code);
    }
    printf("Todos en el metro.\n");
    return (0);
}

void sync(void)
{
    sem_wait(&semaphore);
    process_count = process_count + 1;
    if (process_count < NTHREADS)
    {
        sem_post(&semaphore);
        pthread_mutex_lock(&barrera);
    }
    else
    {
        int i;
        for (i = 0; i < (NTHREADS); i++)
        {
            pthread_mutex_unlock(&barrera);
        }
        process_count = 0;
        sem_wait(&semaphore);
    }
}

void *manage_thread(void *argc)
{
    create_thread_container *con = (argc);
    printf("Llegué al metro id: %i\n", con->id);
    void sync();
    pthread_exit(argc);
}
