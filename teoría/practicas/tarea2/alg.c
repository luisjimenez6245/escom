#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int rev(char c, int space, char *word);
int inWords(char c, int len,char **dictionary);
void scope(char *toRev, char **dictionary);

int main(int argc, const char **argv)
{
    char *toRev = "include skskk includ sjl";
    char *dictionary[] = {"include", "main"};
    scope(toRev, dictionary);
}

void scope(char toRev[], char **dictionary)
{
    int i, j, charCount = 0;
    size_t len = strlen(toRev), words = sizeof(dictionary);
    for (i = 0; i < len; ++i)
    {
        char toWork = toRev[i];
        if (toWork != ' ' && toWork != '\t' && toWork != '\n')
        {
            if(inWords(toWork, len, dictionary)&& charCount ==0)
            {
                printf("alv");
                for (j = 0; j < words; ++j)
                {
                }
            }
            ++charCount;
        }
        else
        {
            charCount = 0;
        }
    }
}

int inWords(char c, int len,char **dictionary)
{
    int res = 0, i , j;
    int wLen = 0;
    for (i = 0; i < len; ++i)
    {
        if(res == 1){
            break;
        }
        wLen = strlen(dictionary[i]);
        for (j = 0; j < wLen; j++)
        {
            if(dictionary[i][j] == c)
            {
                res = 1;
                break;
            }
        }
    }
    return res;
}

int rev(char c, int space, char *word)
{
    return (c == word[space]);
}