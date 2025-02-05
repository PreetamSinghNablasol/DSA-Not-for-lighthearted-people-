class BubbleSort
{
	int[] array;
	public BubbleSort(int[] arr)
	{
		this.array = arr;
	}

	public int[] sort()
	{
		int flag =0;
		while(flag != 1)
		{
			flag = 1;
			for(int j=0; j<array.length-1; j++)
			{
				if(array[j] > array[j+1])
				{
					array[j] = array[j]+array[j+1];
					array[j+1] = array[j]-array[j+1];
					array[j] = array[j]-array[j+1];
					flag = 0; // indicating changes were made to array :)
				}
			}
		}
		return array;
	}
}