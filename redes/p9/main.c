#include <sys/socket.h>
#include <linux/if_packet.h>
#include <net/ethernet.h> /* the L2 protocols */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <string.h>
#include <sys/ioctl.h>
#include <net/if.h>
#include <netinet/in.h>

unsigned char MACorigen[6], MACdestino[6];
unsigned char MACbroad[6]={0xff,0xff,0xff, 0xff,0xff,0xff};

unsigned char ethertype[2] = {0x08, 0x06};
unsigned char tramaEnv[1514], tramaRec[1514];
unsigned char IPorigen[4];
unsigned char IPdestino[4];
unsigned char opcodeRes[2] = {0x00, 0x02};

const char *const COLOR_ARR[] = {"\x1b[31m", "\x1b[32m", "\x1b[33m", "\x1b[34m", "\x1b[35m", "\x1b[36m"}; // all const

#define ANSI_COLOR_RESET "\x1b[0m"

void imprimirTrama(unsigned char *paq, int len)
{

    int i;
    int color = 0;
    for (i = 0; i < len; i++)
    {
        if (i % 16 == 0)
        {
            printf("\n");
            printf("%s", COLOR_ARR[color]);
            color++;
            if (color % 5 == 0)
            {
                color = 0;
            }
        }
        printf("%.2x ", paq[i]);
    }
    printf(ANSI_COLOR_RESET);
    printf("\n");
}

void estructuraTrama(unsigned char *trama)
{
    char IP[50];
    printf("\nInserta la direccion IP:");
    scanf("%s", IP);
    inet_aton(IP, IPdestino);
    unsigned char tipoh[2] = {0x00, 0x01};
    unsigned char tipoP[2] = {0x08, 0x00};
    unsigned char lonH[1] = {6};
    unsigned char longP[1] = {4};
    unsigned char codO[2]={0x00,0x01};//codio de operacion

    memcpy(trama + 0, MACbroad, 6);
    memcpy(trama + 6, MACorigen, 6);
    memcpy(trama + 12, ethertype, 2);

    memcpy(trama + 14, tipoh, 2);
    memcpy(trama + 16, tipoP, 2);
    memcpy(trama + 18, lonH, 1);
    memcpy(trama + 19, longP, 1);
    memcpy(trama + 20, codO, 2);
    memcpy(trama + 22, MACorigen, 6);
    memcpy(trama + 28, IPorigen, 4);
    memset(trama + 32, 0x00, 6);
    memcpy(trama + 38, IPdestino, 4);
    memcpy(trama + 42, "Prueba Equipo Luis", 18);
}

void enviarTrama(int ds, int index, unsigned char *trama)
{

    //llenar nuestra estrucutra sockaddr
    int tam;
    struct sockaddr_ll interfaz;
    memset(&interfaz, 0x00, sizeof(interfaz));
    interfaz.sll_family = AF_PACKET;
    interfaz.sll_protocol = htons(ETH_P_ALL);
    interfaz.sll_ifindex = index;
    //se hace el envio
    tam = sendto(ds, trama, 60, 0, (struct sockaddr *)&interfaz, sizeof(interfaz));

    if (tam == -1)
    {
        perror("\nError al enviar");
        exit(0);
    }
    else
    {
        perror("\nExito al enviar");
    }
}

int filtrosARP(unsigned char *paq)
{

    if (!memcmp(paq + 0, MACorigen, 6))
    {
        if (!memcmp(paq + 12, ethertype, 2))
        {

            if (!memcmp(paq + 20, opcodeRes, 2))
            {
                if (!memcmp(paq + 28, IPdestino, 4))
                {
                    return 1;
                }
                else{

                }
            }
                        printf("\n");
        }

    }
    return 0;
}

void recibirTrama(int ds, unsigned char *trama)
{
    //funcion para chat, recvfrom
    while (1)
    {
        int tam;
        tam = recvfrom(ds, trama, 60, 0, NULL, 0);
        if (tam == -1)
        {
            perror("\nError al recibir");
            exit(0);
        }
        else
        {
            if (filtrosARP(trama))
            {
                imprimirTrama(trama, tam);
                memcpy(MACdestino, trama + 22, 6);
                imprimirTrama(MACdestino, 6);
                break;
            }
        }
    }
}

int obtenerDatos(int ds)
{
    struct ifreq nic;
    unsigned char nombre[20];
    int i, index;

    printf("Inserta el nombre de la interfaz: ");
    gets(nombre);

    strcpy(nic.ifr_name, nombre);
    if (ioctl(ds, SIOCGIFINDEX, &nic) == -1)
    {
        perror("\nerror al obtener el index");
    }
    else
    {
        index = nic.ifr_ifindex;
        printf("El indice es %d", index);
        if (ioctl(ds, SIOCGIFHWADDR, &nic) == -1)
        {
            perror("\nErro al obtener la MAC");
            exit(0);
        }
        else
        {
            memcpy(MACorigen, nic.ifr_hwaddr.sa_data + 0, 6);
            printf("\nLa MAC es: ");
            for (i = 0; i < 6; i++)
            {
                printf("%.2x:", MACorigen[i]);
            }
            if (ioctl(ds, SIOCGIFADDR, &nic) == -1)
            {
                perror("\nErro al obtener la IP");
                exit(0);
            }
            else
            {
                memcpy(IPorigen, nic.ifr_addr.sa_data + 2, 4);
                printf("\nLa IP es: ");
                for (i = 0; i < 4; i++)
                {
                    printf("%d.", IPorigen[i]);
                }
            }
        }
    }
    return index;
}

int main()
{

    int packet_socket, indice;
    packet_socket = socket(AF_PACKET, SOCK_RAW, htons(ETH_P_ALL));

    if (packet_socket == -1)
    {
        perror("Error al abrir el socket");
        exit(0);
    }
    else
    {
        perror("\nExito al abrir el socket");
        indice = obtenerDatos(packet_socket);
        estructuraTrama(tramaEnv);
        enviarTrama(packet_socket, indice, tramaEnv);
        recibirTrama(packet_socket, tramaRec);
    }

    close(packet_socket);
    return 0;
}
