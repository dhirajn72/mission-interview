class Solution {
    public int[] sortByBits(int[] arr) {
        Heap heap=new Heap(arr.length);
        for(int i=0;i<arr.length;i++){
            int ones=getOnes(arr[i]);
            Heap.Node node=heap.new Node(arr[i],ones);
            heap.insert(node);
        }
        int[] result=new int[arr.length];
        int index=0;
        Map<Integer,List<Integer>>  map=new TreeMap<>();
        while(!heap.isEmpty()){
            Heap.Node node=heap.remove();
            if(map.get(node.count)==null){
                List<Integer> list=new ArrayList<>();
                list.add(node.val);
                map.put(node.count,list);
            }
            else{
                List<Integer> list=map.get(node.count);
                list.add(node.val);
            }
        }
        for(int key:map.keySet()){
            List<Integer> values=map.get(key);
            Collections.sort(values);
            for(int val:values){
                result[index++]=val;
            }
        }
        return result;
    }
    int getOnes(int n){
        int ones=0;
        while(n!=0){
            ones+=n%2;
            n=n/2;
        }
        return ones;
    }

    class Heap{
        Node[] arr;
        int max;
        int curr;
        Heap(int max){
            this.max=max;
            this.curr=curr;
            this.arr=new Node[max];
        }
        void insert(Node node){
            if(curr==max){
                return;
            }
            arr[curr]=node;
            trickleUp(curr++);
        }
        void trickleUp(int index){
            int parent=(index-1)/2;
            Node bottom=arr[index];
            while(index>0 && arr[parent].count>bottom.count){
                arr[index]=arr[parent];
                index=parent;
                parent=(parent-1)/2;
            }
            arr[index]=bottom;
        }
        Node remove(){
            if(isEmpty()){
                return null;
            }
            Node top=arr[0];
            arr[0]=arr[--curr];
            arr[curr]=null;
            trickleDown(0);
            return top;
        }
        void trickleDown(int index){
            int largeIndex=0;
            Node top=arr[index];
            while(index<curr/2){
                int leftIndex=2*index+1;
                int rightIndex=2*index+2;
                if(rightIndex<curr && arr[leftIndex].count>arr[rightIndex].count){
                    largeIndex=rightIndex;
                }
                else{
                    largeIndex=leftIndex;
                }
                if(top.count<=arr[largeIndex].count)break;
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
            int count;
            Node(int val,int count){
                this.val=val;
                this.count=count;
            }
        }
    }
}


