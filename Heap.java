public class Heap {

    Node[] arr;
    int curr,max;
    Heap(int max){
        this.max=max;
        arr=new Node[max];
    }

    public static void main(String[] args) {
        int[] arr={4,1,3,8,6,7,5,2};
        Heap heap=new Heap(arr.length);
        for(int i:arr)
            heap.insert(i);
        while(heap.curr!=0){
            System.out.print(heap.remove()+",");
        }
        System.out.println();
    }
    void trickleDown(int index){
        int largeIndex=0;
        Node top=arr[index];
        while(index<curr/2){
            int leftChild=(2*index)+1;
            int rightChild=(2*index)+2;
            if(rightChild<curr && arr[leftChild].data>arr[rightChild].data)
                largeIndex=rightChild;
            else 
                largeIndex=leftChild;
            if(top.data<=arr[largeIndex].data)break;
            arr[index]=arr[largeIndex];
            index=largeIndex;
        }
        arr[index]=top;
    }
    void insert(int data){
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
        if(curr==0){
            return 0;
        }
        Node top=arr[0];
        arr[0]=arr[--curr];
        arr[curr]=null;
        trickleDown(0);
        return top.data;
    }
    class Node{
        int data;
        Node(int data){
            this.data=data;
        }
    }
}