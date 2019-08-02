package chap2.queue;

import chap1.array.Array;

public class ArrayQueue<E> implements Queue<E>{

    private Array<E> data = new Array<>();

    public ArrayQueue(){
        data = new Array<>();
    }

    public ArrayQueue(int capacity){
        data = new Array<>(capacity);
    }

    @Override
    public void enqueue(E element) {
        data.addLast(element);
    }

    @Override
    public E dequeue() {
        return data.deleteFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Queue: head -> [");
        for(int i = 0; i < data.getSize(); i++){
            if(i == data.getSize() -1){
                str.append(data.get(i) + "] tail\n");
                break;
            }
            str.append(data.get(i) + ", ");
        }

        return str.toString();
    }

}
