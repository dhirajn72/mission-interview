class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length==0)
            return 0;
        
        if(A.length<=3)
            return 0;
        int result=0;
        int count=0;

        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                count++;
                result+=count;
            }
            else{
                count=0;
            }
        }
        return result;
    }
}
