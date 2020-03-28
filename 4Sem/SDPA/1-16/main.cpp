#include <iostream>
#include <ctime>
#include <cstdlib>
#include <locale>
using namespace std;

struct Tree {
    int Data;
    Tree* Left;
    Tree* Right;
};

int k;
int a[20], b[1];

Tree* createTree() {
    Tree* root = new Tree;
    root->Data = rand() % 100;
    b[0] = root->Data;
    cout << "Корень дерева: " << b[0] << " " << endl;
    root->Left = NULL;
    root->Right = NULL;
    return root;
}

void printTree(Tree* const root, int l = 0) {
    Tree* current = root;
    if (current) {
        printTree(current->Left, l + 5);
        for (int i = 0; i < l; i++)
            cout << " " << "|";
        cout << current->Data << "________" << endl;
        printTree(current->Right, l + 5);
    }
}

void fillTree(Tree * const root, int n) {
    for (int i = 0; i < n; i++) {

        Tree* item = new Tree;
        item->Data = rand() % 100;

        a[i] = item->Data;
        cout << a[i] << " ";

        item->Left = NULL;
        item->Right = NULL;

        Tree* current = root;
        Tree* previous = NULL;

        while (current) {
            if (current->Data != item->Data) {
                if (current->Data < item->Data) {
                    previous = current;
                    current = current->Right;
                }
                else {
                    previous = current;
                    current = current->Left;
                }
            }
            else {
                if ((rand() % 100) / 2 == 0) {
                    previous = current;
                    current = current->Left;
                }
                else {
                    previous = current;
                    current = current->Right;
                }
            }
        }

        if (!(previous->Data == item->Data)) {
            if (previous->Data < item->Data)
                previous->Right = item;
            else
                previous->Left = item;
        }
        else {
            delete item;
        }
    }
    cout << endl;
}

int getAverage(int* c, int n)
{
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        sum += c[i];
    }
    return sum / n;
}

int nearestElement(int* c, int average)
{
    int minDifference = abs(c[0] - average);
    int element = 0;

    for (int j = 1; j < k; j++)
    {
        if (abs(c[j] - average) < minDifference)
        {
            minDifference = abs(c[j] - average);
            element = c[j];
        }
    }
    return element;
}

int main() {

    setlocale(LC_ALL, "rus");
    srand(time(NULL));

    Tree* const root = createTree();

    cout << "Введите количество элементов дерева в диапазоне от 1 до 10" << endl;
    cin >> k;
    if (k > 10 || k < 1)
    {
        cout << "Введено некорректное значение." << endl;
        return 0;
    }

    cout << "Элементы дерева: ";
    fillTree(root, k - 1);

    cout << "________________________________________________________" << endl << endl;
    printTree(root);
    cout << "________________________________________________________" << endl << endl;

    int c[11];

    c[0] = b[0];

    for (int i = 1; i < k + 1; i++)
    {
        c[i] = a[i - 1];
    }

    for (int i = 0; i < k; i++)
        cout << c[i] << " ";

    cout << "Среднее арифметическое элементов: " << getAverage(c, k) << endl;
    cout << endl << "Элемент, ближайший к среднему арифметическому: " << nearestElement(c, getAverage(c,k)) << endl;

    return 0;
}

