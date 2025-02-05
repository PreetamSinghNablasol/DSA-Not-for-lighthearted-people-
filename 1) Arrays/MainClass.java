class MainClass
{
	public static void main(String [] args)
	{
		DynamicArray<Integer> arr = new DynamicArray<>();
		System.out.println(arr.getSize());
		arr.addAt(50,100);
		System.out.println(arr.getSize());
	}
}