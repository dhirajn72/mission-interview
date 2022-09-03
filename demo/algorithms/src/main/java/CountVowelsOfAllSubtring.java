public class CountVowelsOfAllSubtring {
	static public long countVowels(String word) {
		long res = 0, prev = 0;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				prev += i + 1;
			res += prev;
		}

		return res;
	}
	public static void main(String[] args){
		System.out.println(countVowels("countthenumberofvowels"));
	}
}
