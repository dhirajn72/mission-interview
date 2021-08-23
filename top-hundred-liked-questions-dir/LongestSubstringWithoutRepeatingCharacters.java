class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        if(s==null||s.isEmpty())
            return result;

        int[] arr=new int[128];
        int n=s.length();
        for(int i=0;i<n;i++){
            if(arr[s.charAt(i)]==0){
                arr[s.charAt(i)]=s.charAt(i);
            }
            else{
                int count=0;
                for(int j=0;j<arr.length;j++){
                    if(arr[j]!=0)
                        count++;
                }
                result=Math.max(count,result);
                Arrays.fill(arr,0);
                for(int k=i-1;k>=0;k--){
                    if(s.charAt(i)==s.charAt(k))
                        break;
                    arr[s.charAt(k)]=s.charAt(k);
                }
                arr[s.charAt(i)]=s.charAt(i);
            }
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0)
                count++;
        }
        return Math.max(count,result);
        
    }
}
