#include <stdlib.h>
#include <stdio.h>

int rev(char c, int space, char* word);
void scope(char * toRev, char** dictionary);

int main(int argc, const char** argv){
    char * toRev = "include skskk includ sjl";
    char ** dictionary = { "include", "main" };
    scope(toRev, dictionary);
}

void scope(char * toRev, char** dictionary){
    int len = sizeof(toRev);
    int words = sizeof(dictionary);
    printf("%d", len);
}

int rev(char c, int space, char* word){
    return (c == word[space]);
}