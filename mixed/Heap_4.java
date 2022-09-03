public class Heap_4{
    Node[] arr;
    int max, curr;
    boolean isMin;
    Heap_4(int max, boolean isMin){
        this.max = max;
        this.arr = new Node[max];
        this.isMin = isMin;
    }
    void insert(int val){
        if(curr == max){
            System.out.println("Heap is full");
        }
        Node node = new Node(val);
        arr[curr] = node;
        trickleUp(curr++);
    }
    void trickleUp(int index){
        int parent = (index - 1) / 2;
        Node bottom = arr[index];
        while(index > 0 && (isMin ?  arr[parent].val > bottom.val : arr[parent].val < bottom.val)){
            arr[index] = arr[parent];
            index = parent;
            parent = (parent - 1)/2;
        }
        arr[index] = bottom; 
    }
    int remove(){
        if(curr == 0){
            System.out.println("Heap is empty");
        }
        Node top = arr[0];
        arr[0] = arr[--curr];
        arr[curr] = null;
        trickleDown(0);
        return top.val;
    }
    void trickleDown(int index){
        int largeIndex = 0;
        Node top = arr[index];
        while(index < curr / 2){
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            if(rightIndex < curr && ( isMin ?  arr[leftIndex].val > arr[rightIndex].val : arr[leftIndex].val < arr[rightIndex].val))
                largeIndex = rightIndex;
            else
                largeIndex = leftIndex;
            if(isMin)
                if(top.val <= arr[largeIndex].val) break;
            if(!isMin)
                if(top.val >= arr[largeIndex].val) break;
            arr[index] = arr[largeIndex];
            index = largeIndex;
        }
        arr[index] = top;
    }
    class Node{
        int val;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        int[] arr = {9,8,2,3,4,6,1,8,3};
        boolean isMin = Boolean.valueOf(args[0]);
        System.out.println("Performing "+ (isMin ? "MIN Heap :" : "MAX Heap :"));
        Heap_4 heap = new Heap_4(arr.length, isMin);
        for(int e : arr){
            heap.insert(e);
        }
        while(heap.curr != 0){
            System.out.println(heap.remove());
        }
    }
}
