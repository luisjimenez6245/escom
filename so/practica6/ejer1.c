#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
 
void create_processes(int readers, int writers);
void *create_reader(void *args);
void *create_writer(void *args);
int get_random_number(int number);
int get_bool();
 
int readers_count = 0, char_count = 0;
char *fanswer;
sem_t reader, writer;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
 
int main(int argc, const char **argv)
{
   if (argc > 2)
   {
       key_t llave;
       int shmid, opc;
 
       //1er paso
       llave = ftok("./hola.txt", 39);
       if (llave == -1)
       {
           perror("Error en ftok.");
           exit(-1);
       }
 
       //2do paso
       shmid = shmget(llave, sizeof(char[1000000]), IPC_CREAT | 0777);
       if (shmid == -1)
       {
           perror("Error en shmget.");
           exit(-1);
       }
 
       //3er paso
       fanswer = (char *)shmat(shmid, 0, 0);
       if (fanswer == NULL)
       {
           perror("Error en shmat.");
           exit(-1);
       }
       int readers = atoi(argv[1]);
       int writers = atoi(argv[2]);
       if (readers > writers)
       {
           create_processes(readers, writers);
       }
       else
       {
           printf("Faltaron lectores\n");
       }
       shmdt("./hola.txt");
       shmctl(shmid, IPC_RMID, 0);
       exit(0);
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
                       pthread_join(threads[i], (void **)&exit_code);
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
                       pthread_join(threads[i], (void **)&exit_code);
 
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
   sem_post(&reader);
   printf("Estoy leyendo\n");
   printf("%s\n", fanswer);  
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
   printf("Inserta texto a escribir: ");
   char c;
   do
   {
        c = getchar();
   fanswer[char_count] = c;
   ++char_count;
   }while (c != '\n');
   printf("fin de escritura\n");
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
