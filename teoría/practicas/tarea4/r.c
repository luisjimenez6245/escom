#include <stdio.h>
#include <stdlib.h>

/*

*/

#define TRUE 1
#define FALSE 0

typedef unsigned char boolean;

typedef struct process
{
    boolean shouldContinue;
    boolean isValid;
    int state;
} process;

FILE *fp;

int main(int argc, const char** argv)
{
    char *fileName = "./file.txt";
    fp = fopen(fileName, "r");
    char toWork = (char)fgetc(fp);
    while (toWork != EOF)
    {
        printf("%c", toWork);
        toWork = (char)fgetc(fp);
    }
    fclose(fp);
    return 0;
}

