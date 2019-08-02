package chap2.stack;

import chap1.array.Array;
import chap1.array.DynamicArray;

public class ArrayStack<E> implements Stack<E> {

    private DynamicArray<E> data;
    private int size;

    public ArrayStack(int capacity){
        data = new DynamicArray<E>(capacity);
    }
    public ArrayStack(){
        data = new DynamicArray<E>();
    }

    @Override
    public void push(E element) {
        data.addLast(element);
    }

    @Override
    public E pop() {
        return (E) data.deleteLast();
    }

    @Override
    public E peek(){
        return data.getLast();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Stack: ");
        str.append("[");
        for(int i = 0; i < data.getSize(); i++){
            if(i == data.getSize() -1){
                str.append(data.get(i));
                break;
            }
            str.append(data.get(i) + ", ");

        }
        str.append("] top");
        return str.toString();
    }
}
