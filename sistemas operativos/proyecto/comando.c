#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>

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
    if (complete_string)
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

int call_proc_from_string(char *command, int count)
{
  char *args[get_arg_count(command, ' ') + count];
  char *token = strtok(command, " ");
  if (count == 1)
    args[0] = "./comando.out";
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

int command_with_file_out(char *command, char *filename, int appendable)
{
  int def = dup(1);
  int file;
  if (appendable != 1)
    file = open(filename, O_APPEND | O_CREAT);
  else
    file = open(filename, O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU | S_IRGRP | S_IROTH);

  if (file < 0)
  {
    return 1;
  }
  if (dup2(file, 1) < 0)
    return 1;
  int pid;
  if (pid = fork() == 0)
  {
    close(file);
    close(def);
    call_proc_from_string(command, 0);
    return 0;
  }
  dup2(def, 1);
  close(file);
  close(def);
  wait(NULL);
  close(file);
  return 0;
}

int command_with_file_in(char *command, char *filename)
{
  int pipefd[2];
  if (pipe(pipefd))
  {
    printf("pipe");
    exit(127);
  }

  int pid = fork();
  if (pid == -1)
  {
    perror("Error en la llamada a fork");
    exit(127);
  }
  else if (pid == 0)
  {
    close(pipefd[0]);   /* the other side of the pipe */
    dup2(pipefd[1], 1); /* automatically closes previous fd 1 */
    close(pipefd[1]);   /* cleanup */
    FILE *pFile;
    char mystring;

    pFile = fopen(filename, "r");
    if (pFile == NULL)
      perror("Error opening file");
    else
    {
      while ((mystring = fgetc(pFile)) != EOF)
      {
        putchar(mystring); /* print the character */
      }
      fclose(pFile);
    }
    exit(EXIT_SUCCESS);
  }
  else
  {
    close(pipefd[1]);   /* the other side of the pipe */
    dup2(pipefd[0], 0); /* automatically closes previous fd 0 */
    close(pipefd[0]);   /* cleanup */
    call_proc_from_string(command, 0);
    perror(command);
    exit(125);
  }

  return 0;
}

char *get_file_name(char *command, int in)
{
  char *command_copy = malloc(strlen(command) + 1);
  strcpy(command_copy, command);
  char *to_search = " ";
  if (in)
    to_search = "<";
  else
    to_search = ">";

  char *token = strtok(command_copy, to_search);
  char *filename = token;
  while (token != NULL)
  {
    filename = token;
    token = strtok(NULL, to_search);
  }
  token = strtok(filename, " ");
  while (token != NULL)
  {
    filename = token;
    token = strtok(NULL, " ");
  }

  command = strtok(command, to_search);
  printf("cmd: %s\n", command);
  return filename;
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
    if (call_proc_from_string(first_command, 0))
    {
    }
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
      if (call_proc_from_string(second_command, 1))
      {
      }
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
    char *copy = malloc(strlen(command) + 1);
    char *first_command = get_command_from_pipe(strcpy(copy, command), 0, 0);
    char *next_command = get_command_from_pipe(strcpy(copy, command), 1, 1);
    return manage_pipe(first_command, next_command);
  }
  else
  {
    if (strchr(command, '<') != NULL)
    {
      char *filename = get_file_name(command, 1);
      command_with_file_in(command, filename);
    }
    else if (strchr(command, '>') != NULL)
    {
      int appendable = get_arg_count(command, '>');
      char *filename = get_file_name(command, 0);
      command_with_file_out(command, filename, appendable);
    }
    else
    {
      res = execvp(args[0], args);
    }
  }
  if (res != 0)
  {
    printf("El comando no existe\n");
  }
  return res;
}
