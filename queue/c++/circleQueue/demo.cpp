#include <iostream>
#include <stdlib.h>
#include "MyQueue.h"
#include "Customer.h"
#include <string>
using namespace std;

//实现环形队列
int main(void){
    MyQueue *p = new MyQueue(4);
	Customer c1("kkq", 24);
	Customer c2("张杨", 23);
	Customer c3("陈霞", 23);
	Customer c4("李琴", 22);

	p->EnQueue(c1);
	p->EnQueue(c2);
	p->EnQueue(c3);
    p->EnQueue(c4);
    p->Traverse();


	Customer c5(" ",2);
	cout << "empty："<<p->IsEmpty() <<endl;
	cout << "FULL："<<p->IsFull() <<endl;
	p->DeQueue(c5);
//	c5.printInfo();
    p->Traverse();

//	cout << endl;
//	Customer c5();
//
//	p->DeQueue(c5);


//	cout << endl;
//	p->DeQueue(c6);
//	cout << c6 << endl;
//
//	cout << endl;
//	p->QueueTraverse();
//
//	p->ClearQueue();
//	p->QueueTraverse();

//    cout << endl;
//	p->EnQueue(20);
//	p->EnQueue(30);
//	p->QueueTraverse();

	delete p;
	p = NULL;
	system("pause");
	return 0;
}
