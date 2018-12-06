//Kliver Daniel
#include <iostream>
#include <string>
#include <cmath>
using namespace std;
int main(void) {
    long long int n = 0, m = 0;
    while ( scanf("%lld %lld",&n,&m) != EOF ) {
        long long int a = abs(n-m);
        printf("%lld\n",a);
    }
    return 0;
}
