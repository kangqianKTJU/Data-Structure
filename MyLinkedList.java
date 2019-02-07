package test.mylist;

import java.nio.channels.IllegalSelectorException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
	
	private int size;
	private int modCount;
	private Node<E> headNode;
	private Node<E> tailNode;
	
	
	private class Node<E>{
		public E nodeValue;
		public Node<E> preNode;
		public Node<E> nextNode;
		
		public Node(E nodeValue, Node<E> preNode,Node<E> nextNode) {
			this.nodeValue = nodeValue;
			this.preNode = preNode;
			this.nextNode = nextNode;
		}

		public E nodeValue() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public MyLinkedList() {
		clear();
	}
	
	public void clear() {
		headNode = new Node<E>(null,null,null);
		tailNode = new Node<E>(null,headNode,null);
		headNode.nextNode = tailNode;
		
		size = 0;
		modCount++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean add(int index, E obj) {
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("请输入索引[0 ~" + size +  "]:"+ index);
		}
		Node temp = headNode;
		for(int i = 0; i < index; i++) {
			temp = temp.nextNode;
		}
		Node<E> temp1= new Node(obj,temp,temp.nextNode);
		temp.nextNode = temp.nextNode.preNode = temp1;
		
		size++;
		modCount++;
		return true;
	}
	
	public void add(E nodeValue) {
		add(size,nodeValue);
	}
	
	private Node<E> getNode(int index) {
		return getNode(index,0,size-1);
	}
	
	private Node<E> getNode(int index, int lower, int high) {
		Node<E> position;
		if(index < lower || index > high) {
			throw new IndexOutOfBoundsException("你输入的索引不存在[0 ~ " + (size-1) + "]:" + index);
		}
		if (index < size()/2) {
			position = headNode.nextNode;
			for(int i = 0; i < index; i++) {
				position = position.nextNode;
			}
		}
		else {
			position = tailNode;
			for(int i = size; i > index; i--) {
				position = position.preNode;
			}
			
		}
		return position;
	}
	
	public E get(int index) {
		return getNode(index).nodeValue;
	}	
	
	public E set(int index,	E obj) {
		Node temp = getNode(index);
		E oldValue = (E) temp.nodeValue;
		temp.nodeValue = obj;
		return oldValue;
	}
	
	private E remove(Node p) {
		p.preNode.nextNode = p.nextNode;
		p.nextNode.preNode = p.preNode;
		size--;
		modCount++;
		return (E) p.nodeValue;
	}
	
	public E remove(int index) {
		return remove(getNode(index));
	}

	private void addBefore(Node p,E obj) {
		Node temp = new Node(obj,p.preNode,p);
		p.preNode.nextNode = p;
		p.preNode = temp;
		size++;
		modCount++;
	}
	
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<E>{
		
		private Node current = headNode.nextNode;
		private int nowModCount = modCount;
		private boolean changeable = false;
		
		public boolean hasNext() {
			return current != tailNode;
		}
		
		public E next() {
			if(modCount != nowModCount) {
				throw new ConcurrentModificationException();
			}
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			changeable = true;
			E data = (E) current.nodeValue;
			current = current.nextNode;
			return data;
		}
		
		public void remove() {
			if(modCount != nowModCount) {
				throw new ConcurrentModificationException();
			}
			if(!changeable){
				throw new IllegalSelectorException();
			}
				
			MyLinkedList.this.remove(current.nextNode);
			nowModCount++;
			changeable = false;
			}
				
		}
}
