#include <iostream>
#include <string>
using namespace std;

int main() {
    int num;
    string str[50];

    cin >> num;
    if (num > 50) {
        cout << "Num must be under 50!" << endl;
        return 0;
    }

    for (int i = 0; i < num; i++)
        cin >> str[i];

    char c;
    for (int i = 0; i < str[0].length; i++) {
        c = str[0][i];

        for (int j = 0; j < num; j++) {
            if (c != str[j][i]) {
                c = '?';
                break;
            }
        }
        
        cout << c;
    }

    return 0;
}