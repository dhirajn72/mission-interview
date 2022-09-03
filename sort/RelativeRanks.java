class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] arr=new int[score.length];
        Heap heap=new Heap(score.length);
        for(int e:score){
            heap.insert(e);
        }
        int i=1;
        Map<Integer,String> map=new HashMap<>();
        while(!heap.isEmpty()){
            int val=heap.remove();
            if(i==1){
                map.put(val,"Gold Medal");
            }
            else if(i==2){
                map.put(val,"Silver Medal");
            }
            else if(i==3){
                map.put(val,"Bronze Medal");
            }
            else 
                map.put(val,String.valueOf(i));
            i++;
        }
        String[] result=new String[score.length];
        for(i=0;i<score.length;i++){
            result[i]=map.get(score[i]);
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
        boolean isEmpty(){
            return curr==0;
        }
        void insert(int val){
            if(curr==max){
                return;
            }
            Node node=new Node(val);
            arr[curr]=node;
            trickleUp(curr++);
        }
        void trickleUp(int index){
            int parent=(index-1)/2;
            Node bottom=arr[index];
            while(index>0 && arr[parent].val<bottom.val){
                arr[index]=arr[parent];
                index=parent;
                parent=(parent-1)/2;
            }
            arr[index]=bottom;
        }
        void trickleDown(int index){
            int largeIndex=0;
            Node top=arr[index];
            while(index<curr/2){
                int leftIndex=2*index+1;
                int rightIndex=2*index+2;
                if(rightIndex<curr && arr[leftIndex].val < arr[rightIndex].val){
                    largeIndex=rightIndex;
                }
                else{
                    largeIndex=leftIndex;
                }
                if(top.val>=arr[largeIndex].val)break;
                arr[index]=arr[largeIndex];
                index=largeIndex;
            }
            arr[index]=top;
        }
        int remove(){
            if(isEmpty()){
                return -1;
            }
            Node top=arr[0];
            arr[0]=arr[--curr];
            arr[curr]=null;
            trickleDown(0);
            return top.val;
        }
        class Node{
            int val;
            Node(int val){
                this.val=val;
            }
        }
    }
}
