#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int num, leaderNum = 0;

    cin >> num;
    if (num < 3 || num > 1000)
        return 0;

    vector<vector<int>> arr(num, vector<int>(5, 0));
    for (int i = 0; i < num; i++)
        for (int j = 0; j < 5; j++)
            cin >> arr[i][j];

    vector<int> result(num);
    for (int i = 0; i < num; i++)
        for (int j = 0; j < 4; j++)
            if (arr[j][i] == arr[j + 1][i]) {
                result[j]++;
                result[j + 1]++;
            }

    for (int i = 0; i < num; i++)
        if (result[leaderNum] < result[i])
            leaderNum = i;

    cout << leaderNum + 1 << endl;

    return 0;
}