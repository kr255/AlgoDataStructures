package com.algo.java;

import java.util.Iterator;

public class Bag <T> implements Iterable<T>{
	
	private Node first;
	private int N;
	
	private class Node
	{
		T item;
		Node next;
	}
	/*
	 * bag as a stack implementation
	 */
	public void add(T t)
	{
		Node old = first;
		first = new Node();
		first.item = t;
		first.next = old;
		N++;
	}
	public int Size()
	{
		return N;
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	private class Next implements Iterator<T>
	{
		//instead of int i = N
		private Node current = first; 
		
		// so instead of an int (since there is no array to keep count of)
		//use the node's next link to see if it null or no
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
