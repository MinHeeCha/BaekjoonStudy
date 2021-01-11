#include <iostream>
#include <string>
#include <cmath>
#include <deque>
using namespace std;

int bin(string user) {
    int num = 0, index;

    for (int i = 0; i < user.length(); i++) {
        if (user[i] == '1') {
            index = user.length() - 1 - i;
            num += pow(2, index);
        }
    }

    return num;
}

int main() {
    string user1, user2;
    deque<int> result;
    int num1 = 0, num2 = 0, sum = 0;

    cin >> user1 >> user2;

    num1 = bin(user1);
    num2 = bin(user2);

    cout << "num1 : " << num1 << endl;
    cout << "num2 : " << num2 << endl;

    sum = num1 + num2;

    cout << "sum : " << sum << endl;

    cout << "result : ";
    if (sum == 0)
        cout << "0" << endl;
    else {
        for (int i = 0; sum != 0; i++) {
            result.push_front(sum % 2);
            sum /= 2;
        }
        for (int i = 0; i < result.size(); i++)
            cout << result.at(i);
    }

    return 0;
}