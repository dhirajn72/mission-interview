class Solution {
    /*
       Input: S = "ababcbacadefegdehijhklij"
       Output: [9,7,8]
       Explanation:
       The partition is "ababcbaca", "defegde", "hijhklij".
       This is a partition so that each letter appears in at most one part.
       A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

    */

    public List<Integer> partitionLabels(String S) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            int lastIndex=S.lastIndexOf(ch);

            String subString=S.substring(i,lastIndex);
            int index=0;
            int len=0;
            int lastSubIndex =0;
            while(index<subString.length()){
                lastSubIndex = subString.lastIndexOf(subString.charAt(index));
                if(lastSubIndex<=lastIndex){
                    continue;
                }
                else{
                    subString=S.substring(i,lastSubIndex);
                }
                len=Math.max(len,subString.length());
                index++;
            }
            result.add(len);

        }
        return result;
    }
}
