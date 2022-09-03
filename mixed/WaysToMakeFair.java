class Solution {

    /*
    This solution works with time limit exceeds
    */
    
    /*
    public int waysToMakeFair(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int res=0;
        boolean[] dp=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int[] newArray=getNewArray(nums,i);

            int sum1=0;
            for(int j=0;j<newArray.length;j+=2)
                sum1+=newArray[j];
            
            int sum2=0;
            for(int j=1;j<newArray.length;j+=2)
                sum2+=newArray[j];

            if(sum1==sum2)
                dp[i]=true;
            if(dp[i])
                res++;
        }
        return res;
        
    }

    int[] getNewArray(int[] arr,int i){
        int index=0;
        int[] res=new int[arr.length-1];
        for(int j=0;j<arr.length-1;j++){
            if(i==j)
                continue;
            res[index++]=arr[j];
        }
        return res;
    }
        
    */

    int res=0;
    int[] left=new int[2];
    int[] right=new int[2];
    for(int i=0;i<nums.length;i++){
        right[i%2] += nums[i];
    }
    for(int i=0;i<nums.length;i++){
        rigth[i%2] -=nums[i];
        if(left[1]+right[0] == left[0]+right[1])
            res++;

        left[i%2] += nums[i];
    }
    return res;
}
