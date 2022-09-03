import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet{
    class Solution {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int i=piles.length-2;
            int result=0;
            while(i>=0){
                result+=piles[i];
                i -= 2;
            }
            return result;
        }
    }
}

/*

2,4,1,2,7,8

1,2,2,4,7,8

Alice:  8,2
Me:     7,2
Bob:    4,1

*/

