class Solution {
    public int numSplits(String s) {
        int n=s.length();
        Set<Character> unique=new HashSet<>();
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<n;i++){
            unique.add(s.charAt(i));
            left[i]=unique.size();
        }
        unique.clear();
        for(int i=n-1;i>=0;i--){
            unique.add(s.charAt(i));
            right[i]=unique.size();
        }
        int result=0;
        for(int i=1;i<n;i++){
            if(left[i-1]==right[i])
                result++;
        }
        return result;
        
    }
}
