#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    int index;
    int max = 0, maxIdx;
    char result;
    string user;
    vector<int> alphabet(26);

    cin >> user;

    for (int i = 0; i < user.length(); i++) {
        index = user.at(i);

        if (user.at(i) >= 97 && user.at(i) <= 122)
            index -= 32;
        index -= 65;

        alphabet[index]++;
    }

    for (int i = 0; i < alphabet.size(); i++) {
        if (max < alphabet[i]) {
            max = alphabet[i];
            result = i + 65;
        }
        else if (max != 0 && max == alphabet[i])
            result = '?';
    }

    cout << result << endl;

    return 0;
}