#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h> 

char* getWord(int length, int number, char* res);

char *appendString(char *cadena, char caracter);

int main()
{
    int n = 24, i, counter, j;
    for (i = 0; i < n; ++i)
    {
        counter = (int) pow(2, i + 1);
        printf("res: %d, \n", i);
        for (j = 0; j < counter; ++j)
        {    
            char * res = "";
            res = getWord(i, j, res);
        }
    }
    return 0;
}

char *appendString(char *cadena, char caracter)
{
	size_t tam = strlen(cadena);
	char *res = malloc(tam + 1 + 1);
	strcpy(res, cadena);
	res[tam] = caracter;
	res[tam + 1] = '\0';
	cadena = malloc(strlen(res));
	strcpy(cadena, res);
	free(res);
	return cadena;
}

char* getWord(int length, int number, char* res)
{
    int i, aux;
    for (i = length; i >= 0; --i)
    {
        aux = number >> i;
        if (aux & 1)
            res = appendString(res, '1');
        else
            res = appendString(res, '0');
    }
    return res;
}