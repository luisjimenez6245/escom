#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define INPUT_END 1                              // INPUT_END means where the pipe takes input
#define OUTPUT_END 0    

int main()
{
    printf("sadskd");
    pid_t pid;
    int fd[2];
    char *argxs[3];
    argxs[1] = "-l";
    argxs[2] = (char *)0;
    pipe(fd);
    pid = fork();

    if (pid == 0)
    {
        dup2(fd[INPUT_END], STDOUT_FILENO);
        close(fd[OUTPUT_END]);
        close(fd[INPUT_END]);
        argxs[0] = "ls";
        execvp("ls", argxs);
        fprintf(stderr, "Failed to execute '%s'\n", "ls");
        exit(1);
    }
    else
    {
        pid = fork();

        if (pid == 0)
        {
            dup2(fd[OUTPUT_END], STDIN_FILENO);
            close(fd[INPUT_END]);
            close(fd[OUTPUT_END]);
            argxs[0] = "wc";
            execvp("wc", argxs);
            fprintf(stderr, "Failed to execute '%s'\n", "wc");
            exit(1);
        }
        else
        {
            int status;
            close(fd[OUTPUT_END]);
            close(fd[INPUT_END]);
            waitpid(pid, &status, 0);
        }
    }
}