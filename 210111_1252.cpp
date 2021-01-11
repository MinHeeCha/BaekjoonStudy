#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {
    string user1, user2;
    int num1 = 0, num2 = 0, sum = 0;

    /*cin >> num1 >> num2;*/
    user1 = "1001101";
    user2 = "10010";

    int index;
    for (int i = 0; i < user1.length(); i++) {
        if (user1[i] == '1') {
            index = user1.length() - 1 - i;
            num1 += pow(2, index);
        }
    }
    for (int i = 0; i < user2.length(); i++) {
        if (user2[i] == '1') {
            index = user2.length() - 1 - i;
            num2 += pow(2, index);
        }
    }

    cout << num1 << endl;
    cout << num2 << endl;

    return 0;
}