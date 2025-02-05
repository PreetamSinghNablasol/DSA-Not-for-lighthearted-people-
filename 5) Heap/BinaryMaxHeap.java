class BinaryMaxHeap
{
    int[] heapArray = new int[128];
    int lastIndex = -1;

// Constructor
    public BinaryMaxHeap(int[] array)
    {
        this.constructHeap(array);
    }
// Methods
    public void constructHeap(int[] array)
    {
        for(int a : array)
        {
            this.add(a);
        }
    }
    public int poll()
    {
        if(this.lastIndex == -1)
        {
            return -101;
        }
        int poll = this.heapArray[0];
        this.heapArray[0] = this.heapArray[lastIndex];
        this.heapArray[lastIndex]=0;
        this.lastIndex--;
        this.bubbleDown(0);
        return poll;
    }
    public void add(int element)
    {
        this.lastIndex++;
        this.heapArray[this.lastIndex] = element;
        this.bubbleUp(this.lastIndex);
    }
    public void remove(int element)
    {
        int index=0;
        for(int a : this.heapArray)
        {
            if(a == element)
            {
                this.heapArray[index] = this.heapArray[this.lastIndex];
                this.heapArray[this.lastIndex] = 0;
                this.lastIndex--;
                this.bubbleDown(index);
                this.bubbleUp(index);
                return;
            }
            index++;
        }
    }
// Helper Methods
    public void bubbleUp(int index)
    {
        if(this.lastIndex <=0 || index > this.lastIndex)
        {
            return;
        }
        int temp=index;
        while(temp != 0)
        {
            if(index%2 == 1)
            {
                if(this.heapArray[temp]>this.heapArray[(temp-1)/2])
                {
                    this.heapArray[temp]=this.heapArray[temp]+this.heapArray[(temp-1)/2];         // this is just for swapping the value of variables without introducing a third variable.
                    this.heapArray[(temp-1)/2] = this.heapArray[temp]-this.heapArray[(temp-1)/2];
                    this.heapArray[temp] = this.heapArray[temp]-this.heapArray[(temp-1)/2];
                    temp = (temp-1)/2;
                    continue;
                }
            }
            else if(index%2 == 0)
            {
                if(this.heapArray[temp]>this.heapArray[(temp-2)/2])
                {
                    this.heapArray[temp]=this.heapArray[temp]+this.heapArray[(temp-2)/2];
                    this.heapArray[(temp-2)/2] = this.heapArray[temp]-this.heapArray[(temp-2)/2];
                    this.heapArray[temp] = this.heapArray[temp]-this.heapArray[(temp-2)/2];
                    temp = (temp-2)/2;
                    continue;
                }
            }
            break;
        }
    }
    public void bubbleDown(int index)
    {
        int temp = index;
        while(temp>-1 && temp<=this.lastIndex)
        {
            if(this.heapArray[(temp*2)+1]<=this.lastIndex && this.heapArray[temp] < this.heapArray[(temp*2)+1])
            {
                this.heapArray[(temp*2)+1]=this.heapArray[temp]+this.heapArray[(temp*2)+1];
                this.heapArray[temp]=this.heapArray[(temp*2)+1]-this.heapArray[temp];
                this.heapArray[(temp*2)+1]=this.heapArray[(temp*2)+1]-this.heapArray[temp];
                temp=(temp*2)+1;
                continue;
            }
            else if(this.heapArray[(temp*2)+2]<=this.lastIndex && this.heapArray[temp] < this.heapArray[(temp*2)+2])
            {
                this.heapArray[(temp*2)+2]=this.heapArray[temp]+this.heapArray[(temp*2)+2];
                this.heapArray[temp]=this.heapArray[(temp*2)+2]-this.heapArray[temp];
                this.heapArray[(temp*2)+2]=this.heapArray[(temp*2)+2]-this.heapArray[temp];
                temp=(temp*2)+2;
                continue;
            }
            break;
        }
    }
}