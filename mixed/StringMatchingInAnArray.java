class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<words.length;i++){
            String word=words[i];
            for(int j=i+1;j<words.length;j++){
                String next=words[j];
                if(word.contains(next))
                    set.add(next);

                if(next.contains(word))
                    set.add(word);
            }
        }
        return new ArrayList<>(set);
        
    }
}
