#include <iostream>
using namespace std;

class Stack {
public:
    int curSize, maxSize;
    int* values;

    Stack(int size) {
        maxSize = size;
        values = new int[size];
        curSize = -1;
    }
    ~Stack() {
        delete[] values;
    }

    void Push(int value) {
        if (!IsFull())
            values[++curSize] = value;
        else
            cout << "Stack is full" << endl;
    }
    void Pop() {
        if (!IsEmpty())
            curSize--;
        else
            cout << "-1" << endl;
    }
    int Top() {
        if (!IsEmpty()) {
            //cout << "top : " << values[curSize] << endl;
            return values[curSize];
        }
        else
            return NULL;
    }
    bool IsEmpty() {
        //cout << "Is Empty : " << curSize << endl;
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

void Print(Stack& s) {
    int* temp = s.values;
    int size = s.curSize;

    for (int i = 0; i < size + 1; i++)
        cout << temp[i] << " -> ";

    cout << endl;
}

int main() {
    int maxSize;
    
    cin >> maxSize;
    Stack st(maxSize);

    while (true) {
        char user[10];

        cin >> user;
        if (strcmp(user, "push") == 0) {
            int temp;
            cin >> temp;

            st.Push(temp);
            cout << "curren size :" << (st.curSize + 1) << endl;
        }
        else if (strcmp(user, "pop") == 0) {
            cout << st.Top() << endl;
            //st.Pop();
        }
        else if (strcmp(user, "top")) {
            cout << st.Top() << endl;
        }
        else if (strcmp(user, "size")) {
            cout << st.curSize << endl;
        }
        else if (strcmp(user, "empty")) {
            int temp = 0;

            if (st.IsEmpty())
                temp = 1;

            cout << temp << endl;
        }
        else
            cout << "Wrong input" << endl;
    }
    

    return 0;
}