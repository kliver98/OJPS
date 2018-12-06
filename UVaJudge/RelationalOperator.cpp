//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2113
//Kliver Daniel
#include <iostream>
using namespace std;
int main() {
    int T;
    cin >> T;
    while ( T-- > 0 ) {
        long long int a;
        long long int b;
        scanf("%lld%lld",&a,&b);
        if ( a < b )
            cout << "<";
        else if ( a > b )
            cout << ">";
        else
            cout << "=";
        cout << "\n";
    }
    return 0;
}
