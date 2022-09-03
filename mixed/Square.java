public class Square {
    

    // 3^4
    // 3*3*3*3=81

    static int square(int a,int b){
        if(b==0){
            return 1;
        }
        return a*square(a,b-1);
    }

    /*
    
    2^8
    2*2*2*2*2*2*2*2

    
    */

    public static void main(String[] args){
        System.out.println(square(3,4));
        System.out.println(square(2,8));
        
    }

}