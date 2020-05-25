#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/shm.h>

#define N 10

struct pila{
  int pos;
  char chain[10];
};

void push(struct pila *s, char c){
  if(s->pos == NULL){
    s->pos = 0;
  }
  s->chain[s->pos] = c;
  s->pos++;
}

void pop(struct pila *s){
  char c;
  c = s->chain[s->pos-1];
  s->pos--;
  printf("Elemento >\t%c\n", c);
  s->chain[s->pos] = ' ';
}

void top(struct pila *s){
  char c;
  c = s->chain[s->pos-1];
  printf("Elemento >\t%c\n", c);
}

void showfull(struct pila *s){
  int i;
  for(i = 0 ; i < s->pos; i++){
    char c = s->chain[i];
    printf("%c | ", c);
  }
}


int main(){

  key_t llave;
  int shmid, opc;
  struct pila *s;

  llave = ftok("./pila.txt", 39);

  if(llave == -1){
     perror("Error en ftok.");
     exit(-1);
  }
  shmid = shmget(llave, sizeof(struct pila), IPC_CREAT | 0777);

  if (shmid == -1){
     perror("Error en shmget.");
     exit(-1);
  }

  s = (struct pila *)shmat(shmid, 0, 0);
  if (s == NULL){
     perror("Error en shmat.");
     exit(-1);
  }

  while(1){
    char c = ' ';
    printf("\n-----------------------------\n");
    printf("PILA DE DATOS COMPARTIDA\n");
    printf("1 Ingresar elemento \n2 Retirar elemento \n3 Vizualizar elemeto \n4 Vizualizar pila\n5 Finalizar\n");
    scanf("%i", &opc);
    switch(opc){
      case 1:
        printf("Elemento >\t");
        scanf(" %c", &c);
        push(s, c);
        break;
      case 2:
        pop(s);
        break;
      case 3:
        top(s);
        break;
      case 4:
        showfull(s);
        break;
      case 5:
        shmdt((struct pila *)s);
        shmctl(shmid, IPC_RMID, 0);
        exit(0);
        break;
      default:
        printf("Opcion invalida\n");
        break;
    }
  }
  return 0;
}
