package com.algo.java;

import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Stack<T> implements Iterable<T>
{
	
	//generic array
	private T[] entries;
	//index, keeps track of the next location
	private int N = 0;
	
	//constructs an object of Stack
	public Stack(int cap) {
//		entries = (T[]) Array.newInstance(t, cap);
		this.entries = (T[]) new Object[cap];


	}
	public T peek()
	{
		T temp = entries[--N];
		
		return temp;
	}
	
	/*
	 * returns true if empty arr
	 * if N is zero 
	 */
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	/*
	 * pushes an object on the stack
	 * then increments N for the next push
	 */
	public void push(T t)
	{
		/*
		 * if the index is of the arra length
		 * then resize the array to twice its size
		 * then add the items
		 */
		if(N == entries.length)
		{
			resize(2 * entries.length);
		}
		entries[N++] = t;
	}
	
	/*
	 * pops the element on the top 
	 * first decrements N because N is one ahead of index
	 * then returns the object at that index
	 */
	public T pop()
	{
		/*
		 * NOTE TO SELF
		 * the --N decrements N first
		 * so no need for "entries[--N] = null" like before
		 */
		T temp = entries[--N];
		entries[N] = null;
		/*
		 * if N is 1/4th the size then resize the arr
		 * makes it smaller
		 */
		if(N > 0 && N == entries.length/4)
		{
			resize(entries.length / 2);
		}
		return temp;
	}
	
	/*
	 * returns the size of the Stack
	 */
	public int Size()
	{
		return N;
	}
	
	/*
	 * basic print method 
	 * VERY BAD WAY TO PRINT!!
	 * REPLACE WITH ITERATOR
	 */
	public void print() 
	{
		for(int i = 0; i<entries.length; i++)
		{			
			System.out.println(entries[i]);
		}
	}
	
	/*
	 * does a basic trinity shuffle 
	 * to resize the array
	 */
	public void resize(int max)
	{
		T[] temp = (T[])new Object[max];
		for(int i = 0; i<N; i++)
		{
			temp[i] = entries[i];
			entries = temp;
		}
	}
	
	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ReversedArrayIterator();
	}
	private class ReversedArrayIterator implements java.util.Iterator<T>
	{
		private int i = N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}
	
		@Override
		public T next() throws NoSuchElementException{
			// TODO Auto-generated method stub
			return entries[--i];
		}
	}	
}
