public class WordsReverseInString {
	public static void main(String[] args) {
		String str = "I am a programmer and I have no life";
		System.out.println(reverse(str));
	}
	static String reverse(String str){
		String[] arr = str.split(" ");
		return reverse(arr, arr.length - 1);
	}
	static String reverse(String[] arr, int n){
		if(n == 0){
			return arr[0];
		}
		return arr[n] +" "+reverse(arr, n - 1);
	}
}
