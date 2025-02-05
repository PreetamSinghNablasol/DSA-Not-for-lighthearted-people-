import java.util.*;
import java.lang.*;

class Rotation
{
	public int[][] solution(int[][] arr)
	{
		int rows = arr.length;
		int columns = arr[0].length;
		int temp = 0;
		for(int i=0; i<rows/2; i++)
		{
			for(int j=0; j<(columns/2)+1; j++)
			{
				temp= arr[i][j];
				arr[i][j] = arr[rows-j-1][i];
				arr[rows-j-1][i] = arr[rows-i-1][rows-j-1];
				arr[rows-i-1][rows-j-1] = arr[j][rows-i-1];
				arr[j][rows-i-1] = temp;
			}
		}
		return arr;
	}
}

/*

[00,01,02,03,04]
[10,11,12,13,14]
[20,21,22,23,24]  
[30,31,32,33,34]  
[40,41,42,43,44]



 */