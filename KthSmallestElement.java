
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
       if(root==null){
           return 0;
       }
       countNodes(root);
       int[] arr=new int[count];
       int index=0;
       for(int e:list){
           arr[index++]=e;
       }
       HeapTest heap=new HeapTest(arr.length);
       for(int i:arr){
           heap.insert(i);
       }
       
       int result=0;
       while(k-->0){
          result=heap.remove();
       }
       return result;
    }
    void countNodes(TreeNode root){
        if(root==null)
            return;

        Queue<TreeNode> q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                list.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
                count++;
            }
        }
    }

    class HeapTest{
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
            while(index>0 && arr[parent].data > bottom.data){
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
                if(rightChild<curr && arr[leftChild].data>arr[rightChild].data)
                    largeChild=rightChild;
                else
                    largeChild=leftChild;
                if(top.data<=arr[largeChild].data)break;
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
      
      /*  public static void main(String args[]){
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
        }*/
    }
}
