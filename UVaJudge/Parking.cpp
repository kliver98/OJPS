//Kliver Daniel
#include <iostream>
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--) {
        int a;
        cin >> a;
        int mi = 100,ma = -100;
        while (a--) {
            int v;
            cin >> v;
            if (v<mi)
                mi = v;
            if (v>ma)
                ma = v;
        }
        cout << 2*(ma-mi) << endl;
    }
}
