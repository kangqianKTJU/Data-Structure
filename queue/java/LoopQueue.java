package chap2.queue;

import java.util.Arrays;

public class LoopQueue<E> implements Queue<E>{
    private E[] elements;
    private int head;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        elements = (E[]) new Object[capacity];
    }

    public LoopQueue(){
        elements = (E[]) new Object[10];
    }


    @Override
    public void enqueue(E e) {
        if(size == getCapacity()){
            resize(2 * getCapacity());
        }
        elements[tail] = e;
        tail = (tail + 1) % elements.length;
        size++;
    }

    private void resize(int newCapacity){
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[(head + i) % elements.length];
        }
        elements = newElements;
        head = 0;
        tail = size;
    }

    public int getCapacity(){
        return elements.length;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Empty quque");
        else{
            E res = elements[head];
            head = ++head % getCapacity();
            size--;
            if(size < getCapacity() / 4 && getCapacity() / 2 != 0){
                resize(getCapacity() /2 );
            }
            return res;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("empty queue");
        else
            return elements[head];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,getCapacity()));
        res.append("front  ->>[");
        for(int i = 0; i < size; i++){
            int index = (i + head) % getCapacity();
            if(i != size - 1){
                res.append(elements[index] + ", ");
            }else{
                res.append(elements[index]);
                break;
            }
        }
        res.append("] tail\n");
        return res.toString();
    }
}
