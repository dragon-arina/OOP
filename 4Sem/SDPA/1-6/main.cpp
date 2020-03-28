#include <iostream>
#include <ctime>
#include <cstdlib>
#include <locale>
using namespace std;

struct Tree {
    int data;
    Tree* Left;
    Tree* Right;
};

int k;
int a[50], b[1];

Tree* createTree() {
    Tree* root = new Tree;
    root->data = rand() % 100;
    b[0] = root->data;
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
        cout << current->data << "________" << endl;
        printTree(current->Right, l + 5);
    }
}


void fillTree(Tree * const root, int n) {
    for (int i = 0; i < n; i++) {

        Tree* item = new Tree;
        item->data = rand() % 100;

        a[i] = item->data;
        cout << a[i] << " ";

        item->Left = NULL;
        item->Right = NULL;

        Tree* current = root;
        Tree* previous = NULL;

        while (current) {
            if (current->data != item->data) {
                if (current->data < item->data) {
                    previous = current;
                    current = current->Right;
                }
                else {
                    previous = current;
                    current = current->Left;
                }
            }
            else { //если элемент равен корню, то он отправляется либо налево, либо направо
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

        if (!(previous->data == item->data)) {
            if (previous->data < item->data)
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

int countOfRepeatingElements(int* c, int l)
{
    for (int j = 0; j < k; j++)
        for (int i = j + 1; i < k + 1; i++)
            if (c[j] == c[i])
            {
                cout << c[i] << " " << endl;
                l++;
            }
    return l;
}

int main() {

    setlocale(LC_ALL, "rus");
    srand(time(NULL));

    Tree* const root = createTree();

    cout << "Введите количество элементов дерева" << endl;
    cin >> k;
    cout << "Элементы дерева: " << endl;
    fillTree(root, k - 1);

    cout << "________________________________________________________" << endl << endl;
    printTree(root);
    cout << "________________________________________________________" << endl;

    int c[11];

    c[0] = b[0];

    for (int i = 1; i < k + 1; i++)
    {
        c[i] = a[i - 1];
    }

    for (int i = 0; i < k; i++)
        cout << c[i] << " ";

    int l = 0;

    if (l != 0)
    {
        cout << endl << "Количество повторяющихся элементов: " << countOfRepeatingElements(c, l);
        cout << endl << "Повторяющиеся элементы: " << endl;
    }
    else
        cout << endl << "\nПовторяющихся элементов нет" << endl;


    return 0;
}


