#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

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

int get_arg_count(char *proc, char to_search)
{
  int count = 0;
  for (int i = 0; i < strlen(proc); ++i)
  {
    if (proc[i] == to_search)
    {
      ++count;
    }
  }
  return count;
}

char *get_command_from_pipe(char *command, int position, int complete_string)
{
    int i = 0, count = get_arg_count(command, '|');
    char *token = strtok(command, "|");
    for (i = 0; i < position; ++i)
    {
        token = strtok(NULL, "|");
    }
    if (token != NULL)
    {
        if(complete_string)
        {
            char *res[count];
            res[0] = token;
            for (i = 1; i < count; ++i)
            {
                token = strtok(NULL, "|");
                            res[i] = token;
            }
            return concatenate(count, res, "|");
        }
        else
        {
            return token;
        }
    }
    else
        return "";
}

int call_proc_from_string(char *command)
{
  printf("commando: %s\n", command);
  int count = 0;
  char *args[get_arg_count(command, ' ')];
  char *token = strtok(command, " ");
  while (token != NULL)
  {
    args[count] = token;
    count += 1;
    token = strtok(NULL, " ");
  }
  args[count] = (char *)0;
  int res = execvp(args[0], args);
  return res;
}

int call_proc_from_string_c(char *command)
{
  printf("commando: %s\n", command);
  int count = 1;
  char *args[get_arg_count(command, ' ') + 1];
  char *token = strtok(command, " ");
  args[0]  = "./comando.out";
  while (token != NULL)
  {
    args[count] = token;
    count += 1;
    token = strtok(NULL, " ");
  }
  args[count] = (char *)0;
  int res = execvp(args[0], args);
  return res;
}


int manage_pipe(char *first_command, char *second_command)
{
    pid_t pid;
    int fd[2];
    pipe(fd);
    pid = fork();

    if (pid == 0)
    {
        dup2(fd[INPUT_END], STDOUT_FILENO);
        close(fd[OUTPUT_END]);
        close(fd[INPUT_END]);
        call_proc_from_string(first_command);
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
            call_proc_from_string_c(second_command);
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
    if (strchr(command, '|') != NULL)
    {
        char * copy = malloc(strlen(command) + 1); 
        char * first_command = get_command_from_pipe(strcpy(copy, command), 0, 0);
        char * next_command = get_command_from_pipe(strcpy(copy, command), 1, 1);
        return manage_pipe(first_command,next_command);
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
