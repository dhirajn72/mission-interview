
class Solution {
    public int minOperations(String[] logs) {
        int result=0;
        for(String dir:logs){
            if(dir.equals("../")){
                result=Math.max(0,--result);
            }
            else if(dir.equals("./")){
                continue;
            }
            else
                result++;
        }
        return result;
    }
}
