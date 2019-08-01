#include <iostream>
#include "Customer.h"
#include "MyQueue.h"
#include <string>
using namespace std;

MyQueue::MyQueue(int Capacity){
    m_pQueue = new Customer[Capacity];
    m_iQueueCapacity = Capacity;
    ClearQueue();
}

MyQueue::~MyQueue(){
    delete []m_pQueue;
	m_pQueue = NULL;
}

void MyQueue::ClearQueue(){
    m_iHead = 0;
    m_iTail = 0;
    m_iQueueSize = 0;
}

bool MyQueue::IsEmpty() const{
    return m_iQueueSize == 0;
}

bool MyQueue::IsFull() const{
    return m_iQueueSize == m_iQueueCapacity;
}

int MyQueue::QueueSize() const{
    return m_iQueueSize;
}

bool MyQueue::EnQueue(Customer element){
    if(IsFull()) return false;
    m_pQueue[m_iTail] = element;
    m_iTail = (m_iTail + 1) % m_iQueueCapacity;
    m_iQueueSize++;
    return true;
}

bool MyQueue::DeQueue(Customer &element){
    if(IsEmpty()) return false;
    element = m_pQueue[m_iHead];
    m_iHead++;
    m_iHead = m_iHead % m_iQueueCapacity;
    m_iQueueSize--;
    return true;
}

void MyQueue::Traverse(){
    cout << "[";
    for(int i = 0; i < m_iQueueSize; i++){
        m_pQueue[(i + m_iHead) % m_iQueueCapacity].printInfo();
    }
    cout << "]" <<endl;
}
