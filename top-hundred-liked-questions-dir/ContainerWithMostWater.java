class Solution {
    public int maxArea(int[] height) {
        int length=height.length;
        int max=0;
        
        int left=0;
        int right=length-1;
        
        while(left<right){
            int min=Math.min(height[left],height[right]);
            max=Math.max(max,min*length);
            if(height[left]<height[right])
                left++;
            else
                right--;
            length--;
        }
        return max;

    }
}
