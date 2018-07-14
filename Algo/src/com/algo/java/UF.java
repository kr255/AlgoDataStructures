package com.algo.java;

public class UF {

	
	private int dataStructure[];
	
	//sets up the datastructure array with 
	//each entry equal to its index, all in their conn component
	public UF(int N)
	{
		this.dataStructure = new int[N];
		for(int i=0; i < N; i++)
		{
			dataStructure[i] = i;
		}


	}
	
	public void union(int p, int q)
	{
		int pid = dataStructure[p];
		int qid = dataStructure[q];
		
		for (int i = 0; i < dataStructure.length; i++) 
		{
			if (dataStructure[i] == pid) 
			{
				dataStructure[i] = qid;
			}
		}
	}
	boolean connected(int p, int q)
	{
		return dataStructure[p] == dataStructure[q];
	}
	
	public void printDataStructure() {
		// TODO Auto-generated method stub
		for(int i: dataStructure)
			System.out.println(dataStructure[i]);
	}
}
