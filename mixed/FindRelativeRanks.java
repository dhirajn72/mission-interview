class Solution {
    public String[] findRelativeRanks(int[] score) {
        if(score==null||score.length==0)
            return new String[]{};
        int n=score.length;
        Heap heap=new Heap(n);
        for(int e:score){
            heap.insert(e);
        }
        String[] answer=new String[n];
        for(int i=0;i<n;i++){
            answer[i]=String.valueOf(score[i]);
        }
        int gold=heap.remove();
        int silver=heap.remove();
        int bronze=heap.remove();
        for(int i=0;i<n;i++){
            if(answer[i].equals(String.valueOf(gold))){
                answer[i]="Gold Medal";
            }
            else if(answer[i].equals(String.valueOf(silver))){
                answer[i]="Silver Medal";
            }
            else if(answer[i].equals(String.valueOf(bronze))){
                answer[i]="Bronze Medal";
            }
        }
        int count=4;
        while(!heap.isEmpty()){
            int val=heap.remove();
            for(int i=0;i<n;i++){
                if(answer[i].equals(String.valueOf(val))){
                    answer[i]=String.valueOf(count);
                    break;
                }
            }
            count++;
        }
        return answer;
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
        void insert(int data){
            if(curr==max)
                return;
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
            Node top=arr[0];
            arr[0]=arr[--curr];
            arr[curr]=null;
            trickleDown(0);
            return top.data;
        }
        void trickleDown(int index){
            int largeChild=0;
            Node top=arr[index];
            while(index<curr/2){
                int leftChild=2*index+1;
                int rightChild=2*index+2;
                if(rightChild<curr && arr[leftChild].data<arr[rightChild].data)
                    largeChild=rightChild;
                else
                    largeChild=leftChild;
                if(top.data>=arr[largeChild].data)break;
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
