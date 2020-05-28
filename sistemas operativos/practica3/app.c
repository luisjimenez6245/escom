#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>

void create_process_childs(int n);

int main(int argc, const char **argv)
{
    printf("dsajkndjsad");
    int n = 2;
    if (argc == 2)
    {
        n = atoi(argv[1]);
    }
    create_process_childs(n);
}

void create_process_childs(int n)
{
    int pid, status, numero, numero2;
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
                exit(2);
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