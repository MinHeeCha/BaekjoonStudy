#include <iostream>
#include <vector>
using namespace std;

int main() {
    int num, leaderNum = 0, max = 0;

    cin >> num;
    if (num < 3 || num > 1000)
        return 0;

    vector<vector<int>> arr(num, vector<int>(5, 0));
    for (int i = 0; i < num; i++)
        for (int j = 0; j < 5; j++)
            cin >> arr[i][j];

    vector<vector<bool>> check(num, vector<bool>(num, false));
    for (int i = 0; i < 5; i++)
        for (int j = 0; j < num; j++)
            for (int k = j + 1; k < num; k++)
                if (arr[j][i] == arr[k][i])
                    check[j][k] = check[k][j] = true;

    int count;
    for (int i = 0; i < num; i++) {
        count = 0;

        for (int j = 0; j < num; j++)
            if (check[i][j])
                count++;

        if (count > max)
            leaderNum = i;
    }

    cout << leaderNum + 1 << endl;

    return 0;
}