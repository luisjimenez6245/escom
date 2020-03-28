#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include <sys/time.h>

typedef struct
{
    int id;
    int n_tasks;
    int *to_add;
} create_thread_container;

void *create_thread(void *args);
void create_threads(int num1, int n_threads, int n_tasks, int complements);

int result;

int main(int argc, const char **argv)
{
    int num1, num2, n_threads, i, n_tasks, complement_tasks = 0;
    if (argc > 3)
    {
        num1 = atoi(argv[1]);
        num2 = atoi(argv[2]);
        n_threads = atoi(argv[3]);
        n_tasks = num2 / n_threads;
        if ((n_tasks * n_threads) < num2)
        {
            complement_tasks = num2 - (n_tasks * n_threads);
        }
        clock_t begin = clock();
        create_threads(num1, n_threads, n_tasks, complement_tasks);
        clock_t end = clock();
        double time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
        printf("\nResultado de la multiplicación: %ix%i = %i\n", num1, num2, result);
        printf("\nTerminó en %f segundos\n", time_spent);
    }
    else
    {
        exit(1);
    }
    return 0;
}

void create_threads(int num1, int n_threads, int n_tasks, int complements)
{
    pthread_t threads[n_threads];
    clock_t begin_times[n_threads];
    int i, status, *exit_code, number;
    for (i = 0; i < n_threads; i++)
    {
        create_thread_container *msjs = malloc(sizeof(*msjs));
        msjs->id = i;
        if (i == (n_threads - 1))
            msjs->n_tasks = n_tasks + complements;
        else
            msjs->n_tasks = n_tasks;
        msjs->to_add = &num1;
        begin_times[i] = clock();
        status = pthread_create(&threads[i], NULL, create_thread, msjs);
    }
    for (i = 0; i < n_threads; i++)
    {
        pthread_join(threads[i], (void **)&exit_code);
        clock_t end = clock();
        double time_spent = (double)(end - begin_times[i]) / CLOCKS_PER_SEC;
        printf("\nHilo %i termino con código: %i, terminó en: %f segundos\n", i, *exit_code, time_spent);
    }
}

void *create_thread(void *args)
{
    create_thread_container *actual_args = args;
    int i;
    for (i = 0; i < actual_args->n_tasks; i++)
    {
        result += *actual_args->to_add;
        printf("Hilo %i, Vuelta %i:, Total de vueltas: %i, %i\n", actual_args->id, i, actual_args->n_tasks, result);
    }
    pthread_exit(args);
}
