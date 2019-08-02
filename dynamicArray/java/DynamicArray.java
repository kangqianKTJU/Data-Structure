package chap1.array;

import java.util.Arrays;

public class DynamicArray<E> {
    private E[] elements;
    private int size;
    private int capacity;
    private final static int DEFAULT_CAPACITY = 10;


    // 带初始容量的构造函数
    public DynamicArray(int capacity){
        elements = (E[])new Object[capacity];
        size = 0;
        this.capacity =capacity;
    }

    // 默认的构造函数
    public DynamicArray(){
        this(DEFAULT_CAPACITY);
    }


    // 在指定位置添加元素
    public void add(int index, E e){
        if(index < 0 || index > size) throw new IllegalArgumentException("数组索引越界：index out of boundry");

        if(size == capacity){
            capacity = capacity  << 1 ;
            resize(capacity);
        }
        for(int i = size - 1; i >= index; i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = e;
        size++;
    }

    // 头部添加元素
    public void addFirst(E e){
        add(0, e);
    }

    // 尾部添加元素
    public void addLast(E e){
        add(size, e);
    }

    // 数组扩容
    private void resize(int newCapacity){
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // 获取指定位置元素
    public E get(int index){
        if(index < 0 || index > size - 1){
            throw new IllegalArgumentException("数组索引越界：index out of boundry");
        };
        return elements[index];
    }

    // 获取头部元素
    public E getFirst(){
        return get(0);
    }

    // 获取尾部元素
    public E getLast(){
        return get(size - 1);
    }


    // 设置指定位置的值
    public void set(int index, E e){
        if(index < 0 || index > size - 1){
            throw new IllegalArgumentException("数组索引越界：index out of boundry");
        };
        elements[index] = e;
    }


    // 数组大小
    public int getSize(){
        return size;
    }

    // 获取容量
    public int getCapacity(){
        return capacity;
    }

    // 判空
    public boolean isEmpty(){
        return size == 0;
    }

    // 是否含有元素
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(e)){
                return true;
            }
        }
        return  false;
    }

    // 查找元素
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 删除指定位置元素
    public E delete(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("delete: the element does not exist,index out of range");
        }
        E res = elements[index];
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        size--;
        if(size == capacity / 4 && capacity / 2 != 0)
            resize(capacity / 2);
        return res;
    }

    // 删除头元素
    public E deleteFirst(){
        return delete(0);
    }

    // 删除末尾元素
    public E deleteLast(){
        return delete(size - 1);
    }

    // 删除指定元素
    public void deleteElemnet(E e){
        int index = find(e);
        if(index != -1){
            delete(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array: size = %d, capacity = %d\n",size, capacity));
        str.append("[");
        for(int i = 0; i < size ; i++){
            if(i == size - 1) str.append(elements[i] + "]\n");
            str.append(elements[i] + ", ");
        }
        return str.toString();

    }
}
