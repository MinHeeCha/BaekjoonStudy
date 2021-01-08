#include <iostream>
#include <string>
using namespace std;

int AddCycle(int user) {
    int left, right;
    int result = 0, sum = 0;
    static int count = 0, userNum = user;

    left = user / 10;
    right = user % 10;
    sum = left + right;

    result = right * 10 + sum % 10;

    /*cout << "left : " << left << " / right : " << right << endl;
    cout << "result : " << result << " / count : " << count << endl;*/

    count++;
    if (result == userNum)
        return count;
    else
        int temp = AddCycle(result);
}

int main() {
    int count, user;

    cin >> user;
    if (user < 0 || user > 99) {
        cout << "Input 0 ~ 99 numver!" << endl;
        return 0;
    }

    count = AddCycle(user);
    
    cout << count << endl;

    return 0;
}