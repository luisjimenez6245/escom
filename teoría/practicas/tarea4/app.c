#include <stdio.h>
#include <math.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef unsigned char boolean;

typedef struct object
{
    boolean shouldContinue;
    boolean isValid;
    int state;
} object;

void manageProcess(char *fileName);
object manageObject(object *obj);
boolean isValidWord(char c, object *process0, object *process1);

int main(int argc, const char **argv)
{
    char *fileName = "./file.txt";
    if (argc == 2)
    {
        fileName = argv[1];
    }
}

void manageProcess(char *fileName, char *resFileName)
{
    FILE *file;
    FILE *res;
    FILE *aux;
    file = fopen(fileName, "r");
    char toWork;
    do
    {
        toWork = (char)fgetc(file);
        if (isValidWord(toWork, &process0, &process1))
        {
        }
        else
        {

        }
    } while (toWork != EOF);
    return code;
}

boolean isValidWord(char c, object *process[], int process number)
{
    int i;
    for (i = 0; i < number; ++i)
    {
        evalObject(process[i], c);
    }
}

object evalObject(object *obj, char c)
{
    if (obj->shouldContinue)
    {
        if (c == "0" && obj->state == 1)
        {
        }
    }
    else
    {

    }
}
