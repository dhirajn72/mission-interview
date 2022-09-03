package ds;

public class Priority{
    Node[] arr;
    int curr,max;
    Priority(int max){
        this.max = max;
        this.arr = new Node[max];
    }
    void insert(int  val){
        if(curr == max){
            return;
        }
        Node node = new Node(val);
        arr[curr] = node;
        trickleUp(curr++);
    }
    void trickleUp(int index){
         int parent = (index - 1 )/ 2;
         Node bottom = arr[index];
         while( index > 0 && arr[parent].val > bottom.val){
             arr[index] = arr[ parent ];
             index = parent ;
             parent = (parent - 1 )/2;
         }
         arr[ index] = bottom;
    }
    int remove(){
        if(curr == 0)
            return -1;
        Node node = arr[0];
        arr[0] = arr[--curr];
        arr[curr] =  null;
        trickleDown(0);
        return node.val;
    }
    void trickleDown(int index){
        int largeIndex = 0;
        Node top = arr[index];
        while( index < curr/ 2){
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            if( rightIndex < curr &&  arr[leftIndex].val > arr[rightIndex].val)
                largeIndex = rightIndex;
            else
                largeIndex = leftIndex;
            if(top.val <= arr[largeIndex].val) break;
            arr[index] =  arr[largeIndex];
            index = largeIndex;
        }
        arr[ index ] = top;
    }

    public static void main(String[] args){
        int[] arr = {9,8,4,6,8,2,6,1,7,3};
        Priority heap = new Priority(arr.length);
        for(int val : arr){
            heap.insert(val);
        }
        while( heap.curr != 0){
            System.out.print(heap.remove() +"->");
        }
    }

    class Node{
        int val;
        Node(int val){
            this.val = val;
        }
    }
}
