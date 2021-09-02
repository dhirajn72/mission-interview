class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        String firstHalf=s.substring(0,n/2);
        String secondHalf=s.substring(n/2,n);

        int vowelsCount=0;
        for(int i=0;i<firstHalf.length();i++){
            if(firstHalf.charAt(i)=='a'||firstHalf.charAt(i)=='e'|| firstHalf.charAt(i)=='i'|| firstHalf.charAt(i)=='o'|| firstHalf.charAt(i)=='u' ||  firstHalf.charAt(i)=='A'|| firstHalf.charAt(i)=='E'|| firstHalf.charAt(i)=='I'|| firstHalf.charAt(i)=='O'|| firstHalf.charAt(i)=='U' ){
                vowelsCount++;
            }
        }
        for(int i=0;i<secondHalf.length();i++){
            if(secondHalf.charAt(i)=='a'||secondHalf.charAt(i)=='e'|| secondHalf.charAt(i)=='i'|| secondHalf.charAt(i)=='o'|| secondHalf.charAt(i)=='u' ||  secondHalf.charAt(i)=='A'|| secondHalf.charAt(i)=='E'|| secondHalf.charAt(i)=='I'|| secondHalf.charAt(i)=='O'|| secondHalf.charAt(i)=='U' ){
                vowelsCount--;
            }
        }
        return vowelsCount==0;


        
    }
}
