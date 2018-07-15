package com.algo.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.Scanner;


public class RandomDoDelete {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		LinkedList<Integer> ii = new LinkedList<>();
//		DoublyLinkedList<Integer> dd = new DoublyLinkedList<>();
//		
		ii.push(11);
		ii.push(12);
		ii.push(13);
		ii.push(14);
		ii.insertAtPosition(2, 1212);
		System.out.println(ii.getSize());

//		dd.push(1);
//		dd.push(2);
//		dd.push(3);
//		dd.push(4);
////		System.out.println("popped item: " + dd.pop());
////		System.out.println("popped item: " + dd.pop());
////		System.out.println("dequeued item: " + ii.dequeue());

//		
//		
//		System.out.println("\n");
//		for(Integer i : dd)
//		{
//			System.out.print(i);
//		}
//		
		int array[] = {2,5,9,4,0};
		insertionSort(array);
		for(Integer i : array)
		{
			System.out.print(i + " ");
		}
	}
	public static void insertionSort(int arr[])
	{
		for(int i = 1; i<arr.length;i++)
		{
			for(int j = i; j > 0 && (arr[j] < arr[j-1]); j--)
			{
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
	}
	
	public static void bubblesort(int arr[])
	{
		for(int i = 0; i<arr.length; i++)
		{
			for(int j = 0; j<arr.length - 1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void SelectionSort(int arr[])
	{
		int N = arr.length;
		for(int i=0;i<N;i++)
		{
			int minimumIndex = i;
			for(int j= i+1; j<N;j++)
			{
				if(arr[j] < arr[minimumIndex])
				{
					minimumIndex = j;
				}
			}
			int temp = arr[minimumIndex];
			arr[minimumIndex] = arr[i];
			arr[i] = temp;
		}
	}



}
