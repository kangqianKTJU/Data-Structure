package chap3.linkedList;

import java.beans.Customizer;

public class LinkedList<E> {
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public void addFirst(E e){
        Node newNode = new Node(e);

//        newNode.next = head;
//        head = newNode;
//        newNode = null;

//        head = new Node(e,head);

        add(0,e);
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add: index out of range: needed index <= " + size + ",actually index =" + index);
        }
            Node cursor = dummyHead;
            for(int i = 0; i < index; i++){
                cursor = cursor.next;
            }
            cursor.next = new Node(e,cursor.next);
            size++;
    }


    public void addLast(E e){
//        if(head == null){
//            head = new Node(e);
//        }else{
//            Node cursor = head;
//            while(cursor.next != null){
//                cursor = cursor.next;
//            }
//            cursor.next = new Node(e);
//        }

        add(size,e);
    }

    public E get(int index){

        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get：index out of range, needed index < " + size + ",actually index =" + index);
        }else{
            Node<E> cursor = dummyHead;
            for(int i = 0; i <= index; i++){
                cursor = cursor.next;
            }
            return cursor.e;
        }
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public E set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get：index out of range, needed index < " + size + ",actually index =" + index);
        }else{
            Node<E> cursor = dummyHead.next;
            for(int i = 0; i < index; i++){
                cursor = cursor.next;
            }
            E res = cursor.e;
            cursor.e = e;
            return res;
        }
    }

    public boolean contains(E e){
        Node cursor = dummyHead.next;
        while(cursor != null){
            if(cursor.e.equals(e)){
                return true;
            }
            cursor = cursor.next;
        }return false;
    }


    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get：index out of range, needed index < " + size + ",actually index =" + index);
        }else{
            Node<E> prev = dummyHead;
            for(int i = 0; i < index; i++){
                prev = prev.next;
            }
            Node<E> temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
            size--;
            return temp.e;
        }
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private class Node<E>{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this.e = e;
        }

        public Node(){
            this(null,null);
        }
        public String toString(){
            return e.toString();
        }
    }


    @Override
    public String toString() {
        Node current = dummyHead.next;
        StringBuilder str = new StringBuilder();
        str.append("Head: [");
        while(current != null){
            str.append(current.toString() + " -> ");
            current = current.next;
        }

//        for(Node current = dummyHead.next; current != null; current = current.next){
//            str.append(current.toString() + " -> ");
//        }
        str.append("] null");
        return str.toString();
    }
}
