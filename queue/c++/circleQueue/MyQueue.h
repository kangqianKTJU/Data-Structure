/*
环形队列
*/

#ifndef MYQUEUE_H
#define MYQUEUE_H

#include "Customer.h"

class MyQueue{

public:
    MyQueue(int capacity); // 创建队列
    ~MyQueue();  //销毁队列
    bool DeQueue(Customer &element);  // 出队列
    bool EnQueue(Customer element);
    void DestoryQueue() const;  // 清空队列
    void ClearQueue();
    int QueueSize() const;
    bool IsEmpty() const;  // 判断空队列
    bool IsFull() const;  // 判断是否满队列
    void Traverse();

private:
    Customer *m_pQueue;
    int m_iHead;
    int m_iTail;
    int m_iQueueSize;
    int m_iQueueCapacity;
};

#endif
