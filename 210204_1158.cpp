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
    // int GetFront() {
    //     if (!IsEmpty())
    //         return values[frontIdx];
    //     else
    //         return -1;
    // }
    // int GetBack() {
    //     if (!IsEmpty())
    //         return values[rearIdx - 1];
    //     else
    //         return -1;
    // }
    // int GetSize() {#include <iostream>
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
    // int GetFront() {
    //     if (!IsEmpty())
    //         return values[frontIdx];
    //     else
    //         return -1;
    // }
    // int GetBack() {
    //     if (!IsEmpty())
    //         return values[rearIdx - 1];
    //     else
    //         return -1;
    // }
    // int GetSize() {
    //     return dataSize;
    // }
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
    int totPeople, idx;

    cin >> totPeople;
    cin >> idx;
    Queue q(totPeople);

    for (int i = 0; i < totPeople; i++) {
        q.Push(i + 1);
        cout << (i + 1) << endl;
    }

    /*while (true) {
        if (q.IsEmpty())
            break;

        int count = 1;
        while (true) {
            int temp = q.Pop();

            if (count % 3 == 0) {
                cout << temp << ", ";
                count = 0;
                break;
            }
            q.Push(temp);

            count++;
        }
    }*/

    return 0;
}
    //     return dataSize;
    // }
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
    int totPeople, idx;

    cin >> totPeople;
    cin >> idx;
    Queue q(totPeople);

    

    return 0;
}