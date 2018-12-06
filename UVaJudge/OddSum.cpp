//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1724
//Kliver Daniel
#include <iostream>
using namespace std;
int main() {
    int T,cont = 1;
    cin >> T;
    while ( T-- > 0 ) {
        int a,b;
        cin >> a >> b;
        if ( a%2==0 )
            a++;
        for ( int i=a+2; i <= b; i+=2 ) {
            a = a+i;
        }
        cout << "Case " << cont <<": " << a << "\n";
        cont++;
    }
    return 0;
}
