class InOrderLinkedList
{

	LinkedList root = null;

	public void inOrder(LinkedList node)
	{
		if(node == null)
		{
			return ;
		}
		inOrder(root.left);
		System.out.println(root.data + " ");
		inOrder(root.right);
	}
}