import java.util.Arrays;

public class ReorganizeString {
	class Solution {
		public String reorganizeString(String s) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            for(int i = 1; i < arr.length-1 ; i++ ){
                if(arr[i]==arr[i-1]){
                    char temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            for(int i = 1; i < arr.length; i++){
                if(arr[i]==arr[i-1])
                    return "";
            }
            return new String(arr);
		}
	}
}
