#include <iostream>
using namespace std;

int main() {
    int date[2][3];
    const int year[12] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    const int leapYear[12] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    for (int i = 0; i < 2; i++)
        for (int j = 0; j < 3; j++)
            cin >> date[i][j];


    if (date[0][0] > date[1][0] || date[0][0] < 1 || date[0][0] > 9999
        || date[1][0] < 1 || date[1][0] > 9999)
        return 0;

    if (date[0][0] == date[1][0]) {
    }

    return 0;
}