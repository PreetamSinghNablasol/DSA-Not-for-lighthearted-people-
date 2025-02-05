class MergeSort{
	int array[];
	public MergeSort(int[] arr){
		this.array = arr;
	}
	public int[] sort(){
		this.recursiveDivide(this.array, 0, this.array.length-1);
		return this.array;
	}
	public void recursiveDivide(int[] arr,int left,int right){
		if(left == right) return;
		int mid = (left+right)/2;
		this.recursiveDivide(arr, left, mid);
		this.recursiveDivide(arr, mid+1, right);
		this.mergeSort(arr, left, mid, right);
	}
	public void mergeSort(int[] arr, int left, int  mid, int right){
		int[] leftArray = new int[mid-left+1];
		int[] rightArray = new int[right-mid];
		for(int i=left; i<=mid; i++){
			leftArray[i-left] = arr[i];
		}		
		for(int j=mid+1; j<=right ; j++){
			rightArray[j- (mid+1)] = arr[j];
		}
		int a=0,b=0;
		for(int i=left; i<=right; i++){
			if(a == leftArray.length){
				arr[i] = rightArray[b];
				b++;
				continue;
			}
			if(b == rightArray.length){
				arr[i] = leftArray[a];
				a++;
				continue;
			}
			if(leftArray[a] < rightArray[b]){
				arr[i] = leftArray[a];
				a++;
				continue;
			}
			arr[i] = rightArray[b];
			b++;
		}
	}
}
