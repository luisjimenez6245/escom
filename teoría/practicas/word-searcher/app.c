#include <stdio.h>
#include <stdlib.h>

void getWordItems(char []);
void evalWordStates(char [], void (*f) (char, file));

FILE *fp;

int main(int argc, const char** argv)
{
    char * file_name = "./spaces.txt";
    if(argc == 2){
        n = atoi(argv[1]); 
    }
    fp = fopen (file_name, "wb");
     while ((ch = fgetc(filePointer)) != EOF)
        {
            printf("%c", ch);
        } 
    return 0;
}