class Solution {
    int res=0;
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        for(List<String> list:items){
            if(ruleKey.equals("type")){
                if(list.get(0).equals(ruleValue))
                    res++;
            }
            else if(ruleKey.equals("color")){
                if(list.get(1).equals(ruleValue))
                    res++;
            }
            else if(ruleKey.equals("name")){
                if(list.get(2).equals(ruleValue))
                    res++;
            }
        }
        return res;

    }
}
