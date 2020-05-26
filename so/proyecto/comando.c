#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define INPUT_END 1
#define OUTPUT_END 0

char *concatenate(size_t size, char *array[size], const char *joint)
{
    size_t jlen, lens[size];
    size_t i, total_size = (size - 1) * (jlen = strlen(joint)) + 1;
    char *result, *p;

    for (i = 0; i < size; ++i)
    {
        total_size += (lens[i] = strlen(array[i]));
    }
    p = result = malloc(total_size);
    for (i = 0; i < size; ++i)
    {
        memcpy(p, array[i], lens[i]);
        p += lens[i];
        if (i < size - 1)
        {
            memcpy(p, joint, jlen);
            p += jlen;
        }
    }
    *p = '\0';
    return result;
}

int has_pipe(char **args, int size)
{
    int i = 0;
    for (i = 0; i < size; ++i)
    {
        if (strchr(args[i], '|') != NULL)
        {
            return 1;
        }
    }
    return 0;
}

char *get_command_from_pipe(char *command, int position)
{
    int i = 0;
    char *res;
    char *token = strtok(command, "|");
    printf("token:%s \n", token);
    for (i = 0; i < position; ++i)
    {
        token = strtok(NULL, "|");
        printf("token:%s \n", token);
    }
    if (token != NULL)
        res = token;
    else
        res = "";
    return res;
}

int manage_pipe(char *first_command, char *second_command)
{
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

int main(int argc, const char **argv)
{
    int res = 0;
    char *args[argc - 1];
    for (int i = 1; i < argc; ++i)
    {
        args[i - 1] = argv[i];
    }
    args[argc - 1] = (char *)0;
    char *command = concatenate(argc - 1, args, " ");
    printf("comando %s\n", command);
    if (strchr(command, '|') != NULL)
    {
        char *first_command = get_command_from_pipe(command, 0);
        char *next_command = get_command_from_pipe(command, 1);
        printf("f:%s\n", first_command);
        printf("s:%s\n", next_command);
    }
    else
    {
        res = execvp(args[0], args);
    }
    if (res != 0)
    {
        printf("El comando no existe\n");
    }
    return res;
}
