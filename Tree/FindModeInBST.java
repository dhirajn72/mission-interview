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
    public int[] findMode(TreeNode root) {
        if(root==null)
            return new int[]{};
        Map<Integer,Integer> map=new HashMap<>();
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                map.put(temp.val,map.getOrDefault(temp.val,0)+1);
                root=temp.right;
            }
        }
        Heap heap=new Heap(map.size());
        for(int key:map.keySet()){
            heap.insert(key,map.get(key));
        }
        List<Integer> resultList=new ArrayList<>();
        Heap.Node first=heap.remove();
        resultList.add(first.val);
        while(!heap.isEmpty()){
            Heap.Node node=heap.remove();
            if(first.val==node.val){
                resultList.add(node.val);
            }
            else{
                break;
            }
        }
        int index=0;
        int[] result=new int[resultList.size()];
        for(int val:resultList){
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
        boolean isEmpty(){
            return curr==0;
        }
        void insert(int val,int count){
            if(curr==max)
                return;
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
            Node(int val, int count){
                this.val=val;
                this.count=count;
            }
        }

    }
}
