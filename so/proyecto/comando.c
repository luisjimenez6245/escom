#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char *strjoinarray(char * dest, char *strings[], size_t number, char * glue)
{
    size_t glue_length = strlen(glue);
    char *target = dest;
    *target = '\0';
    for (size_t i = 0; i < number; i++) {
        if (i > 0) {
            strcat(target, glue);
            target += glue_length;
        }
        strcat(target, strings[i]);
        target += strlen(strings[i]);
    };
    return dest;
}

int has_pipe(char **args, int size)
{
  int i = 0;
  for(i = 0; i < size; ++i)
  {
      if(strchr(args[i], '|') != NULL){
        return 1;
      }
  }
  return 0;
}

int main(int argc, const char **argv)
{
    int res = 0;
    const char *test = " ";
    char *args[argc - 1];
    for (int i = 1; i < argc; ++i)
    {
        args[i - 1] = argv[i];
    }
    args[argc - 1] = (char *)0;
    res = execvp(args[0], args);
    if (res != 0)
    {
        printf("El comando no existe\n");
    }
    return res;
}
