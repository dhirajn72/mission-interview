class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result=new ArrayList<>();
        if(words==null||words.length==0)
            return result;
        Heap heap=new Heap(words.length);
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }
            else{
                map.put(word,1);
            }
        }
        for(String word:map.keySet()){
            heap.insert(word,map.get(word));
        }
        
        List<String> list=new ArrayList<>();
        while(k-->0){
            Heap.Node node=heap.remove();
            list.add(node.data);
        }
        return list;
    }
    class Heap{
        Node[] arr;
        int curr,max;
        Heap(int size){
            arr=new Node[size];
            this.max=size;
            curr=0;
        }
        void insert(String data,int count){
            Node node=new Node(data,count);
            arr[curr]=node;
            trickleUp(curr++);
        }
        void trickleUp(int index){
            int parent=(index-1)/2;
            Node bottom=arr[index];
            while(index>0 && arr[parent].count < bottom.count){
                arr[index]=arr[parent];
                index=parent;
                parent=(parent-1)/2;
            }
            arr[index]=bottom;
        }
        Node remove(){
            Node node=arr[0];
            arr[0]=arr[--curr]; 
            arr[curr]=null;
            trickleDown(0);
            return node;
        }
        void trickleDown(int index){
            int largeChild=0;
            Node top=arr[0];
            while(index<curr/2){
                int leftChild=2*index+1;
                int rightChild=2*index+2;
                if(rightChild<curr && arr[leftChild].count<arr[rightChild].count)
                    largeChild=rightChild;
                else
                    largeChild=leftChild;
                if(top.count>=arr[largeChild].count)break;
                arr[index] = arr[largeChild];
                index=largeChild;
            }
            arr[index]=top;
        }
        class Node{
            String data;
            int count;
            Node(String data,int count){
                this.data=data;
                this.count=count;
            }
        }
    }
}
