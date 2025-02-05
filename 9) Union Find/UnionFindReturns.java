class UnionFindReturns
{
    int[] root;
    int[] size;

    public UnionFindReturns(int size)
    {
        this.root=new int[size];
        this.size= new int[size];
        for(int i=0; i<size; i++)
        {
            this.root[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int setNumber)
    {
        int temp = setNumber;
        while(this.root[temp] != temp)
        {
            temp = this.root[temp];
        }
        int temp2;
        while(this.root[setNumber] != setNumber) // PATH COMPRESSION
        {
            temp2= setNumber;
            setNumber=this.root[setNumber];
            this.root[temp2]= temp;
        }
        return temp;
    }
    public void union(int setA, int setB)
    {
        if(this.find(setA) == this.find(setB))
        {
            System.out.println("Unable to join, sets are same group");
            return;
        }
        else if(this.size[setA] >= this.size[setB])
        {
            this.root[setB] = setA;
            return;
        }
        this.root[setA] = setB;
    }
}