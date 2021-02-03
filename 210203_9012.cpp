#include <iostream>
#include <cstring>
#include <string>

#define STACK_SIZE 50
using namespace std;

class Stack {
public:
    int curSize, maxSize;
    char* values;

    Stack(int size) {
        maxSize = size;
        values = new char[size];
        curSize = -1;
    }
    ~Stack() {
        delete[] values;
    }

    bool Push(int value) {
        if (!IsFull()) {
            values[++curSize] = value;
            return true;
        }
        else
            return false;
    }
    bool Pop() {
        if (!IsEmpty()) {
            curSize--;
            return true;
        }
        else
            return false;
    }
    int Top() {
        if (!IsEmpty())
            return values[curSize];
        else
            return -1;
    }
    bool IsEmpty() {
        if (curSize < 0)
            return true;
        else
            return false;
    }
    bool IsFull() {
        if (curSize + 1 == maxSize)
            return true;
        else
            return false;
    }
};

int main() {
    int userSize;
    string user;

    cin >> userSize;
    for (int i = 0; i < userSize; i++) {
        Stack st(STACK_SIZE);
        bool isRight = true;

        cin >> user;

        for (int j = 0; j < user.length(); j++) {
            if (user.at(j) == '(') {
                if (!st.Push('('))
                    isRight = false;
            }
            else if (user.at(j) == ')') {
                if (!st.Pop())
                    isRight = false;
            }
        }
        if (!st.IsEmpty())
            isRight = false;

        if (isRight)
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }

    return 0;
}