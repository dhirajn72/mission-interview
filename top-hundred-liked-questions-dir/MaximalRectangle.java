class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;

        if(matrix[0]==null||matrix[0].length==0)
            return 0;

        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=Integer.valueOf(matrix[i][j]+"");

            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]!=0){
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int max=0;
        for(int[] rows:dp){
            max=Math.max(max,largestHistogram(rows));
        }
        return max;
    }
    
    int largestHistogram(int[] nums){
        int result=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=i;j<n;j++){
                if(nums[j]>=nums[i])
                    count++;
                else
                    break;
            }
            for(int j=i-1;j>=0;j--){
                if(nums[j]>=nums[i])
                    count++;
                else
                    break;
            }
            result=Math.max(result,count*nums[i]);
        }
        return result;
    }

}
