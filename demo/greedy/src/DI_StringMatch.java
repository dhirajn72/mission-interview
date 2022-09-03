import java.util.Arrays;

public class DI_StringMatch {
	public static void main(String[] args) {
        String str = "IDID";
        System.out.println(Arrays.toString(diStringMatch(str)));
	}
    static public int[] diStringMatch(String s) {
        int n = s.length(), left = 0, right = n;
        int[] result = new int[n + 1];
        for(int i = 0; i < n; i++){
            result[i] = s.charAt(i) == 'I' ? left++ : right--;
        }
        result[n] = left;
        return result;
    }
}
