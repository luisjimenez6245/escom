#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

typedef struct
{
    int id;
    int to_add;
    int times;
} create_thread_container;

int get_random_number(int number);

int number;

int main(int argc, const char **argv)
{
    int a, b;
    number = 0;
    if (argc > 2)
    {
        a = atoi(argv[1]);
        b = atoi(argv[2]);
        if (a < 0)
            a = a * -1;
        if (b > 0)
            b = b * -1;
    }
    else
    {
        a = get_random_number(100000);
        b = -1 * get_random_number(100000);
    }
    return 0;
}

void manage_threads(int a, int b)
{
    pthread_t threads[2];
    int status = 0;
    
    create_thread_container *msjs = malloc(sizeof(*msjs));
    msjs->id = 0;
    msjs->to_add = a;
    msjs->times = get_random_number(100000);
    status = pthread_create(&threads[0], NULL, create_thread, msjs);
    msjs = malloc(sizeof(*msjs));
    msjs->id = 1;
    msjs->to_add = b;
    msjs->times = get_random_number(100000);
    status = pthread_create(&threads[0], NULL, create_thread, msjs);
}

void *create_thread(void *args)
{
    create_thread_container *actual_args = args;
    int i;
    for (i = 0; i < actual_args->times; i++)
    {
        number += actual_args->to_add;
    }
    pthread_exit(args);
}

int get_random_number(int number)
{
    int res = rand();
    if (number > 0)
        res = rand() % number;
    return res;
}