//
//  main.c
//  sistemasoperativos
//
//  Created by Luis Jiménez Delgado on 3/13/20.
//  Copyright © 2020 Luis Jiménez Delgado. All rights reserved.
//
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, const char * argv[]) {
    int pid, tubery[2];
    
    if(pipe(tubery) == -1)
    {
        perror("\nerror en pipe");
        exit(-1);
    }
    pid = fork();
    if(pid == -1)
    {
        perror("\nerror en fork");
        exit(-1);
    }
    else
    {
        if(pid==0)
        {
            close(0);
            dup(tubery[0]);
            close(1);
            open("archivo.txt", O_CREAT|O_RDWR, S_IRWXU);
            close(tubery[0]);
            close(tubery[1]);
            execlp("sort", "sort", "-r", NULL);
            perror("error en exec");
            
        }
        else
        {
            close(1);
             dup(tubery[1]); //Duplicar WR de tubería
             close(tubery[0]);
             close(tubery[1]);
             execlp("ls", "ls", NULL);
             perror("\nError en execlp\n");
            
        }
    }
    return 0;
}
