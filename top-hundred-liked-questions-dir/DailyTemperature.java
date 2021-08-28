class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null||temperatures.length==0)
            return new int[]{0};

        int n=temperatures.length;
        int[] result=new int[n];
        

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=i;j<n;j++){
                if(temperatures[j]>temperatures[i]){
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
