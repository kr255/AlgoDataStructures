package com.algo.java;

import java.util.Iterator;

public class DoublyLinkedList <T> implements Iterable<T>{

	private Node first;
	private int N;
	
	private class Node
	{
		T item;
		Node previous;
		Node next;
		
		public Node()
		{
			item = null;
			previous = null;
			next = null;
		}
	}
	
	public int Size()
	{
		return N;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void push(T t)
	{
		Node old = first;
		if(isEmpty())
		{
			first = new Node();
			//old.previous = first;
			first.item = t;
			first.previous = null;
			first.next = old;
			N++;
		}
		else
		{
			first = new Node();
			old.previous = first;
			first.item = t;
			first.previous = null;
			first.next = old;
			N++;
		}
		
	}
	public T pop()
	{
		T temp;
		temp = first.item;
		first = first.next;
		first.previous = null;
		N--;
		return temp;
	}
	
	public void print()
	{
		for(Node x = first; x!=null; x = x.next)
		{
			System.out.println(x.item);
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DLLIterator();
	}
	private class DLLIterator implements Iterator<T>
	{
		Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T temp;
			temp = current.item;
			current = current.next;
			//current.previous = null;
			return temp;
		}
		
	}
}
