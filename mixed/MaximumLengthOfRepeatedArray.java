class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int max=0;

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i]==nums2[j])
                    dp[i+1][j+1] =  dp[i][j]+1 
                
                max=Math.max(dp[i+1][j+1],max);
            }
        }
        return max;
    }
}
