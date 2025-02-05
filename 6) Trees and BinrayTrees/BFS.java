class BFS
{
	Queue queue;
	LinkedList root;

	public BFS(LinkedList root)
	{
		queue = new Queue();
		this.root = root;
	}

	public void bfsTraversal()
	{
		queue.enqueue(root);
		while(queue.isEmpty() != true)
		{
			if(queue.getTail().left != null)
			{
				queue.enqueue(queue.getTail().left);
			}
			if(queue.getTail().right != null)
			{
				queue.enqueue(queue.getTail().right);
			}
			System.out.println(queue.dequeue());
		}
	}
	
}