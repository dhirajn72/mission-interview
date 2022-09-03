class HeapSort_2{
    Node[] arr;
    int curr;
    int max;
    HeapSort_2(int size){
        arr=new Node[size];
        max=size;
    }

    void insert(int data){
        if(curr==max) {
            System.out.println("Heap is alreay full");
            return ;
        }
        Node node=new Node(data);
        arr[curr]=node;
        trickleUp(curr++);


    }
    void trickleUp(int index){
        int parent=(index-1)/2;
        Node bottom=arr[index];
        while(index>0 && arr[parent].data<bottom.data){
            arr[index]=arr[parent];
            index=parent;
            parent=(parent-1)/2;
        }
        arr[index]=bottom;
    }

    int remove(){
        if(curr==0){
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        Node top=arr[0];
        arr[0]=arr[--curr];
        arr[curr]=null;
        trickeDown(0);
        return top.data;
    }

    void trickeDown(int index){
        int largeChild=0;
        Node top=arr[index];
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
    public static void main(String[] arge){
        int[] arr={8,2,1,4,9,5,3};
        HeapSort_2 heap=new HeapSort_2(arr.length);
        for(int i:arr)
            heap.insert(i);

        while(heap.curr!=0){
            System.out.println(heap.remove()+",");
        }

    }
    class Node{
        int data;
        Node(int data){
            this.data=data;
        }
    }
}
