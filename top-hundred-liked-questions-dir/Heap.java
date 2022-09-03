public class Heap{
    Node[] arr;
    int max;
    int curr;
    Heap(int max){
        this.max=max;
        this.arr=new Node[max];
    }
    void insert(int val){
        if(max==curr){
            return;
        }
        Node node=new Node(val);
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
            return 0;
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
        while(index<curr/2){
            int leftIndex=2*index+1;
            int rightIndex=2*index+2;
            if(rightIndex<curr && arr[leftIndex].val>arr[rightIndex].val){
                largeIndex=rightIndex;
            }
            else{
                largeIndex=leftIndex;
            }
            if(top.val<=arr[largeIndex].val)break;
            arr[index]=arr[largeIndex];
            index=largeIndex;
        }
        arr[index]=top;
    }
    boolean isEmpty(){
        return curr==0;
    }
    class Node{
        int val;
        Node(int val){
            this.val=val;
        }
    }
    public static void main(String[] args) {
        int[] arr={4,1,3,8,6,0,0,6,0,9,0,7,5,2};
        Heap heap=new Heap(arr.length);
        for(int i:arr)
            heap.insert(i);
        while(heap.curr!=0){
            System.out.print(heap.remove()+",");
        }
        System.out.println();
    }
}
