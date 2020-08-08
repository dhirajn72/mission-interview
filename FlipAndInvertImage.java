class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A==null||A.length==0)
            return A;
        Stack<Integer> s=new Stack<>();
        for(int[] arr:A){
            for(int i:arr){
                s.push(i);
            }
            int index=0;
            while(!s.isEmpty()){
                arr[index++]= s.pop()==1?0:1;
            }
        }
        return A;
    }
}


