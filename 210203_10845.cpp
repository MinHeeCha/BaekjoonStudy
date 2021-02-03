#include <iostream>
#include <cstring>
#include <string>

using namespace std;

class Queue {
public:
    int front, rear, maxSize;
    int* values;

    Queue(int size) {
        maxSize = size;
        values = new int[size];
        front = 0;
        rear = 0;
    }
    ~Queue() {
        delete[] values;
    }

    void Push(int value) {

    }
    int Pop() {

    }
    int GetFront() {

    }
    int GetBack() {

    }
    int GetSize() {

    }
    bool IsEmpty() {
        if (front == rear)
            return true;
        else
            return false;
    }
    bool IsFull() {
        if ((rear + 1) % maxSize == front)
            return true;
        else
            return false;
    }
};

int main() {
    int maxSize;

    cin >> maxSize;
    Queue q(maxSize);

    return 0;
}