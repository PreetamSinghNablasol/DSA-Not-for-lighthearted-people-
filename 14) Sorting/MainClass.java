class MainClass
{
	public static void main(String ...args)
	{
		int[] arr = {5,4,3,6,3,2,2,4,5,6,3,7,8,4,0,12};
		BubbleSort bbl = new BubbleSort(arr);
		InsertionSort ins = new InsertionSort(arr);
		QuickSort qks = new QuickSort(arr);
		HeapSort hst = new HeapSort();
		MergeSort mrg = new MergeSort(arr);

		arr = mrg.sort();
		for(int i : arr){
			System.out.print(i+" ");
		}
	}
}