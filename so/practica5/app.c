#include<stdio.h>
#include<stdlib.h>
#include<signal.h>

int main(){
    signal(SIGINT, SIG_IGN);
    while(1){
        printf("\n(-__-)....zzzzz\n");
        sleep(1);
    }
    return 0;
}