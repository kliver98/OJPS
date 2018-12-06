//Kliver Daniel
#include <iostream>
using namespace std;
int main() {
    int n;
    for (int i = 1; i < 1001; i++) {
        cin >> n;
        if (n==0)
            break;
        int c = 0;
        for (int i = 1; i <= n; i++) {
            int v;
            cin >> v;
            if (v==0)
                c++;
        }
        n = n-c;
        cout << "Case " << i << ": " << n-c << endl;
    }
    return 0;
}
