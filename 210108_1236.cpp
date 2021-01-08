#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    int n, m;       // 세로 가로
    cin >> n >> m;
    
    if (n > 50 || m > 50) {
        cout << "Input under 50 number!";
        return 0;
    }

    vector<string> rows(n);

    for (int i = 0; i < rows.size(); i++) {
        cin >> rows[i];
    }



    return 0;
}