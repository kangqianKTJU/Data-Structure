import java.util.Arrays;
import java.util.EmptyStackException;

// Stack base on variable array
public class MyStack<E>{

    private final int DEFAULT_CAPACITY = 10;
    private final Object[] EMPTY_STACK = new Object[0];
    private Object[] elements;
    private int size;
    private int capacity;

    public MyStack(){
        elements = EMPTY_STACK;
        size = 0;
    }

    public MyStack(int capacity){
        elements = new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public void push(E e){
        if(elements == EMPTY_STACK){
            elements = new Object[DEFAULT_CAPACITY];
            capacity = DEFAULT_CAPACITY;
        }
        if(size >= capacity){
            capacity += capacity >> 1;
            Object[] newElements = Arrays.copyOf(elements, capacity);
            elements = newElements;
        }
        elements[size++] = e;
    }

    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("empty statck");
        }
        return (E)elements[--size];
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException("empty statck");
        }
        return elements[size - 1];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
     
}