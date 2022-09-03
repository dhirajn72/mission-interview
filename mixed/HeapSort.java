public class HeapSort {

    public static void main(String[] args) {
        int[] arr={9,4,8,7,2,3,7,6,5,1};
        HeapSort heap=new HeapSort(arr.length);
        for(int i:arr)
            heap.insert(i);
        
        int v=0;
        while((v=heap.remove())!=Integer.MIN_VALUE)
            System.out.print(v+", ");
        
        System.out.println();
    }


    private Node[] arr;
    private int curr,max;

    HeapSort(int max){
        this.max=max;
        arr=new Node[max];
    }
    
    void insert(int data){
        if(curr==max)
        return;
        Node node=new Node(data);
        arr[curr]=node;
        trickleUp(curr++);
    }

    void trickleUp(int index){
        int parent=(index-1)/2;
        Node bottom=arr[index];
        while(index>0 && arr[parent].data>bottom.data){
            arr[index]=arr[parent];
            index=parent;
            parent=(parent-1)/2;
        }
        arr[index]=bottom;
    }

    int remove(){
        if(curr==0)
            return Integer.MIN_VALUE;
        Node top=arr[0];
        arr[0]=arr[--curr];
        arr[curr]=null;
        trickleDown(0);
        return top.data;
    }

    void trickleDown(int index){
        int largeChild=0;
        Node top=arr[index];
        while(index<curr/2){
            int leftChild=(2*index)+1;
            int rightChild=(2*index)+2;
            if(rightChild<curr && arr[leftChild].data>arr[rightChild].data)
                largeChild=rightChild;
            else
                largeChild=leftChild;
            if(top.data<=arr[largeChild].data)break;
            arr[index]=arr[largeChild];
            index=largeChild;
        }
        arr[index]=top;
    }
    class Node{
        int data;
        Node(int data){
            this.data=data;
        }
    }

}
