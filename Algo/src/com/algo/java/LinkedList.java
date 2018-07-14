package com.algo.java;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
	
	private Node first;
	private int N;
	
	private class Node
	{
		T item;
		Node next;
	}
	public boolean isEmpty()
	{
		return N == 0;
	}
	public int getSize()
	{
		return N;
	}
	public void push(T t)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = t;
		first.next = oldfirst;
		N++;
	}

	public T pop()
	{
		T temp = first.item;
		first = first.next;
		N--;
		return temp;
	}
	public void insertAtPosition(int position, T data)
	{
		if(position < 1)
		{
			throw new NullPointerException("Index starts at one");
		}
		else if(position == 1)
		{
			push(data);
			N++;
		}
		else if(position-1 > N)
		{
			throw new NullPointerException("Length of LinkedList is " + N);
		}
		else
		{
			int count = 1;
			Node node = first;
			while(count < position-1)
			{
				node = node.next;
				count++;
			}
			Node newNode = new Node();
			newNode.item = data;
			newNode.next = node.next;
			node.next = newNode;
			N++;
		}
		
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements java.util.Iterator<T>
	{
		
		private Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T item = current.item;
			current = current.next;
			return item;
		}
		
	}
}
