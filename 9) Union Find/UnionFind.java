@author PreetamSingh
// Union Find with path compression
class UnionFind
{
	int[] roots;
	int[] hashes; 
	int[] sizes;
	int size;
// for demo purposes lets assume that the disjoint set roots have integet id in range of 0 - (size-1)

// Constructors :
	public UnionFind(int size)
	{
		this.size = size;
		this.roots = new int[this.size];
		this.hashes = new int[this.size];
		for(int i=0; i<this.size; i++)
		{
			this.roots[i] = i;
			this.hashes[i] = i;
			this.size[i] = 1;
		}
	}

// Methods : 
	public int find(int i)
	{
		int temp = i;
		while(roots[i] != i)
		{
			i = roots[i];
		}
		while(temp != i)// for path compression
		{
			int temp2 = temp;
			temp = roots[temp];
			roots[temp2] = i;
		}
		return i;
	}
	public void union(int ds1, int ds2)
	{
		int parent1 = this.find(ds1);
		int parent2 = this.find(ds2);
		if(parent1 != parent2)
		{
			if(size[parent1] >= size[parent2])
			{
				roots[parent2] = parent1;
				size[parent1] = size[parent1] + size[parent2];
			}
			else
			{
				roots[parent1] = parent2;
				size[parent2] = size[parent2] + size[parent1];
			}
		}
	}
}