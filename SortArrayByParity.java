class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if(A==null)
            return new int[]{};
        Stack<Integer> even=new Stack<>();
        Stack<Integer> odd=new Stack<>();
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                even.push(A[i]);
            }
            else{
                odd.push(A[i]);
            }
        }
        int index=0;
        boolean flag=true;
        while(!even.isEmpty() && !odd.isEmpty()){
            if(flag){
                A[index++]=even.pop();
                flag=false;
            }
            else{
                A[index++]=odd.pop();
                flag=true;
            }
        }
         while(!even.isEmpty()){
            A[index++]=even.pop();
        }
        while(!odd.isEmpty()){
            A[index++]=odd.pop();
        }
        return A;
    }
}
