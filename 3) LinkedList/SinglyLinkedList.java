
class SinglyLinkedList<T> 
{
	private T data = null;
	private SinglyLinkedList next = null;

// Constructors 
	public SinglyLinkedList()
	{
	}
	public SinglyLinkedList(T data)
	{
		this.data = data;
		this.next = null;
	}
	public SinglyLinkedList(T data, SinglyLinkedList next)
	{
		this.data = data;
		this.next = next;
	}

// Methods
	public void append(T data)
	{
		this.endNode().next = new SinglyLinkedList(data,null);
	}
	public void remove(int pos)
	{
		SinglyLinkedList pointer= this;
		if(pos > this.maxIndex())
		{
			return;
		}
		if(this.getNext() == null && pos==0)
		{
			this = null;
			return;
		}
		for(int i=0; i<pos-1; i++)
		{
			pointer = pointer.next();
		}
		pointer.next = pointer.getNext().getNext();
	}


// Helper Methods
	private SinglyLinkedList getNext()
	{
		return this.next;
	}

	private SinglyLinkedList endNode()
	{
		SinglyLinkedList pointer = this;
		while(pointer.getNext() != null)
		{
			pointer = pointer.getNext();
		}
		return pointer;
	}
	private int maxIndex()
	{
		SinglyLinkedList pointer = this;
		int count =0;
		while(pointer.getNext() != null)
		{
			pointer = pointer.getNext();
			count ++;
		}
		return count
	}

}