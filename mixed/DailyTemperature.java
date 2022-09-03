class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0)
            return new int[]{0};

        int[] result=new int[T.length];
        int index=0;
        for(int i=0;i<T.length-1;i++){
            int count=1;
            for(int j=i+1;j<=T.length-1;j++){
                if(T[j]>T[i]){
                    result[i]=count;
                    break;
                }
                else{
                    count++;
                }
            }
        }
        return result;
    }
}
