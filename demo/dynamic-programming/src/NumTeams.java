public class NumTeams {
		static public int numTeams(int[] rating) {
			int[] dp = new int[rating.length];
			int count = 0;
			for( int i = 0 ; i < rating.length; i++){
				for( int j = i; j >= 0; j--){
					if(rating[i] > rating[j]){
						dp[i] += 1;
						count += dp[j];
					}
				}
			}
			dp = new int[rating.length];
			for( int i = 0 ; i < rating.length; i++){
				for( int j = i; j >= 0; j--){
					if(rating[i] < rating[j]){
						dp[i] += 1;
						count += dp[j];
					}
				}
			}
			return count;
		}
    static public int numTeams_bruteforce(int[] rating) {
        int result = 0;
        for( int i = 0 ; i < rating.length; i++){
            for(int j = i + 1 ; j < rating.length; j++ ){
                for( int k = j + 1 ; k < rating.length; k++){
                    if( (rating[i] < rating[j]  && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k]) )
                        result++;

                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int[] rating = {2,5,3,4,1,9,6,7,8,0};
		//System.out.println(numTeams(rating));
		System.out.println(numTeams_bruteforce(rating));

	}
}
