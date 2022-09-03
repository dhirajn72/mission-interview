class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }

        HeapTest heap=new HeapTest(map.size());
        for(int key:map.keySet()){
            heap.insert(key,map.get(key));
        }
        
        int[] res=new int[k];
        int index=0;
        while(k-- > 0 ){
            HeapTest.Node node= heap.remove();
            res[index++]=node.data;
        }
        return res;
    }

    class HeapTest{
            Node[] arr;
            int curr,max;
            HeapTest(int size){
                arr=new Node[size];
                this.max=size;
                curr=0;
            }
            void insert(int data,int count){
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
                    if(top.data>=arr[largeChild].count)break;
                    arr[index] = arr[largeChild];
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
