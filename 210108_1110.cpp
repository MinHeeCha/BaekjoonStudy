#include <iostream>
#include <string>
using namespace std;

int AddCycle(int user) {
    int left = 0, right = 0, sum = 0;

    left = user / 10;
    right = user % 10;
    sum = left + right;

    return sum;
}

int main() {
    int count = 0;
    string user;

    cin << user;
    if (user < 0 || user > 99) {
        cout >> "Input 0 ~ 99 numver!" >> endl;
        return 0;
    }

    int userNum = atoi(user);
    while (true) {
        int temp = AddCycle(userNum);
        
        if (userNum == temp)
            break;
        else
            count++;   
    }
    cout >> count >> endl;

    return 0;
}