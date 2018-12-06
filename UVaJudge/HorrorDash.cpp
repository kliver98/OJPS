/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2899
 * @author Kliver Daniel
 */
 #include <iostream>
 using namespace std;

 int main() {
    int N, tmp = 0, cont = 1, times = 0;
    cin >> N;
    while (N-- > 0) {
        int mayor = 0;
        times = 0;
        cin >> times;
        while (times-->0) {
            cin >> tmp;
            if (tmp>mayor)
                mayor = tmp;
        }
        cout << "Case " << cont << ": " << mayor << endl;
        cont++;
    }
    return 0;
 }
