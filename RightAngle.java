public class RightAngle {
    
    public static void main(String[] args) {
        printLeftToRight(10);
        System.out.println("@@@@@@@@@@@@@@@");
        printRightToLeft(10);
        System.out.println("@@@@@@@@@@@@@@@");
        printPyramid(10);
    }


    static void printLeftToRight(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = n-i; j >= 1; j--) {
                System.out.print("");
            }
            System.out.println();
        }
    }

    static void printRightToLeft(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = n-i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void printPyramid(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = n-i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}