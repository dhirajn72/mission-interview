public class MaximumScoreFormedByLetters {
	static public int maxScoreWords(String[] words, char[] letters, int[] score) {
		int max = 0;
		int[] count = new int[26];
		for(char c : letters){
			count[ c - 'a']++;
		}
		max = backtrack(words, count, score, 0);
		return max;
	}

	static int backtrack(String[] words, int[] count, int[] score, int start){
		int max = 0;
		for(int i = start; i < words.length; i++ ){
			int res = 0;
			boolean isValid = true;
			for(char c : words[i].toCharArray()){
				count[c - 'a']--;
				res += score[c - 'a'];
				if(count[c - 'a'] < 0)
					isValid = false;
			}
			if(isValid){
				res += backtrack(words, count, score, i + 1);
				max = Math.max(max, res);
			}

			//reset the values of count arr, for the next iteration.
			for(char c : words[i].toCharArray()){
				count[c - 'a']++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String[] words = {"dog","cat","dad","good"};
		char[] letters = {'a','a','c','d','d','d','g','o','o'};
		int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(maxScoreWords(words, letters, score));
	}
}
