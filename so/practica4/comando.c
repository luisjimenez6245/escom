#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, const char **argv)
{
    int res = 0;

    char *args[argc - 1];
    for (int i = 1; i < argc; ++i)
    {
        args[i - 1] = argv[i];
    }
    args[argc - 1] = (char *)0;
    res = execvp(args[0], args);
    if (res != 0)
    {
        printf("Ocurrió un error en la llamada\n");
    }
    return 0;
}