class Solution {
    public int thirdMax(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        List<Integer> list=new ArrayList<>();
        for(int e:nums){
            if(!list.contains(e))
                list.add(e);
        }
        if(list.size()==1){
            return list.get(0);
        }
        if(list.size()==2){
            return Math.max(list.get(0),list.get(1));
        }
        
        
        Heap heap=new Heap(list.size());
        for(int e:list){
            heap.insert(e);
        }
        int n=3;
        int result=0;
        while(n-->0){
            result=heap.remove();
        }
        return result;
    }

    class Heap{
        Node[] arr;
        int curr;
        int max;
        Heap(int max){
            this.max=max;
            this.arr=new Node[max];
        }
        public void insert(int data){
            if(curr==max){
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
            if(curr==0)
                return -1;
            Node node=arr[0];
            arr[0]=arr[--curr];
            arr[curr]=null;
            trickleDown(0);
            return node.data;
        }
        void trickleDown(int index){
            int largeChild=0;
            Node top=arr[index];
            while(index<curr/2){
                int leftChild=2*index+1;
                int rightChild=2*index+2;
                if(rightChild<curr && arr[leftChild].data < arr[rightChild].data){
                    largeChild=rightChild;
                }
                else{
                    largeChild=leftChild;
                }
                if(top.data > arr[largeChild].data)break;
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
}
