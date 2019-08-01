#include <iostream>
#include "Customer.h"
#include <string>
using namespace std;
Customer::Customer(string name, int age){
    m_strName = name;
    m_iAge = age;
}

void Customer::printInfo() const{
    cout << "name:" << m_strName << ", age:" << m_iAge <<" | ";
}

