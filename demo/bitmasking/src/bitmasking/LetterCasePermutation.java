package bitmasking;

import java.util.*;
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        Queue<String> q=new LinkedList<>();
        q.offer(s);
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))
                continue;
            int size=q.size();
            for(int j=0;j<size;j++){
                String str=q.poll();
                char[] arr=str.toCharArray();

                arr[i]=Character.toUpperCase(arr[i]);
                q.offer(new String(arr));

                arr[i]=Character.toLowerCase(arr[i]);
                q.offer(new String(arr));
            }
        }
        return new ArrayList<>(q);

    }
}
