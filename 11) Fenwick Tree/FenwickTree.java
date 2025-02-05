// we cannot increase or decrease fenwick tree size after initialisation. 

import java.util.*;
import java.lang.*;

class FenwickTree
{
	public int[] fenwick;

	public FenwickTree(int[] arr)
	{
		fenwick = new int[arr.length +1];
		for(int i=0; i<arr.length; i++)
		{
			fenwick[i+1] = arr[i];
		}
		this.constrcutFenwickTree(arr);
	}

	private int lsb(int val)
	{
		return Integer.lowestOneBit(val); // alternatively (val & -val) will work
	}

	private void constrcutFenwickTree(int[] arr)
	{
		int temp;
		for(int i=1; i<arr.length-1; i++)
		{
			temp = i;
			while( temp+this.lsb(temp) < fenwick.length)
			{
				temp = temp+this.lsb(temp);
				fenwick[temp] = fenwick[temp]+arr[i-1];
			}
		}
	}

	public void printFenwickTree()
	{
		for(int i : this.fenwick)
		{
			System.out.println(i);
		}
	}
}