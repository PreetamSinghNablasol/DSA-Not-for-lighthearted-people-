// Queue implementation using LinkedList
public class QueueArray<T>
{
	T[] queue;
	int tail=0;

// Constructors :

	public QueueArray()
	{
		queue = (T[])new Object[tail+1];
	}
	public QueueArray(int size)// this constructor takes in maximum size of array that will be needed
	{
		queue = (T[])new Object[size];
	}

// Methods : 

	public int getSize()
	{
		return this.tail+1;
	}

	public void enqueue(T element)
	{
		if(this.isFull() == true)
		{
			return;
		}
		T[] temp = queue;
		temp[0] = element;
		for(int i=0; i<=this.tail; i++)
		{
			temp[i+1] = queue[i];
		}
		queue = temp;
		temp = null;
		this.tail++;
	}

	public boolean dequeue()
	{
		if(this.isEmpty() == true)
		{
			return false;
		}
		this.queue[tail] = null;
		this.tail--;
		return true;
	}

// Helper Methods :

	public boolean isEmpty()
	{
		if(this.tail ==0)
		{
			return true;
		}
		return false;
	}
	private boolean isFull()
	{
		if(this.tail == this.queue.length-1)
		{
			return true;
		}
		return false;               
	}
}
