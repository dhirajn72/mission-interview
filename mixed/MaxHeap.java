class MaxHeap{
   private Node[] arr;
   private int max;
   private int curr;

   public MaxHeap(int size){
       arr=new Node[size];
       max=size;
   }
   void insert(int data){
       if(max==curr){
           System.out.println("Heap is full");
       }
       Node node =new Node(data);
       arr[curr]=node;
       trickleUp(curr++);
   }
   void trickleUp(int index){
       int parent=(index-1)/2;
       Node bottom=arr[index];
       while(index>0 && arr[parent].data < bottom.data){
           arr[index]=arr[parent];
           index=parent;
           parent=(parent-1)/2;
       }
       arr[index]=bottom;
   }

   int remove(){
       if(curr==0){
           System.out.println("Heap is empty");
       }
       Node top=arr[0];
       arr[0]=arr[--curr];
       arr[curr]=null;
       trickleDown(0);
       return top.data;

   }

   void trickleDown(int index){
       Node top=arr[index];
       int largeChild=0;
       while(index<curr/2){
           int leftChild=(2*index)+1;
           int rightChild=(2*index)+2;
           if(rightChild<curr && arr[leftChild].data<arr[rightChild].data)
               largeChild=rightChild;
           else
               largeChild=leftChild;

           if(top.data>=arr[largeChild].data)break;
           arr[index]=arr[largeChild];
            index=largeChild;
       }
       arr[index]=top;
   }
   public static void main(String[] args) {

       int[] arr={9,4,8,7,2,3,7,6,5,1};
       MaxHeap heap=new MaxHeap(arr.length);
       for(int i:arr){
           heap.insert(i);
       }
        while(heap.curr!=0){
            System.out.print(heap.remove()+" ,");
        }
        System.out.println();
   }
   class Node{
       int data;

       Node(int data){
           this.data=data;
       }
   }


}
