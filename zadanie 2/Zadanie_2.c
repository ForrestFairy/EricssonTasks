#include <stdio.h>
#include <string.h>

void binToDec (char * toChange);
void decToBin (char * toChange);

void main () {
    int option;
    char * toChange;
    printf("Enter code and number to convert: \n(10 for decimal to binary, 2 for binary to decimal)\n");
    scanf("%d %s", &option, toChange);
    printf("%s\n", toChange);
    switch (option) {
        case 2:
            binToDec(toChange);
            break;
        case 10:
            decToBin(toChange);
            break;
        
    }
}

void binToDec (char * toChange) {
    int base = 1, answer = 0;
    for (int i = strlen(toChange) - 1; i >= 0; i--) {
        int current = toChange[i] - '0';
        answer += base * current;
        base *= 2;
    }
    printf("%d\n", answer);
}

void decToBin (char * toChange) {
    int decimal = 0;

    for (int i = 0; i < strlen(toChange); i++) {

        int temp = toChange[i] - '0';

        decimal = decimal * 10 + temp;
    }

    char toReverse[100];

    int i;
    for (i = 0; decimal > 0; i++, decimal /= 2) {
        if (decimal % 2 == 0) toReverse[i] = '0';
        else toReverse[i] = '1';
    }
    toReverse[i] = '\0';
    
    for (int i = strlen(toReverse) - 1; i >= 0; i--) {
        printf("%c", toReverse[i]);
    }

    printf("\n");
}