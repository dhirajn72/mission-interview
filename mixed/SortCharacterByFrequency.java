class Solution {
    public String frequencySort(String s) {
        if(s==null||s.length()==0)
            return s;
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        Heap heap=new Heap(map.size());
        for(char c:map.keySet()){
            Heap.Node node=heap.new Node(c,map.get(c));
            heap.insert(node);
        }
        StringBuilder sb=new StringBuilder();
        while(!heap.isEmpty()){
            Heap.Node node=heap.remove();
            for(int i=0;i<node.occurence;i++)
                sb.append(node.val);
        }
        return sb.toString();
    }
    class Heap{
        Node[] arr;
        int max;
        int curr;
        Heap(int max){
            this.max=max;
            this.arr=new Node[max];
        }
        boolean isEmpty(){
            return curr==0;
        }
        void insert(Node node){
            if(curr==max)
                return;
            arr[curr]=node;
            trickleUp(curr++);
        }
        void trickleUp(int index){
            int parent=(index-1)/2;
            Node bottom=arr[index];
            while(index>0 && arr[parent].occurence<bottom.occurence){
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
                if(rightIndex<curr && arr[leftIndex].occurence<arr[rightIndex].occurence)
                    largeIndex=rightIndex;
                else
                    largeIndex=leftIndex;
                if(top.occurence>=arr[largeIndex].occurence) break;
                arr[index]=arr[largeIndex];
                index=largeIndex;
            }
            arr[index]=top;
        }
        class Node{
            char val;
            int occurence;
            Node(char val,int occurence){
                this.val=val;
                this.occurence=occurence;
            }
        }
    }
}
