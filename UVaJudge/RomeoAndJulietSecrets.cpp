//Kliver Daniel
#include<iostream>
#include <bits/stdc++.h>
using namespace std;
int pre[100001];
int suf[100001];
void getZarr(string str, int Z[]);

void search(string text, string pattern,bool s) {
    string concat = pattern + "$" + text;
    int l = concat.length();
    int Z[l];
    getZarr(concat, Z);
    for (int i = pattern.length()+1; i < l; i++) {
        if ( s ) {
            pre[i-(pattern.length()+1)] = Z[i];
        }else {
            suf[i-(pattern.length()+1)] = Z[i];
        }
    }
}
void getZarr(string str, int Z[]) {
    int n = str.length();
    int L, R, k;
    L = R = 0;
    for (int i = 1; i < n; ++i) {
        if (i > R) {
            L = R = i;
            while (R<n && str[R-L] == str[R])
                R++;
            Z[i] = R-L;
            R--;
        }
        else {
            k = i-L;
            if (Z[k] < R-i+1)
                Z[i] = Z[k];
            else {
                L = i;
                while (R<n && str[R-L] == str[R])
                    R++;
                Z[i] = R-L;
                R--;
            }
        }
    }
}
int main() {
    int n;
    cin >> n;
    while ( n-- > 0 ) {
        string text;
        string pattern;
        cin >> text >> pattern;
        int k;
        cin >> k;
        int l = text.length();
        memset(pre,0,l);
        memset(suf,0,l);
        search(text, pattern,true);
        reverse(text.begin(), text.end());
        reverse(pattern.begin(), pattern.end());
        search(text, pattern,false);
        int cont = 0;
        for (int i = 0; i <= l-pattern.length(); i++) {
            int value = pre[i] + suf[(l-1-i)-(pattern.length()-1)];
            if ( value >= pattern.length()-k ) {
                cont++;
            }
        }
        cout << cont << "\n";
    }
    return 0;
}
