#include <iostream>
#include <vector>
using namespace std;

int main() {
    string user, result = "yes";

    while (true) {
        cin >> user;

        if (user == "0")
            break;

        for (int i = 0; i < user.length() / 2; i++) {
            if (user[i] != user[user.length() - 1 - i]) {
                result = "no";
                break;
            }
        }

        cout << result << endl;
    }

    return 0;
}