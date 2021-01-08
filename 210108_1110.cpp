#include <iostream>
using namespace std;

int main() {
    int count = 0, user;
    int left = 0, right = 0;
    int result = 0, sum = 0;

    cin >> user;
    if (user < 0 || user > 99) {
        cout << "Input 0 ~ 99 numver!" << endl;
        return 0;
    }

    result = user;

    while (1) {
        left = result / 10;
        right = result % 10;
        sum = left + right;
        result = right * 10 + sum % 10;
        count++;

        if (result == user)
            break;
    }
    cout << count << endl;

    return 0;
}