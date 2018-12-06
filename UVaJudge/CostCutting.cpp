/**
Kliver daniel
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2827
*/
#include <iostream>
using namespace std;
int main() {
    int T;
    cin >> T;
    int cont = 1;
    while (T-- > 0) {
        int a,b,c;
        scanf("%d%d%d",&a,&b,&c);
        int mi = min(a,b);
        mi = min(mi,c);
        int ma = max(a,b);
        ma = max(ma,c);
        if ( (mi==a && ma==c) || (mi==c && ma==a) )
            mi = b;
        else if ( (mi==b && ma==c) || (mi==c && ma==b) )
            mi=a;
        else if ( (mi==a && ma==b) || (mi==b && ma==a) )
            mi = c;
        cout << "Case " << cont << ": " << mi << "\n";
        cont++;
    }
    return 0;
}
