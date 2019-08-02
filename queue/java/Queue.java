package chap2.queue;

public interface Queue<E> {
    public void enqueue(E e);
    public E dequeue();

    public boolean isEmpty();
    public int getSize();

    public E getFront();
}
