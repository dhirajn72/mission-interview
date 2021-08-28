class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(s==null||s.length()==0)
            return result;
        int n=s.length();   
        char[] arr2=p.toCharArray();
        Arrays.sort(arr2);
        String strToMatch=new String(arr2);
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                String sub=s.substring(j,k);
                if(sub.length()<p.length())
                    continue;

                char[] arr1=sub.toCharArray();
                Arrays.sort(arr1);
                if(new String(arr1).equals(strToMatch))
                    result.add(j);
            }
        }
        return result;
    }
}
