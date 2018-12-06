//Kliver Daniel
#include <stdio.h>
#include <iostream>
using namespace std;
int main(void) {
    int i,j,n,count,max;
    while ( scanf("%d%d",&i,&j) != EOF ) {
        int tmp_i = i, tmp_j = j;
        if ( i>j ) {
            int c = j;
            j = i;
            i = c;
        }
        while ( i<=j ) {
            count = 1;
            n = i;
            while ( n!=1 ) {
                if ( n%2==0 )
                    n = n/2;
                else
                    n = 3*n+1;
                count++;
            }
            if ( count>max )
            max = count;
            i++;
        }
        printf("%d %d %d\n",tmp_i,tmp_j,max);
        max = 0;
    }
    return 0;
}
