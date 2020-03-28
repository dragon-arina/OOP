#include <iostream>

#include <vector>
#include <locale>

using namespace std;

struct Node
{
    Node* parent = NULL;
    string value = "";
    Node* left = NULL;
    Node* right = NULL;
};

int treeHeight(Node* tree)
{
    if (tree == NULL || (tree->left == NULL && tree->right == NULL))
    {
        return 0;
    }
    int leftDepth = treeHeight(tree->left);
    int rightDepth = treeHeight(tree->right);
    return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
}

void addNode(Node*& tree, string value, Node* _parent)
{
    if (tree == NULL)
    {
        tree = new Node;
        tree->parent = _parent;
        tree->value = value;
        tree->right = tree->left = NULL;
    }
}

void aIsParentOfB(Node* A, string B, bool &answer)
{
    if (A != NULL)
    {
        if (A->value == B)
        {
            answer = true;
            return;
        }
        else
        {
            aIsParentOfB(A->left, B, answer);
            aIsParentOfB(A->right, B, answer);
        }
    }
}

void wayBack(Node* node, vector<string>& vec, bool& flag)
{
    if (node->parent != NULL)
    {
        vec.push_back(node->parent->value);
        wayBack(node->parent, vec, flag);
    }
    else
    {
        return;

    }
}

void findNode(Node* tree, string A, Node*& returnTree)
{
    if (tree != NULL)
    {
        if (tree->value == A)
        {
            returnTree = tree;
        }
        else
        {
            findNode(tree->left, A, returnTree);
            findNode(tree->right, A, returnTree);
        }
    }
}

string nearestCommonParent(vector <string> firstWay, vector <string> secondWay)
{
    for (int i = 0; i < firstWay.size(); i++)
    {
        for (int j = 0; j < secondWay.size(); j++)
        {
            if (firstWay[i] == secondWay[j])
            {
                return firstWay[i];
            }
        }
    }
}

void freeVariables(bool& fflag, bool& sflag, Node*& fnode, Node*& snode, Node*& fres, Node*& sres, vector <string>& fvec, vector <string>& svec)
{
    fflag = NULL;
    sflag = NULL;
    fnode = NULL;
    snode = NULL;
    fres = NULL;
    sres = NULL;
    fvec.clear();
    svec.clear();
}


string outputResult(Node* &answer)
{
    if (answer != NULL)
        return "Да";
    else
        return "Нет";
}

int main()
{
    setlocale(LC_ALL, "rus");
    Node* MyTree = NULL;
    addNode(MyTree, "Oleg", NULL);
    addNode(MyTree->left, "Dima", MyTree);
    addNode(MyTree->right, "Alex", MyTree);
    addNode(MyTree->left->left, "Gregg", MyTree->left);
    addNode(MyTree->left->right, "Owen", MyTree->left);
    addNode(MyTree->right->left, "Daniel", MyTree->right);
    addNode(MyTree->right->right, "Tim", MyTree->right);
    addNode(MyTree->right->right->right, "David", MyTree->right->right);

    string fname = "", sname = "";

    cout << "Введите имя предка: ";
    cin >> fname;
    cout << "Введите имя потомка: ";
    cin >> sname;

    cout << "Задание 1. " << fname << " является предком " << sname << endl;
    Node* first = NULL;
    Node* firstAnswer = NULL;
    findNode(MyTree, fname, first);
    findNode(first, sname, firstAnswer);
    cout << "Ответ: " + outputResult(firstAnswer) << endl << endl;

    cout << "Введите имя предка: ";
    cin >> fname;
    cout << "Введите имя потомка: ";
    cin >> sname;

    cout << "Задание 2.  " << sname << " является потомком " << fname << endl;
    Node* second = NULL;
    Node* secondAnswer = NULL;
    findNode(MyTree, fname, second);
    findNode(second, sname, secondAnswer);
    cout << "Ответ: " + outputResult(secondAnswer) << endl << endl;

    cout << "Введите 1 имя ";
    cin >> fname;
    cout << "Введите 2 имя ";
    cin >> sname;

    cout << "Задание 3. Ближайшего общего предка " << fname << "'a и " << sname << "'а: " << endl;
    bool firstFlag = false;
    bool secondFlag = false;
    Node* firstNode = NULL;
    Node* firstResult = NULL;
    Node* secondNode = NULL;
    Node* secondResult = NULL;
    vector <string> firstWay;
    vector <string> secondWay;

    findNode(MyTree, fname, firstNode);
    findNode(MyTree, sname, secondNode);
    wayBack(firstNode, firstWay, firstFlag);
    wayBack(secondNode, secondWay, secondFlag);
    cout << "Ответ: " << nearestCommonParent(firstWay, secondWay);

    freeVariables(firstFlag, secondFlag, firstNode, secondNode, firstResult, secondResult, firstWay, secondWay);

    getchar();
}
