import java.util.*;
public class TestDeleteCharDuringIteration{
    public static void main(String[] args){
        String[] arr={"abc","def"};
        for(char s:arr[0].toCharArray()){
            if(s=='a'){
                arr[0]="xyz";
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
