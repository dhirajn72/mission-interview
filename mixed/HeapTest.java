public class HeapTest{
        Node[] arr;
        int curr,max;
        HeapTest(int size){
            arr=new Node[size];
            this.max=size;
            curr=0;
        }
        void insert(int data){
            Node node=new Node(data);
            arr[curr]=node;
            trickleUp(curr++);
        }
        void trickleUp(int index){
            int parent=(index-1)/2;
            Node bottom=arr[index];
            while(index>0 && arr[parent].data < bottom.data){
                arr[index]=arr[parent];
                index=parent;
                parent=(parent-1)/2;
            }
            arr[index]=bottom;
        }
        int remove(){
            Node node=arr[0];
            arr[0]=arr[--curr]; 
            arr[curr]=null;
            trickleDown(0);
            return node.data;
        }
        void trickleDown(int index){
            int largeChild=0;
            Node top=arr[0];
            while(index<curr/2){
                int leftChild=2*index+1;
                int rightChild=2*index+2;
                if(rightChild<curr && arr[leftChild].data<arr[rightChild].data)
                    largeChild=rightChild;
                else
                    largeChild=leftChild;
                if(top.data>=arr[largeChild].data)break;
                arr[index] = arr[largeChild];
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
        public static void main(String args[]){
            int[] arr={9,3,1,5,4,7,2};
            HeapTest heap=new HeapTest(arr.length);
            for(int i:arr){
                heap.insert(i);
            }

            System.out.println("********");
            while(heap.curr!=0){
                System.out.print(heap.remove()+",");
            }
            System.out.println();
        }
}
