#include <iostream>
using namespace std;

int main() {
    int num;
    char str[3][50];

    cin >> num;
    printf("num : %d\n", num);
    getchar();

    for (int i = 0; i < num; i++) {

        // scanf("%s", &str[i]);
        // cin.getline();
        cin >> str[i];

        // gets(str[i]);

        printf("input %d :%s\n", i + 1, str);
    }
    return 0;
}