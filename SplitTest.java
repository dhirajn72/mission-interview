import java.util.Arrays;
public class SplitTest{
    public static void main(String[] args){
        String[] arr="1.1.1.1".split(".");
        System.out.println(Arrays.toString(arr));


        String str = "1.1.1.1";
        String[] arrOfStr = str.split("/.");

        for (String a : arrOfStr)
            System.out.println(a);
    }
}
