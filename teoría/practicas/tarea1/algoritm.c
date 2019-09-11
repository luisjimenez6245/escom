#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void getWord(int length, int number);

FILE *fp;

int main(int argc, const char** argv)
{
    char * file_name = "/media/luis/FILES/res2";
    int n = 27, i, counter, j;
    if(argc == 2){
        n = atoi(argv[1]); 
    }
    fp = fopen (file_name, "wb");
    fclose (fp);
    fp = fopen (file_name, "ab");
    for (i = 0; i <= n; ++i)
    {
        counter = (int) pow(2, i + 1);
        printf("item: %d \n", i);
        for (j = 0; j < counter; ++j)
        {
            getWord(i, j);
        }
    }
    fclose (fp);
    return 0;
}

void getWord(int length, int number)
{
    char res[length + 1];
    res[length + 1] = '\0';
    //res[length + 2] = '\n';
    int i, aux;
    for (i = length; i >= 0; --i)
    {
        aux = number >> i;
        if (aux & 1)
            res[i] = '1';
        else
            res[i] = '0';
    }
    fputs(res, fp);
}