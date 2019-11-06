#include <stdio.h>
#include <stdlib.h>

int main(){
    printf("");

}

void generateString(){
    int length = getRandomNumber(100000);
    while(length != 0)
    {
        if(getBool())
        {

        }
        else
        {
            
        }

    }

}


int getBool()
{
    return getRandomNumber(2);
}
int getRandomNumber(int number){
    time_t t;
   srand((unsigned) time(&t));
   if(number > 0)
   return rand() % number;
   return rand();
}

