#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <stdlib.h>

void create_processes(int readers, int writers);
void *create_reader(void *args);
void *create_writer(void *args);
int get_random_number(int number);
int get_bool();

int readers_count = 0;
FILE *fanswer;
sem_t reader, writer;

int main(int argc, const char **argv)
{
    if (argc > 2)
    {
        int readers = atoi(argv[1]);
        int writers = atoi(argv[2]);
        if (readers > writers)
        {
            fanswer = fopen("./hola.txt", "w");
            fclose(fanswer);
            create_processes(readers, writers);
            fclose(fanswer);
        }
        else
        {
            printf("Faltaron lectores\n");
        }
    }
    else
    {
        printf("Faltaron argumentos\n");
    }
    return 0;
}

void create_processes(int readers, int writers)
{
    pthread_t threads[readers + writers];
    sem_init(&writer, 0, 1);
    sem_init(&reader, 0, 1);
    int i = 0, status, *exit_code;
    while (readers != 0 || writers != 0)
    {
        if (readers != 0 && writers != 0)
        {
            if (get_bool())
            {
                status = pthread_create(&threads[i], NULL, create_reader, &i);
                --readers;
            }
            else
            {
                status = pthread_create(&threads[i], NULL, create_writer, &i);
                --writers;
            }
        }
        else
        {
            if (readers > 0)
            {
                status = pthread_create(&threads[i], NULL, create_reader, &i);
                --readers;
            }
            else
            {
                status = pthread_create(&threads[i], NULL, create_writer, &i);
                --writers;
            }
        }
        ++i;
    }
    for (i = 0; i < (readers + writers); ++i)
    {
        pthread_join(threads[i], (void **)&exit_code);
    }
}

void *create_reader(void *args)
{
    sem_wait(&reader);
    readers_count += 1;
    if (readers_count == 1)
    {
        sem_wait(&writer);
    }
    printf("Estoy leyendo\n");
    sem_post(&reader);
    fanswer = fopen("hola.txt", "r");
    char c;
    while ((c = fgetc(fanswer)) != EOF)
        printf("%c", c);
    fclose(fanswer);
    printf("Terminé de leer\n");
    sem_wait(&reader);
    readers_count -= 1;
    if (!readers_count)
    {
        sem_post(&writer);
    }
    sem_post(&reader);
}

void *create_writer(void *args)
{
    sem_wait(&writer);
    fanswer = fopen("./hola.txt", "a+t");
    printf("Inserta texto a escribir: ");
    char c = ' ';
    while ((c) != '\n')
    {
        scanf("%c", &c);
        fputc(c, fanswer);
    }
    fclose(fanswer);
    printf("\n fin de escritura");
    sem_post(&writer);
}

int get_bool()
{
    get_random_number(2);
}

int get_random_number(int number)
{
    int res = rand();
    if (number > 0)
        res = rand() % number;
    return res;
}
