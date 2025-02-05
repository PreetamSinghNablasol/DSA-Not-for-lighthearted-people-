class InOrderTraversal
{
	int[] arr;

	public InOrderTraversal(int[] arr)
	{
		this.arr = arr;
	}
	public void printInOrder()
	{
		this.printInOrder(0);
	}

	public void printInOrder(int index)
	{
		if(index > arr.length-1 || this.arr[index] == 0)
		{
			return;
		}
		printInOrder(index*2+1);
		System.out.println(arr[index] + " ");
		printInOrder(index*2+2);
	}
}