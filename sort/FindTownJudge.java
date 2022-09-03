class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr=trust[0];
        Queue<Integer> q=new LinkedList<>();
        q.offer(arr[1]);
        for(int[] arr1:trust){
            if(arr1[0]==arr[1]){
                arr=arr1;
            }
        }
        
    }
}
