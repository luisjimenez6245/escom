#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/ip.h>

int main(int argc, char **argv)
{
    int udp_socket, tam;
    struct sockaddr_in SERVIDOR, CLIENTE;
    udp_socket = socket(AF_INET, SOCK_DGRAM, 0);

    if (udp_socket == -1)
    {
        perror("\nError al abrir el socket");
        exit(0);
    }

    perror("\nExito al abrir el socket");
    SERVIDOR.sin_family = AF_INET;
    SERVIDOR.sin_port = htons(8080);
    SERVIDOR.sin_addr.s_addr = INADDR_ANY;

    if (bind(udp_socket, (struct sockaddr *)&SERVIDOR, sizeof(SERVIDOR)) != 0)
    {
        perror("\n ERROR EN bind");
        exit(0);
    }

    unsigned char paqRec[512];
    int *exit_code;
    for (;;)
    {
        int lrecv = sizeof(CLIENTE);
        tam = recvfrom(udp_socket, paqRec, 512, 0, (struct sockaddr *)&CLIENTE, &lrecv);
        if (tam == -1)
        {
            perror("\n Error al recibir");
            exit(0);
        }
        else
        {
            printf("\n El mensaje es :%s", paqRec);
        }
        sleep(1);
    }
    close(udp_socket);
    return 0;
}
