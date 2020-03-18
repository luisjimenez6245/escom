#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
        int pid, pipesC[2], pipesP[2], cont = 1;
        char buf[16];
        char fix[] = "";
        if (pipe(pipesC) == -1 && pipe(pipesP) == -1)
        {
                perror("\nError en pipe\n");
                exit(-1);
        }
        pid = fork();
        if (pid == -1)
        {
                perror("\nError en fork\n");
                exit(-1);
        }
        else
        {
                if (pid != 0)
                {
                        do
                        {
                                printf("Inserta un mensaje:\n");
                                scanf("%[^\n]", buf);
                                fflush(stdin);
                                write(pipesC[1], buf, strlen(buf));
                                cont = strcmp(buf, "exit");
                                read(pipesP[0], fix, strlen(fix) + 1);
                                memset(buf, 0, sizeof buf);
                        } while (cont != 0);
                        wait(NULL);
                }
                else
                {
                        while (cont != 0)
                        {
                                read(pipesC[0], buf, sizeof(buf) + 1);
                                printf("Recibi un mensaje: %s\n", buf);
                                cont = strcmp(buf, "exit");
                                write(pipesP[1], fix, strlen(fix) + 1);
                                memset(buf, 0, sizeof buf);
                        }
                        exit(0);
                }
        }
        return 0;
}