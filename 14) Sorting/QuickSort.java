class QuickSort
{
	int[] array;
	public QuickSort(int[] arr){
		this.array = arr;
	}
	public int[] sort(){
		this.sort(0, array.length-1);
		return this.array;
	}
	public void sort(int left, int right){
		int l=left;
		int r= right;
		int pivot=left;
		while(left != right)
		{
			System.out.println("dbg :"+left +" "+ right);
			if(array[left] > array[right])
			{
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				if(pivot == left){
					pivot = right;
				}
				else{
					pivot = left;
				}
				continue;
			}
			else{
				if(pivot == left){
					right--;
				}
				else{
					left++;
				}
			}
		}
		this.printIt();
		if(pivot != l ){
			this.sort(l, pivot-1);		
		}
		this.printIt();
		if(pivot != r ){
			this.sort(pivot+1, r);
		}

	}
	void printIt()
	{
		System.out.print("dbg :");
		for(int i: this.array)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
}