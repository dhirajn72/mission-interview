class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[]{};
        Map<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }
            else{
                map.put(val,1);
            }
        }
        Heap heap=new Heap(map.size());
        for(int key:map.keySet()){
            heap.insert(key,map.get(key));
        }
        List<Integer> list=new ArrayList<>();
        while(k-->0){
            Heap.Node node =heap.remove();
            if(node!=null)
                list.add(node.val);
        }
        int[] result=new int[list.size()];
        int index=0;
        for(int val:list){
            result[index++]=val;
        }
        return result;
    }
    class Heap{
        Node[] arr;
        int max;
        int curr;
        Heap(int max){
            this.max=max;
            this.arr=new Node[max];
        }
        void insert(int val,int count){
            if(curr==max){
                return ;
            }
            Node node=new Node(val,count);
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
            int largeIndex=0;
            Node top=arr[index];
            while(index<curr/2){
                int leftIndex=2*index+1;
                int rightIndex=2*index+2;
                if(rightIndex<curr && arr[leftIndex].count<arr[rightIndex].count)
                    largeIndex=rightIndex;
                else
                    largeIndex=leftIndex;
                if(top.count>=arr[largeIndex].count)break;
                arr[index]=arr[largeIndex];
                index=largeIndex;
            }
            arr[index]=top;
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
