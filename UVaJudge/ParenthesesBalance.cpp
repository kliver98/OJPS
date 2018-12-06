//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=614
//Kliver Daniel
#include <iostream>
#include <stack>
#include <cstring>
using namespace std;
int main() {
    int n;
    cin >> n;
    while ( n-- > 0 ) {
        string in;
        cin >> in;
        stack <char> s;
        char ele[in.size()];
        int len = sizeof(ele);
        strcpy(ele,&in[0]);
        for ( int i = 0; i < len; i++ ) {
            char c = ele[i];
            if ( s.size()>0 ) {
                char sc = s.top();
                switch (c) {
                    case ')':
                        if (sc=='(')
                            s.pop();
                        break;
                    case ']':
                        if (sc=='[')
                            s.pop();
                        break;
                    default:
                        s.push(c);
                }
            } else {
                s.push(c);
            }
        }
        in = "No";
        if ( s.empty() )
            in = "Yes";
        cout << in << "\n";
    }
    return 0;
}
