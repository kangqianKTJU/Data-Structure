package test.mylist;

import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E>{
	
	private static final int DEFAULT_CAPACITY = 10; 
	private E[] theItems;
	private int size;
	private int capacity;
	
	public MyArrayList(){
		ensureCapacity(DEFAULT_CAPACITY);
		capacity = DEFAULT_CAPACITY;
	}
	
	public MyArrayList(int capacity){
		ensureCapacity(capacity);
		this.capacity = capacity;
	}
	
	public void clear(){
		size = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void trimToSize(){
		ensureCapacity(size);
	}
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity){
		if(newCapacity < size){
			return;
		}
		E[] old = theItems;
		theItems = (E[])new Object[newCapacity];
		for(int i = 0; i < size(); i++){
			theItems[i] = old[i];
		}
	}
	
	public E get(int index){
		if(index < 0 || index > size){
			throw new ArrayIndexOutOfBoundsException();
		}
		return  theItems[index];
	}
	
	public E set(int index,E obj){
		if(index < 0 ||  index > size ){
			throw new ArrayIndexOutOfBoundsException();
		}
		E old = theItems[index];
		theItems[index] = obj;
		return old;
	}
	
	public boolean add(int index,E obj){
		if(size == capacity){
			ensureCapacity(1 + capacity*2);
		}
		for(int i = size; i > index; i--){
			theItems[i] = theItems[i-1];
		}
		theItems[index] = obj;
		size++;
		return true;
	}
	
	public boolean add(E obj){
		return add(size,obj);
	}
	
	public E remove(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("No such element");
		}
		E obj = theItems[index];
		for(int i=index ; i <size-1; i++){
			theItems[index] = theItems[index+1];
		}
		size--;
		return obj;
	}
	
	public Iterator<E> iterator() {
		return new Ite();
	}
	
	private class Ite implements Iterator<E>{
		
		private int current =0;
		
		public boolean hasNext(){
			if(current == size){
				return false;
			}else{
				return true;
			}
		}
		
		public E next(){
			if(hasNext()){
				return theItems[current++];
			}
			else{
				throw new RuntimeException("No such element");
			}
				
		}	
		
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}
	
	
}