#include<stdio.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<unistd.h>

int main(){
	int fifo_er,fifo_re,cambio,cambio_fuera;
	char mensaje[200];

	if(mkfifo("fifo_er",S_IRWXU)==-1){
		perror("\nError en Fifo\n");
		exit(-1);
	}
	if(mkfifo("fifo_re",S_IRWXU)==-1){
		perror("\nError en Fifo\n");
		exit(-1);
	}
	fifo_er=open("fifo_er",O_WRONLY);
	fifo_re=open("fifo_re",O_RDONLY);

	do{
		printf("\nEMISOR <._.>");
		fgets(mensaje,sizeof(mensaje),stdin);
		write(fifo_er,mensaje,strlen(mensaje)+1);
		cambio=strcmp(mensaje,"CAMBIO\n");
		cambio_fuera=strcmp(mensaje,"CAMBIO Y FUERA\n");
		if(cambio==0){
			do{
				read(fifo_re,mensaje,sizeof(mensaje));
				printf("\nRECEPTOR (*_*) %s",mensaje);
				cambio=strcmp(mensaje,"CAMBIO\n");
				cambio_fuera=strcmp(mensaje,"CAMBIO Y FUERA\n");
			}while(cambio!=0 && cambio_fuera!=0);
		}

	}while(cambio_fuera!=0);
	close(fifo_er);	
	close(fifo_re);
	return 1;
}