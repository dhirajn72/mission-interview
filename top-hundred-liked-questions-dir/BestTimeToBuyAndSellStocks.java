class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        /*int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;*/
        
        int[] leftMin=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,prices[i]);
            leftMin[i]=min;
        }
        int result=0;
        for(int i=0;i<n;i++){
            leftMin[i]=prices[i]-leftMin[i];
        }
        for(int i=0;i<n;i++){
            result=Math.max(result,leftMin[i]);
        }
        return result;

    }
}
