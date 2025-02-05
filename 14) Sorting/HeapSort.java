class HeapSort{
	int arr[];
	int[] heap;
	int current;
	public HeapSort(){
	
	}
	public int[] sort(int[] arr){
		this.arr = arr;
		this.heap = new int[this.arr.length];
		this.current = 0;
		for(int i=0; i<arr.length; i++){
			this.add(arr[i]);
		}
		this.current--;
		for(int i : this.heap)
		{
			System.out.print(i + "");
		}
		System.out.println();
		for(int i=0; i<arr.length; i++){
			this.arr[i] = this.pop();
			System.out.println(this.arr[i]);
		}
		return arr;
	}
	public void add(int element){
		if(current == 0){
			heap[0] = element;
			current++;
			return;
		}
		int curr = this.current;
		while(curr >0 && current < this.heap.length){
			this.heap[current] = element;
			if(curr%2 == 1 && heap[(curr-1)/2] > heap[curr]){
				int temp = this.heap[curr];
				this.heap[curr] = this.heap[(curr-1)/2];
				this.heap[(curr-1)/2] = temp;
				curr = (curr-1)/2;
				continue;
			}
			if(curr%2 == 0 && heap[(curr-2)/2] > heap[curr]){
				int temp = this.heap[curr];
				this.heap[curr] = this.heap[(curr-2)/2];
				this.heap[(curr-2)/2] = temp;
				curr = (curr-2)/2;
				continue;
			}
			break;
		}
		current++;
	}
	public int pop(){
		int ret = this.heap[0];
		int curr = 0;
		this.heap[0] = this.heap[current];
		current--;


		while(curr*2+1 <= current)
		{
			if(heap[curr*2+1] < heap[curr]){
				int temp =  heap[curr];
				heap[curr] = heap[curr*2+1];
				heap[curr*2+1] = temp;
				curr = curr*2+1;
				continue;
			}
			if(heap[curr*2+2] < heap[curr]){
				int temp =  heap[curr];
				heap[curr] = heap[curr*2+2];
				heap[curr*2+2] = temp;
				curr = curr*2+2;
				continue;
			}
			break;
		}
		return ret;

	}
		

}