public class LoopTest {
    public static void main(String[] args){
        String str="abcdefgh";
        int n=str.length();
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                System.out.println(str.substring(j,k));
            }
        }
        System.out.println("----------");
        int[] arr={1,2,3,4,5};
        n=arr.length;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                for(int l=j;l<=k;l++)
                    System.out.print(arr[l]);
                System.out.println();
            }
        }
        /*
           Both the above loops are same, but when dealing with arrays, keep k value -1 
           because arrays are zero indexed. In case of substring don't subtract -1 because
           second parameter of substring method is 1 based and not 0 based index.
         */

        // This is sliding window with k size
        System.out.println("-----@@@-----");
        arr= new int[]{1,2,3,4,5};
        n=arr.length;
        int k=4;
        for(int i=0;i<n-k+1;i++){
            for(int j=0;j<k;j++){
                    System.out.print(arr[i+j]);
            }
            System.out.println();
        }

    }

}
