import java.util.Arrays;

public class LongestNonrepeatingString {
	public static int lengthOfLongestSubstring(String s) {
		int[] map = new int[255];
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map[s.charAt(i)] != 0) {
				int count = 0;
				for (int j = 0; j < 255; j++) {
					if (map[j] != 0) {
						count++;
					}
				}
				result = Math.max(result, count);
				Arrays.fill(map, 0);
				int k = i;
				while (k >= 0) {
					map[s.charAt(k)] = s.charAt(k);
					k--;
					if (s.charAt(i) == s.charAt(k)) break;
				}
			} else {
				map[s.charAt(i)] = s.charAt(i);
			}
		}
		//System.out.println(Arrays.toString(map));
		int i = 0, count = 0;
		while (i < map.length) {
			System.out.println(map[i]);
			if (map[i] != 0) {
				count++;
			}
			i++;
		}
		return Math.max(result, count);
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
}
