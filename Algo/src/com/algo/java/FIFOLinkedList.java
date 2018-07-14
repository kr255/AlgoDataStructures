package com.algo.java;

import java.util.Iterator;

public class FIFOLinkedList <T> implements Iterable<T>{
	
	private Node first;
	private Node last;
	private int N;
	
	private class Node
	{
		T item;
		Node next;
		
		public Node()
		{
			item = null;
			next = null;
		}
	}
	public boolean isEmpty()
	{
		return first == null;
	}
	public void enqueue(T t)
	{
		Node old = last;
		last = new Node();
		last.item = t;
		last.next = null; 
		if(isEmpty())
		{
			first = last;
		}
		else
		{
			old.next = last;
		}
		N++;
	}
	
	public T dequeue()
	{
		T temp = first.item;
		first = first.next;
		if(isEmpty())
		{
			last = null;
		}
		N--;
		return temp;
	}
	public void removeFromEnd()
	{
		if(isEmpty())
		{
			return;
		}
		else if(N == 1) 
		{
			first = null;
			last = null;
		}
		else
		{
			Node nextNode = first;
			while(nextNode.next.next != null)
			{
				nextNode = nextNode.next;
			}
			nextNode.next = null;
			N--;
		}
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new IteratorObj();
	}
	private class IteratorObj implements Iterator<T>
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
			T temp = current.item;
			current = current.next;
			return temp;
		}
		
	}
}
