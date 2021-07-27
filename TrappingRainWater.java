class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0)
            return 0;

        int[] leftMax=new int[height.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            max=Math.max(max,height[i]);
            leftMax[i]=max;
        }
        max=Integer.MIN_VALUE;
        int[] rightMax=new int[height.length];
        for(int i=height.length-1;i>=0;i--){
            max=Math.max(max,height[i]);
            rightMax[i]=max;
        }
        int[] delta=new int[height.length];
        for(int i=0;i<leftMax.length;i++){
            delta[i]=Math.min(leftMax[i],rightMax[i]);
        }
        int result=0;
        for(int i=0;i<delta.length;i++){
            result+=delta[i]-height[i];
        }
        return result;
        
    }
}
