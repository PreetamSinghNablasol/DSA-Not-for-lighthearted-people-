class MainClass
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{30,15,60,7,22,45,75,0,0,17,27,0,0,0,0};
		InOrderTraversal obj = new InOrderTraversal(arr);
		obj.printInOrder();
	}
}