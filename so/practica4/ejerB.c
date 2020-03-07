#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int call_proc_from_string(char *proc);
int getArgCount(char *proc);
/*
int call_proc(char *name, char *args[]);
*/
int main()
{
  char opc[] = "hellow";
  int pid, status;
  while (strcmp(opc, "exit") != 0)
  {
    pid = fork();
    if (pid == -1)
    {
      printf("Error en la llamada a fork\n");
      exit(-1);
    }
    else
    {
      if (pid == 0)
      {
        printf("Introduce el comando>\t");
        scanf("%[^\n]", opc);
        if (strcmp(opc, "exit") != 0)
        {
          int res  = call_proc_from_string(opc);
          printf("res %i:\n", res);
          exit(res);
        }
      }
      else
      {
        pid = wait(&status);
      }
    }
  }
  return 0;
}

int call_proc_from_string(char *proc)
{
  int count = 0;
  char *args[getArgCount(proc) + 1];
  char *token = strtok(proc, " ");
  while (token != NULL)
  {
    args[count] = token;
    count += 1;
    token = strtok(NULL, " ");
  }
  args[count] = (char *)0;
  for(int i = 0; i <= count; ++i ){
    printf("%s\n", args[i]);
  }
  int res = execvp("./comando.out", args);
  printf("res %i:\n", res);
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
/*
int call_proc(char *name, char *args[])
{
  int res = execvp(name, args);
  if (res != 0)
  {
    printf("Ocurrió un error en la llamada\n");
  }
  return 0;
}*/