class Solution {
    public int trap(int[] height) {
        int n=height.length;

        int[] leftMax=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            leftMax[i]=max;
        }
        max=Integer.MIN_VALUE;
        int[] rightMax=new int[n];
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            rightMax[i]=max;
        }
        int[] diff=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=Math.min(leftMax[i],rightMax[i]);
        }
        int[] resultArray=new int[n];
        int result=0;
        for(int i=0;i<n;i++){
            resultArray[i]=diff[i]-height[i];
            result+=resultArray[i];
        }
        return result;
    }
}
