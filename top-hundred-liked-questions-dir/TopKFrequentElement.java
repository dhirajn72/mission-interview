class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[]{};

        Map<Integer,Integer> map=new HashMap<>();
        for(int e:nums){
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
            }
            else{
                map.put(e,1);
            }
        }
        int n=map.size();
        Heap heap=new Heap(n);
        for(int key:map.keySet()){
            Heap.Node node=heap.new Node(key,map.get(key));
            heap.insert(node);
        }
        int index=0;
        int[] result=new int[k];
        while(k-->0){
            Heap.Node node=heap.remove();
            result[index++]=node.data;
        }
        return result;
    }

    class Heap{

        Node[] arr;
        int max;
        int curr;
        Heap(int max){
            this.max=max;
            arr=new Node[max];
        }
        void insert(Node node){
            if(max==curr)
                return;
            arr[curr]=node;
            trickleUp(curr++);
        }
        void trickleUp(int index){
            int parent=(index-1)/2;
            Node bottom=arr[index];
            while(index>0 && arr[parent].count<bottom.count){
                arr[index]=arr[parent];
                index=parent;
                parent=(parent-1)/2;
            }
            arr[index]=bottom;
        }
        Node remove(){
            if(curr==0)
                return null;
            Node top=arr[0];
            arr[0]=arr[--curr];
            arr[curr]=null;
            trickleDown(0);
            return top;
        }
        void trickleDown(int index){
            Node top=arr[index];
            int largeChild=0;
            while(index<curr/2){
                int leftChild=2*index+1;
                int rightChild=2*index+2;
                if(rightChild<curr && arr[leftChild].count<arr[rightChild].count)
                    largeChild=rightChild;
                else
                    largeChild=leftChild;
                
                if(top.count>=arr[largeChild].count)break;
                arr[index]=arr[largeChild];
                index=largeChild;
            }
            arr[index]=top;
        }

        class Node{
            int data;
            int count;
            Node(int data,int count){
                this.data=data;
                this.count=count;
            }
        }
    }
}
