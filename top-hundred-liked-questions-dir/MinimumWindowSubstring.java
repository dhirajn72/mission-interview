class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        if(s.length()==t.length()){
            char[] sArr=s.toCharArray();
            char[] tArr=t.toCharArray();
            Arrays.sort(sArr);
            Arrays.sort(tArr);
            if(new String(sArr).equals(new String(tArr)))
                return s;
            return "";
        }
        String result="";
        boolean flag=false;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                String sub=s.substring(j,k);
                if(sub.length()<t.length())
                    continue;
                Map<Character,Character> map=new HashMap<>();
                for(int l=0;l<sub.length();l++){
                    if(!map.containsKey(sub.charAt(l)))
                        map.put(sub.charAt(l),sub.charAt(l));
                }
                int count=0;
                for(int l=0;l<t.length();l++){
                    if(map.containsKey(t.charAt(l))){
                        count++;
                    }
                    else
                        break;
                }
                if(count==t.length()){
                    if(result.isEmpty() && sub.length()==t.length()){
                        //result=sub;
                        char[] sArr=sub.toCharArray();
                        char[] tArr=t.toCharArray();
                        Arrays.sort(sArr);
                        Arrays.sort(tArr);
                        if(! new String(sArr).equals(new String(tArr))){
                            result="";
                            continue;
                        }
                        result=sub;

                    }
                    else if(result.isEmpty())
                        result=sub;
                    else if(result.length()>sub.length()){
                        result=sub;
                    }
                    else if(result.length()==t.length()){   
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
                break;
        }
        return result; 
    }
}
