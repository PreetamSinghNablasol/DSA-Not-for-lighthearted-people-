public class StackArray <T>
{
	private T[] stack ;
	private int size = 0;

// constructors :
	public StackArray()
	{
		this.stack = (T[])new Object[this.size];
	}
	public StackArray(int size)
	{
		this.stack = (T[])new Object[size];
	}

// methods :
	public void pop()
	{
		if(this.stackUnderflowCheck() == false)
		{
			this.stack[size-1] = null;
			size--;
		}
		return;
	}
	public void push(T element)
	{
		if(this.stackOverflowCheck() == false)
		{
			this.stack[size] = element;
			size++;
		}
		return;
	}
	public T getTop()
	{
		if( size == 0)
		{
			System.err.println("EMPTY STACK");
			return null;
		}
		return this.stack[size-1];
	}
	public int getSize()
	{
		return this.size;
	}
// helper methods :
	private boolean stackOverflowCheck()
	{
		if(this.size == this.stack.length)
		{
			return true;
		}
		return false;
	}
	private boolean stackUnderflowCheck()
	{
		if(this.size == 0)
		{
			return true;
		}
		return false;
	}
}