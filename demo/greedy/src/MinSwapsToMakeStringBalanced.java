public class MinSwapsToMakeStringBalanced {
	static public int minSwaps(String s) {
		int open = 0, swaps = 0;
		char[] arr = s.toCharArray();
		int j = arr.length - 1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == '[')
				open++;
			else
				open--;

			if(open < 0){
				while(i < j && arr[j] != '[')
					j--;
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				swaps++;
				open++;
			}
		}
		return swaps;
	}

	public static void main(String[] args) {
		String str = "][][";
		System.out.println(minSwaps(str));
	}
}
