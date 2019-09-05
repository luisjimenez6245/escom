//
//  main.cpp
//  Test
//
//  Created by Luis Jiménez Delgado on 8/26/19.
//  Copyright © 2019 Luis Jiménez Delgado. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int h, m, s;
    int h2, m2, s2;
    
    cout << "Introduzca hora inicial :" << endl;
    cin >> h;
    cout << "Introduzca minuto inicial:" << endl;
    cin >> m;
    cout << "Introduzca segundos inicial:" << endl;
    cin >> s;
    
    cout << "Introduzca hora dos :" << endl;
    cin >> h2;
    cout << "Introduzca minuto dos:" << endl;
    cin >> m2;
    cout << "Introduzca segundos dos:" << endl;
    cin >> s2;

    char is_valid = 's';
    
    while (is_valid == 'S'  || is_valid == 's'  )
    {
        do
        {
            if (h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59)
            {
                s++;
                if (s == 60)
                {
                    s = 0;
                    m++;
                    if (m == 60)
                    {
                        m = 0;
                        h++;
                        if (h == 24)
                            h = 0;
                    }
                }
                printf("\n   Un segundo despu%cs la hora es: %d:%d:%d", 130, h, m, s);
            }
            else
            {
                printf("\n   ERROR: La hora es incorrecta.");
            }
            
        } while (!(h == h2 && m == m2 && s == s2));
        cout << "Desea reiniciar el programa? S/N" << endl;
        cin >> is_valid;
    
    }
    
    return EXIT_SUCCESS;
}
