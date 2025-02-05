@SuppressWarnings("unchecked")
public class DynamicArray <T>
{
	private T[] arr;
	private int size;// the actual size of array
	private int count = 0;// the max index that stores a value inputed by user/ what user thinks is the size


// constructors used
	public DynamicArray()
	{
		arr = (T[])(new Object[2]);
		// this(2); can be written alternatively
		this.size = 2;
	}
	public DynamicArray(int capacity)// we take the initial capacity of array.
	{
		arr = (T[])(new Object[capacity]);
		this.size = capacity;
	}


// public methods
	public int getSize()
	{
		return this.size;
	}

	public void addAt(int pos, T value)
	{
		if(pos >= size-1)
		{
			this.doubleSize(pos);
			this.count = pos;
		}
		this.arr[pos] = value;
	}

	public T valueAt(int pos)
	{
		if(pos > size-1)
		{
			System.out.println("INDEX OUT OF BOUNDS");
			return null;
		}
		return this.arr[pos];
	}


// private methods
	private void doubleSize(int pos)// method that sizes the array based on the pos value
	{
		while(pos >= size-1)
		{
			size = size*2;
		}
		T[] temp = this.arr;
		this.arr = (T[])(new Object[size]);
		for(int i=0; i<=count; i++)
		{
			this.arr[i] = temp[i];
		}
		temp = null;
	}

}