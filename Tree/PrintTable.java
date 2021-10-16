public class PrintTable{
    public static void main(String[] args){
        int e=Integer.valueOf(args[0]);
        System.out.println("Table of::"+e);
        for(int i=1;i<=10;i++){
            System.out.println(e*i);
        }
    }
}
