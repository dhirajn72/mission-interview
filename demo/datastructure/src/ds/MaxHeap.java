package ds;

public class MaxHeap {
	Node[] arr;
	int curr,max;

	MaxHeap(int max){
		this.max=max;
		this.arr=new Node[max];
	}
	boolean isFull(){
		return curr==max;
	}
	void insert(int val){
		if(isFull()){
			System.out.println("Heap is full");
		}
		Node node =new Node(val);
		arr[curr]=node;
		trickleUp(curr++);
	}
	void trickleUp(int index){
		int parent=(index-1)/2;
		Node bottom=arr[index];
		while(index>0 && arr[parent].val>bottom.val){
			arr[index]=arr[parent];
			index=parent;
			parent=(parent-1)/2;
		}
		arr[index]=bottom;
	}
	int remove(){
		if(isEmpty()){
			System.out.println("Heap is empty");
		}
		Node top=arr[0];
		arr[0]=arr[--curr];
		arr[curr]=null;
		trickleDown(0);
		return top.val;
	}
	void trickleDown(int index){
		int largeIndex=0;
		Node top=arr[index];
		while (index<curr/2){
			int leftIndex=2*index+1;
			int rightIndex=2*index+2;
			if(rightIndex<curr && arr[leftIndex].val>arr[rightIndex].val)
				largeIndex=rightIndex;
			else
				largeIndex=leftIndex;
			if(top.val<=arr[largeIndex].val) break;
			arr[index]=arr[largeIndex];
			index=largeIndex;
		}
		arr[index]=top;
	}
	boolean isEmpty(){
		return curr==0;
	}

	public static void main(String[] args) {
		int[] arr={7,6,2,3,4,0,9,1,2};
		MaxHeap heap=new MaxHeap(arr.length);
		for(int e:arr){
			heap.insert(e);
		}
		while (!heap.isEmpty()){
			System.out.println(heap.remove());
		}
	}

}
