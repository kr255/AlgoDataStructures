package com.algo.java;

import java.lang.reflect.Array;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Queue<T> implements Iterable<T>{

	/*
	 * array implementation of a queue
	 *  N to keep track of the size
	 *  head and tail for the first and last element
	 */
	private T entries[];
	private int N = 0;
	private int head = 0;
	private int tail = 0;
 
	/*
	 * constructor creates a generic type of list 
	 */
	public Queue(int cap) {
		entries = (T[]) new Object[cap];
	}
	public boolean isEmpty()
	{
		return N == 0;
	}
	public boolean isFull()
	{
		return N == entries.length;
	}
	public void enqueue(T t) 
	{
		/*
		 * if array isnt full and tail is not at the end of the array
		 * then add the entry to that index
		 * else set tail to the front.
		 * 
		 * if array is full then throw an overflow error
		 */
		if(!isFull())
		{
			if(tail == entries.length)
			{
				tail = 0;
			}
			entries[tail++] = t;
			N++;
		}
		else
			throw new ArrayIndexOutOfBoundsException("STACK OVERFLOW: Length is " + Size());
	}
	
	public T dequeue()
	{
		T temp;
		if(!isEmpty())
		{
			if(head == entries.length)
			{
				head = 0;
			}
			temp = entries[head];
			entries[head] = null;
			head++;
			N--;
			return temp;
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("STACK UNDERFLOW: Length is " + Size());
		}
		
	}

	public int Size()
	{
		return N;
	}
	private T dequeue2()
	{
		T temp2;
		if(!isEmpty())
		{
			if(head == entries.length)
			{
				head = 0;
			}
			temp2 = entries[head];
			head++;
			return temp2;
		}
	else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	
	}
	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}
	private class QueueIterator implements java.util.Iterator<T>
	{	
		private int i = N;	

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
//			T temp = entries[head];
			i--;
			return dequeue2();
		}
		
	}
	
}
