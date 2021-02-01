#include <iostream>
#define MAXSIZE 5
using namespace std;

class Stack {
public:
    int top, size;
    int* values;

    Stack() {
        size = MAXSIZE;
        values = new int[size];
        top = -1;
    }
    ~Stack() {
        delete[] values;
    }

    void push(int value) {
        if (!isFull)
            values[++top] = value;
        else
            cout << "Stack is full" << endl;
    }
    void pop() {
        if (!isEmpty)
            top--;
        else
            cout << "Stack is empty" << endl;
    }
    int top() {
        if (!isEmpty)
            return values[top];
        else
            return NULL;
    }
    bool isEmpty() {
        if (top < 0)
            return true;
        else
            return false;
    }
    bool isFull() {
        if (top + 1 == size)
            return true;
        else
            return false;
    }
};

void print(Stack& s) {
    int* temp = s.values;
    int size = s.top;

    if (int i = 0; i < size; i++)
        cout << 
}

int main() {

    return 0;
}