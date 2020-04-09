#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <stdlib.h>

int chairs, clients, waiting = 0;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
sem_t sem;

void being_attended(int id){
  printf("\nCLIENTE %i > Estoy siendo atentido.\n", id);
  sem_wait(&sem);
  printf("\nCLIENTE %i > Me voy, excelente servicio.\n", id);
  waiting--;
  sem_post(&sem);
  pthread_mutex_unlock(&mutex);
}

void * cliente(void *arg){
  int id = *(int *)arg;

  sem_wait(&sem);
  if(waiting <= chairs){
    if(waiting > 0)
      printf("\nCLIENTE %i > Voy a esperar.\n", id);
    waiting++;
    sem_post(&sem);
    pthread_mutex_lock(&mutex);
    being_attended(id);
  }else{
    printf("\nCLIENTE %i > Me fui porque estaba lleno.\n", id);
    sem_post(&sem);
  }
}

int main(int argc, const char **argv){
  chairs = atoi(argv[1]);
  clients = atoi(argv[2]);

  sem_init(&sem, 0, 1);

  if(clients<=chairs){
    printf("El número de clientes debe ser mayor que el número de sillas\n");
    return 1;
  }

  pthread_t c_thread[clients];
  int id[clients];

  for(int i=0;i<clients;i++){
    id[i] = i;
    pthread_create(&c_thread[i], NULL, cliente, &id[i]);
  }

  for(int i=0;i<clients; i++){
    pthread_join(c_thread[i], NULL);
  }

}
