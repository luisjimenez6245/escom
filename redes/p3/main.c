#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/ip.h> /* superset of previous */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <string.h>

int main()
{
    int udp_socket, lbind;
    struct sockaddr_in local, remota;
    unsigned char buffer[100] = "Hola Red Soy Luis";
    udp_socket = socket(AF_INET, SOCK_DGRAM, 0);
    if (udp_socket == -1)
    {
        perror("\n ERROR AL ABRIR EL SOCKET");
        exit(0);
    }
    else
    {

        perror("\n EXITO AL ABRIR EL SOCKET");
        local.sin_family = AF_INET;         /* address family: AF_INET */
        local.sin_port = htons(0);          /* port in network byte order */
        local.sin_addr.s_addr = INADDR_ANY; /* internet address */
        lbind = bind;
        bind(udp_socket, (struct sockaddr *)&local, sizeof(local));
        if (lbind == -1)
        {
            perror("\n Error en el bind");
            exit(0);
        }
        else
        {
            perror("\n Exito en el bind");
        }
    }
    close(udp_socket);
    return 0;
}
