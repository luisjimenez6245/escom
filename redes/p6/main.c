#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <netinet/in.h>
#include <string.h>

#include <sys/socket.h>
#include <linux/if_packet.h>
#include <net/ethernet.h>
#include <sys/ioctl.h>
#include <net/if.h>

unsigned char MAC[6], MASK[4], IP[4];
void obtenerDatos(int ds)
{
    int i = 0;
    char nombre[10];
    struct ifreq nic;
    printf("\nIntroduce la interfaz de red: ");
    scanf("%s", nombre);
    strcpy(nic.ifr_name, nombre);

    if (ioctl(ds, SIOCGIFINDEX, &nic) == -1)
    {
        perror("Error al obtener el indice");
    }
    else
    {
        printf("\nEl indice es: %d\n", nic.ifr_ifindex);
    }

    if (ioctl(ds, SIOCGIFHWADDR, &nic) == -1)
    {
        perror("Error al obtener la MAC");
    }
    else
    {
        memcpy(MAC, nic.ifr_hwaddr.sa_data, 6);
        printf("\nMAC: ");
        for (i = 0; i < 6; i++)
        {
            printf("%2x:", MAC[i]);
        }
    }
    if (ioctl(ds, SIOCGIFADDR, &nic) == -1)
    {
        perror("Error al obtener la IP");
    }
    else
    {
        memcpy(IP, nic.ifr_addr.sa_data, 6);
        printf("\nIP: ");
        for (i = 2; i < 6; i++)
        {
            printf("%2d:", IP[i]);
        }
    }
    if (ioctl(ds, SIOCGIFNETMASK, &nic) == -1)
    {
        perror("Error al obtener la MASK");
    }
    else
    {
        memcpy(MASK, nic.ifr_netmask.sa_data, 6);
        printf("\nMASK: ");
        for (i = 2; i < 6; i++)
        {
            printf("%2d:", MASK[i]);
        }
    }
    if (ioctl(ds, SIOCGIFMTU, &nic) == -1)
    {
        perror("Error al obtener la MTU");
    }
    else
    {
        printf("\nMTU: %i", nic.ifr_mtu);
    }
}

int main()
{
    int packet_socket;

    packet_socket = socket(AF_PACKET, SOCK_RAW, htons(ETH_P_ALL));

    if (packet_socket == -1)
    {
        perror("Error al abrir el socket");
        exit(1);
    }
    else
    {
        perror("Exito al abrir el socket");
        obtenerDatos(packet_socket);
    }
    close(packet_socket);
    printf("\n");
}
