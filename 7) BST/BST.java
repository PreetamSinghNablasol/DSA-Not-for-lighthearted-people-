class BST
{
	LinkedList root = null;

// Constructors :
	public BST(int value)
	{
		root = new LinkedList(value);
	}

// Methods :
	public void add(int data)
	{
		LinkedList temp = root;
		LinkedList temp2 = null;
		while(true)
		{
			if(data < temp.data)
			{
				if(temp.left == null)
				{
					temp.left = new LinkedList(data);
					break;
				}
				else if(data > temp.left.data && temp.left.right == null)
				{
					temp.left.right = new LinkedList(data);
					break;
				}
				else if(data < temp.left.data && temp.left.left == null)
				{
					temp.left.left = new LinkedList(data);
					break;
				}
				else if(temp.left.data == data)
				{
					temp.left.count++;
					break;
				}
				else
				{
					temp = temp.left;
					continue;
				}
			}
			else if(data > temp.data)
			{
				if(temp.right == null)
				{
					temp.right = new LinkedList(data);
				}
				if(data > temp.right.data && temp.right.right == null)
				{
					temp.right.right = new LinkedList(data);
					break;
				}
				else if(data < temp.right.data && temp.right.left == null)
				{
					temp.right.left = new LinkedList(data);
					break;
				}
				else if(temp.right.data == data)
				{
					temp.right.count++;
					break;
				}
				else
				{
					temp = temp.right;
					continue;
				}
			}
		}
		

	}
}