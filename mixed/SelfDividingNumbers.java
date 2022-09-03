class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        Set<Integer> set=new HashSet<>();
        for(int i=left;i<=right;i++){
            set.add(i);
        }
        List<Integer> result=new ArrayList<>();
        boolean flag=true;
        for(int i:set){
            String val=String.valueOf(i);
            for(int j=0;j<val.length();j++){
                int digit=Integer.valueOf(val.charAt(j)+"");
                if(digit==0){
                    flag=false;
                    break;
                }
                if(!(i%digit==0)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                result.add(i);
            }else{
                flag=true;
            }
        }
        Collections.sort(result);
        return result;
    }
}
