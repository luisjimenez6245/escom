#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>

void create_process_childs(int n,  int numero, int numero2);
void selector(int i, int numero, int numero2);

int main(int argc, const char **argv)
{
    if (argc == 3)
    {
        create_process_childs(4, atoi(argv[1]), atoi(argv[2]));
    }
}

void create_process_childs(int n, int numero, int numero2)
{
    int pid, status;
    for (int i = 0; i < n; ++i)
    {
        pid = fork();
        if (pid == -1)
        {
            printf("Error en el fork");
            exit(1);
        }
        else
        {
            if (pid == 0)
            {
                printf("\nHIJO %i\n Mi PID es: %i \n Mi padre es: %i\n", i, getpid(), getppid());
                selector(i, numero, numero2);
                exit(0);
            }
            else
            {
                pid = wait(&status);
                if (WIFEXITED(status))
                {
                    printf("\nPADRE \t Mi hijo con PID: %i termino con estado %i\n", pid, WEXITSTATUS(status));
                }
            }
        }
    }
}

void selector(int i, int numero, int numero2)
{
    if (i == 0)
    {
        printf("\tLa suma es:  %i", (numero + numero2));
    }
    if (i == 1)
    {
        printf("\tLa resta es:  %i", (numero - numero2));
    }
    if (i == 2)
    {
        printf("\tLa multiplicación es:  %i", (numero * numero2));
    }
    if (i == 3)
    {
        if (numero2 != 0)
            printf("\tLa división es:  %f", ((float)numero / (float)numero2));
        else
        {
            exit(1);
        }
    }
}