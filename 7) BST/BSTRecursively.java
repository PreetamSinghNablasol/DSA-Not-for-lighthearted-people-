class BSTRecursively
{
	LinkedList root;

	public BSTRecursively(int data)
	{
		this.root = new LinkedList(data);
	}

	public void add(int data)
	{
		this.add(data,this.root);
	}
	private void add(int data, LinkedList temp)
	{
		if(temp == null)
		{
			temp = new LinkedList(data);
			return;
		}
		else if(data > temp.data)
		{
			this.add(data, temp.left);
		}
		else if(temp.data > data)
		{
			this.add(data, temp.right);
		}
		else if(temp.data == data)
		{
			temp.count++;
			return;
		}
	}

	private void remove(int data, LinkedList temp) // this method is actually first finding if the element exists and if does, calls replace() to remove it.
	{
		if(temp == null)
		{
			System.out.println("NO Bueno");
		}
		else if(temp.data == data)
		{
			if(temp.count > 1)
			{
				temp.count--;
				return;
			}
			this.replace(temp);
			return;
		}
		else if(data > temp.data)
		{
			this.remove(temp.left);
		}
		else if(temp.data > data)
		{
			this.remove(temp.right);
		}
	}
	private void replace(int temp) // this method removes an element from the BST using the approach that is used to remove elements in a BST.
	{
		if(temp.left == null && temp.right == null)
		{
			temp = null;
			return;
		}
		else if(temp.left == null)
		{
			temp = temp.right;
			this.replace(temp.right);
			return;
		}
		else if(temp.right == null)
		{
			temp = temp.left;
			this.replace(temp.left);
			return;
		}
		else
		{
			LinkedList temp2 = temp.right;
			while(temp2.left != null)
			{
				temp2 = temp2.left;
			}
			temp = temp2;
			temp2 = null; 
			return;
		}
	}
}