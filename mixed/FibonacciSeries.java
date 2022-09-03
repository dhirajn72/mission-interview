import java.util.*;
public class FibonacciSeries{
    public static int  fibo(int n){ 
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        else
            return fibo(n-1)+fibo(n-2);

    }
    public static int fiboMemoized(int n){
        int[] memo=new int[n+1];
        memo[0]=0;
        memo[1]=1;
        for(int i=2;i<n;i++){
            memo[i]=memo[i-1]+memo[i-2];
        }
        System.out.println(Arrays.toString(memo));
        return memo[n-1];
    }

    public static void main(String[] args){
        int param=Integer.valueOf(args[0]);
        //int result= fibo(param);
        int result= fiboMemoized(param);
        System.out.println(param);
        System.out.println(result);
    }
}
/**

0 1 1 2 3 5 8 13 21 34 55


**/
