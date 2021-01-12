#include <iostream>
using namespace std;

bool isLeap(int year) {
    if (year % 4 == 0)
        return true;
    if (year % 100 == 0)
        return false;
    if (year % 400 == 0)
        return true;

    return false;
}

int calcDays(int y, int m, int d) {
    int days = 0;
    const int months[12] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    for (int i = 0; i < y; ++i)
        days += 365 + isLeap(i);
    for (int i = 0; i < m; ++i) {
        if (i == 1)
            days += isLeap(y);
        days += months[i];
    }

    return days + d;
}

int main() {
    int y1, m1, d1, y2, m2, d2;

    cin >> y1 >> m1 >> d1 >> y2 >> m2 >> d2;

    if (y1 > y2 || y1 < 1 || y1 > 9999 || y2 < 1 || y2 > 9999)
        return 0;

    int days1 = calcDays(y1, m1, d1);
    int days2 = calcDays(y2, m2, d2);

    cout << "D-" << (days2 - days1) << endl;

    return 0;
}