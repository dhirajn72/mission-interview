class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n=nums1.length;
        int m=nums2.length;
        int[] finalArray=new int[n+m];
        int index=0;
        for(int i=0;i<n;i++){
            finalArray[i]=nums1[i];
            index=i;
            index++;    
        }

        for(int i=0;i<m;i++)
            finalArray[index++]=nums2[i];
        
        Arrays.sort(finalArray);
        int mid=finalArray.length/2;
        System.out.println(mid);
        if(finalArray.length%2==0){
            double result= ((double)finalArray[mid]+(double) finalArray[mid-1])/2.0;
            return result;  
        }
        else
            return finalArray[mid];
    }
}
