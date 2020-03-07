#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

void create_process_child(char *command);
char *getCommand();
int call_proc_from_string(char *proc);
int getArgCount(char *proc);

int main(int argc, const char **argv)
{
  create_process_child(getCommand());
  return 0;
}

void create_process_child(char *command)
{
  int pid, status;
  while (strcmp(command, "exit") != 0)
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
        printf("\nHIJO Mi PID es: %i \n Mi padre es: %i\n", getpid(), getppid());
        exit(call_proc_from_string(command));
      }
      else
      {
        pid = wait(&status);
        if (WIFEXITED(status))
        {
          printf("PADRE \t Mi hijo con PID: %i termino con estado %i\n", pid, WEXITSTATUS(status));
          command = (getCommand());
        }
      }
    }
  }
}

int call_proc_from_string(char *command)
{
  int count = 0;
  char *args[getArgCount(command) + 1];
  char *token = strtok(command, " ");
  while (token != NULL)
  {
    args[count] = token;
    count += 1;
    token = strtok(NULL, " ");
  }
  args[count] = (char *)0;
  for (int i = 0; i <= count; ++i)
  {
    printf("%s\n", args[i]);
  }
  int res = 0;
  //int res = execvp("./comando.out", args);
  printf("res : %i\n", res);
  fflush(stdout);
  return res;
}

int getArgCount(char *proc)
{
  int count = 0;
  for (int i = 0; i < strlen(proc); ++i)
  {
    if (proc[i] == ' ')
    {
      ++count;
    }
  }
  return count;
}

char *getCommand()
{
  char *command = malloc(100 * sizeof(char));
  printf("Introduce el comando>\t");
  scanf("%[^\n]", command);
  fflush(stdin);
  printf("%s\n", command);
  fflush(stdin);
  return command;
}