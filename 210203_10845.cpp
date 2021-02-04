#include <iostream>
#include <cstring>
#include <string>

using namespace std;

class Queue {
private:
    int frontIdx, rearIdx;
    int dataSize, maxSize;
    int* values;

public:
    Queue(int size) {
        frontIdx = 0;
        rearIdx = 0;
        dataSize = 0;
        maxSize = size;
        values = new int[size];
    }
    ~Queue() {
        delete[] values;
    }

    void Push(int data) {
        if (!IsFull()) {
            values[rearIdx] = data;
            rearIdx++;
            dataSize++;
        }
        else
            cout << "-1" << endl;
    }
    int Pop() {
        int temp;

        if (!IsEmpty()) {
            temp = values[frontIdx];
            frontIdx++;
            dataSize--;

            return temp;
        }
        else
            return -1;
    }
    int GetFront() {
        if (!IsEmpty())
            return values[frontIdx];
        else
            return -1;
    }
    int GetBack() {
        if (!IsEmpty())
            return values[rearIdx - 1];
        else
            return -1;
    }
    int GetSize() {
        return dataSize;
    }
    bool IsEmpty() {
        if (dataSize == 0)
            return true;
        else
            return false;
    }
    bool IsFull() {
        if (frontIdx + 1 + dataSize == maxSize)
            return true;
        else
            return false;
    }
};

int main() {
    int maxSize;

    cin >> maxSize;
    Queue q(maxSize);

    while (true) {
        char user[10];

        cin >> user;
        if (strcmp(user, "push") == 0) {
            int data;

            cin >> data;
            q.Push(data);
        }
        else if (strcmp(user, "pop") == 0) {
            cout << q.Pop() << endl;
        }
        else if (strcmp(user, "size") == 0) {
            cout << q.GetSize() << endl;
        }
        else if (strcmp(user, "empty") == 0) {
            int empty = 0;

            if (q.IsEmpty())
                empty = 1;

            cout << empty << endl;
        }
        else if (strcmp(user, "front") == 0) {
            cout << q.GetFront() << endl;
        }
        else if (strcmp(user, "back") == 0) {
            cout << q.GetBack() << endl;
        }
        else
            break;
    }

    return 0;
}