#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <string.h>

typedef struct
{
    int udp_socket;
    struct sockaddr_in cliente;
} contenedor;

void *enviar_mensajes(void *arg)
{
    contenedor *argumento = arg;
    char buffer[512];
    int tam;
    for (;;)
    {
        scanf("%[^\n]%*c", buffer);
        tam = sendto(
            argumento->udp_socket,
            buffer,
            strlen(buffer) + 1, 0,
            (struct sockaddr *)&argumento->cliente,
            sizeof(argumento->cliente));
        if (tam == -1)
        {
            perror("\n Error al enviar");
            exit(0);
        }
        else
        {
            printf("\033[0;31m");
            printf("Enviaste ->:%s\n", buffer);
            printf("\x1b[0m");
        }
    }
}

void *recibir_mensajes(void *arg)
{
    contenedor *argumento = arg;
    unsigned char buffer[512];
    int *exit_code, tam;
    for (;;)
    {
        unsigned int lrecv = sizeof(argumento->cliente);
        tam = recvfrom(
            argumento->udp_socket,
            buffer,
            512,
            0,
            (struct sockaddr *)&argumento->cliente,
            &lrecv);
        if (tam == -1)
        {
            perror("\n Error al recibir");
            exit(0);
        }
        else
        {
            printf("\033[0;34m");
            printf("Recibiste ->:%s\n", buffer);
            printf("\x1b[0m");
        }
    }
}

int main(int argc, char **argv)
{
    int udp_socket, status, i, *exit_code;
    struct sockaddr_in servidor, cliente;
    udp_socket = socket(AF_INET, SOCK_DGRAM, 0);
    pthread_t hilos[2];

    if (udp_socket == -1)
    {
        perror("\nError al abrir el socket");
        exit(0);
    }

    perror("\nExito al abrir el socket");
    servidor.sin_family = AF_INET;
    servidor.sin_port = htons(8080);
    servidor.sin_addr.s_addr = INADDR_ANY;

    if (bind(udp_socket, (struct sockaddr *)&servidor, sizeof(servidor)) != 0)
    {
        perror("\n ERROR EN bind");
        exit(0);
    }

    perror("\n Exito en el bind");

    contenedor c;
    c.cliente = cliente;
    c.udp_socket = udp_socket;

    status = pthread_create(
        &hilos[0], NULL, recibir_mensajes, &c);
    if (status)
    {
        printf("\nError en thread %i\n", status);
        exit(-1);
    }
    status = pthread_create(
        &hilos[0], NULL, enviar_mensajes, &c);
    if (status)
    {
        printf("\nError en thread %i\n", status);
        exit(-1);
    }

    for (i = 0; i < 2; ++i)
    {
        pthread_join(hilos[i], (void **)&exit_code);
        printf("\nHilo %i termino con código: %i\n", i, *exit_code);
    }

    close(udp_socket);
    return 0;
}
