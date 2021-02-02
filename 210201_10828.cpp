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

    void Push(int value) {
        if (!IsFull())
            values[++top] = value;
        else
            cout << "Stack is full" << endl;
    }
    void Pop() {
        if (!IsEmpty())
            top--;
        else
            cout << "Stack is empty" << endl;
    }
    int Top() {
        if (!IsEmpty())
            return values[top];
        else
            return NULL;
    }
    bool IsEmpty() {
        if (top < 0)
            return true;
        else
            return false;
    }
    bool IsFull() {
        if (top + 1 == size)
            return true;
        else
            return false;
    }
};

void Print(Stack& s) {
    int* temp = s.values;
    int size = s.top;

    for (int i = 0; i < size + 1; i++)
        cout << temp[i] << " -> ";

    cout << endl;
}

int main() {
    Stack st;

    st.Push(1);
    st.Push(2);

    Print(st);

    st.Push(3);
    st.Push(4);

    Print(st);

    st.Pop();
    st.Pop();

    Print(st);


    return 0;
}