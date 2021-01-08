#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    int n, m;       // 세로 가로
    int r = 0, c = 0;

    cin >> n >> m;
    
    if (n > 50 || m > 50) {
        cout << "Input under 50 number!";
        return 0;
    }

    vector<bool> rows(n);
    vector<bool> cols(m);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            char state;
            cin >> state;

            if (state == 'X') {
                rows[i] = true;
                cols[j] = true;
            }
        }
    }

    for (int i = 0; i < n; i++)
        if (!rows[i])
            r++;
    for (int i = 0; i < m; i++)
        if (!cols[i])
            c++;

    int result = r < c ? c : r;
    cout << result << endl;

    return 0;
}