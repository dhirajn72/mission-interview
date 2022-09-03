class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A==null||A.length==0)
            return new int[]{};
        Stack<Integer> even=new Stack<>();
        Stack<Integer> odd=new Stack<>();
        for(int i:A){
            if(i%2==0)
                even.push(i);
            else
                odd.push(i);
        }
        int[] result=new int[even.size()+odd.size()];
        int index=0;
        while(!even.isEmpty()){
            result[index++]=even.pop();
        }
        while(!odd.isEmpty()){
            result[index++]=odd.pop();
        }
    return result;
    }
}
