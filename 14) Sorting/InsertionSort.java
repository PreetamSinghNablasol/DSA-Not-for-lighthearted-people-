class InsertionSort
{
	int[] array;
	public InsertionSort(int[] arr)
	{
		this.array = arr;
	}

	public int[] sort()
	{
		int current =0;
		for(int i=0; i<this.array.length; i++)
		{
			current =i;
			while(current >=0 && current+1 < this.array.length && this.array[current] > this.array[current+1])
			{
				array[current] = array[current]+array[current+1];
				array[current+1] = array[current]-array[current+1];
				array[current] = array[current]-array[current+1];
				current--;
			}
		}
		return array;
	}
}