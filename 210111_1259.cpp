#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    int i = 0, len;
    string result;
    vector<string> user;

    while (true) {
        cin >> user[i];
        
        if (user[i] == "0")
            break;
    }

    for (i = 0; i < user.size() - 1; i++) {
        len = user[i].length();
        result = "yes";

        for (int j = 0; j < len / 2; i++) {
            if (user[i][j] != user[i][len - 1 - j])
                result = "no";
        }
        
        cout << result << endl;
    }


    return 0;
}