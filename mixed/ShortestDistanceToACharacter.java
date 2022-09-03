class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int[] result=new int[arr.length];
        int index=0;
        for(int i=0;i<n;i++){
            if(arr[i]==c){
                result[index++]=0;
                continue;
            }
            int left=0;
            int j=i;
            int count=0;
            while(j<n && arr[j]!=c){
                count++;
                j++;
            }
            if(j<n && arr[j]==c){
                left=count;
            }
            j=i;
            count=0;
            int right=0;
            while(j>=0 && arr[j]!=c){
                count++;
                j--;
            }
            if(j>=0 && arr[j]==c){
                right=count;
            }

            int min=0;
            if(left!=0 && right!=0){
                min=Math.min(left,right);
            }
            else if(right!=0){
                min=right;
            }
            else{
                min=left;
            }
            result[index++]=min;
        }
        return result;
    }
}
