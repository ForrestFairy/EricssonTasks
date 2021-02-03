#include <stdio.h>

void binToDec (char * toChange);
void decToBin (char * toChange);

void main () {
    int option;
    char * toChange;
    scanf("%d %s", option, toChange);
    switch (option) {
        case 2:
            binToDec(toChange);
            break;
        case 10:
            decToBin(toChange);
            break;
        default:
    }
}

void binToDec (char * toChange) {

}

void decToBin (char * toChange) {
    
}