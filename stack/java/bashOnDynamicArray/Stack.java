package chap2.stack;

public interface Stack<E> {

    public void push(E element);
    public E pop();
    public E peek();

    public boolean isEmpty();
    public int getSize();

}
