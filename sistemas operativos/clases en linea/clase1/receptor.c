#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
	int fifo_er, fifo_re, cambio, cambio_fuera;
	char mensaje[200];

	fifo_er = open("fifo_er", O_RDONLY);
	fifo_re = open("fifo_re", O_WRONLY);

	do
	{
		read(fifo_er, mensaje, sizeof(mensaje));
		printf("\nEMISOR <._.> %s", mensaje);
		cambio = strcmp(mensaje, "CAMBIO\n");
		cambio_fuera = strcmp(mensaje, "CAMBIO Y FUERA\n");
		if (cambio == 0)
		{
			do
			{
				printf("\nRECEPTOR (*_*)");
				fgets(mensaje, sizeof(mensaje), stdin);
				write(fifo_re, mensaje, strlen(mensaje) + 1);
				cambio = strcmp(mensaje, "CAMBIO\n");
				cambio_fuera = strcmp(mensaje, "CAMBIO Y FUERA\n");
			} while (cambio != 0 && cambio_fuera != 0);
		}

	} while (cambio_fuera != 0);
	close(fifo_er);
	close(fifo_re);
	return 1;
}