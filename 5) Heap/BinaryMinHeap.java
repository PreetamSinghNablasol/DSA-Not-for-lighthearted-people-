// Min Binary heap using array
// A binary heap is automatically balanced

public class BinaryHeap
{
	int[] heap;
	int endIndex=-1;
	int size = 15;

// Constructors :
	public BinaryHeap()
	{
		heap = new int[this.size];
	}
	public BinaryHeap(int rows)
	{
		this.size = this.rToS(rows);
		heap = new int[this.size]
	}

// Essential Methods :
	public boolean add(int element)
	{
		if(this.isFull() == true)
		{
			return false;
		}
		endIndex++;
		this.heap[endIndex] = element; 
		this.bubbleUp(endIndex);
		return true;
	}
	public boolean poll()
	{
		if(this.isEmpty() == false)
		{
			return false;
		}
		if(this.getEndIndex() == 0)
		{
			this.heap[0] = null;
			return true;
		}
		this.heap[0] = this.heap[this.endIndex];
		this.heap[this.endIndex] = null;
		this.bubbleDown(0);
		this.endIndex --;
		return true;
	}
	public boolean remove(int index)
	{
		if(((index-1)/2 >= 0 && index%2 == 1 && this.heap[index] < this.heap[(index-1)/2]) || ( (index-2)/2 >= 0) && index%2 == 0 && this.heap[index] < this.heap[(index-2)/2])
		{
			this.bubbleUp(index);
			this.endIndex --;
			return true;
		}
		else if(this.heap[index*2+1]<=this.endIndex && this.heap[index]>this.heap[index*2+1] || this.heap[index*2+1] >= this.heap[index*2+2])
		{
			this.bubbleDown(index);
			this.endIndex --;
			return true;
		}
		return false;

	}
	public int getEndIndex()
	{
		return this.endIndex;
	}

// Essential Methods :
	public boolean isEmpty()
	{
		if(this.endIndex == -1)
		{
			return true;
		}
		return false;
	}
	public boolean isFull()
	{
		if(this.endIndex == this.size-1)
		{
			return true;
		}
		return false;
	}
	private boolean bubbleDown(int index)
	{
		int temp =0;
		if(this.heap[index*2+1]>this.endIndex )
		{
			return false;
		}
		while(true)
		{
			if(this.heap[index*2+1]>this.endIndex )
			{
				break;
			}
			if(this.heap[index]<=this.heap[index*2+1] && this.heap[index]<=this.heap[index*2+2])
			{
				break;
			}
			if(this.heap[index]>this.heap[index*2+1] && this.heap[index*2+1] >= this.heap[index*2+2])
			{
				temp = this.heap[index];
				this.heap[index] = this.heap[index*2+1];
				this.heap[index*2+1] = temp;
				index = index*2+1;
				continue;
			}
			else 
			{
				temp = this.heap[index];
				this.heap[index] = this.heap[index*2+2];
				this.heap[index*2+2] = temp;
				index = index*2+2;
				continue;
			}
		}
		return true;
	}

	private boolean bubbleUp(int index)
	{
		int temp = 0;
		if(index%2 == 1 && (index-1)/2 < 0)
		{
			return false;
		}
		if(index%2 == 0 && (index-2)/2 < 0)
		{
			return false;
		}

		while(true)
		{
				if(index%2 == 1 && (index-1)/2 < 0)
				{
					break;
				}
				if(index%2 == 0 && (index-2)/2 < 0)
				{
					break;
				}
				if(index%2 == 1 && this.heap[index] < this.heap[(index-1)/2])
				{
					temp = this.heap[index];
					this.heap[index] = this.heap[(index-1)/2];
					this.heap[(index-1)/2] = temp;
					index = (index-1)/2;
					continue;
				}
				else if(index%2 == 0 && this.heap[index] < this.heap[(index-2)/2])
				{
					temp = this.heap[index];
					this.heap[index] = this.heap[(index-2)/2];
					this.heap[(index-2)/2] = temp;
					index = (index-2)/2;
					continue;
				}
				else
				{
					break;
				}
		}
		return true;
	}
	public int rToS(int rows)
	{
		int temp =0;
		for(int i=1; i<=rows; i++)
		{
			temp = temp+i;
		}
		return temp;
	}
}