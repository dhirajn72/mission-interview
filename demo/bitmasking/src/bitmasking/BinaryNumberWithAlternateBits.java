package bitmasking;
import java.util.*;
public class BinaryNumberWithAlternateBits {
    public boolean hasAlternatingBits(int n) {
        List<Integer> list=new ArrayList<>();
        while(n!=0){
            int mod=n%2;
            list.add(mod);
            n=n/2;
            if(list.size()>1 && list.get(list.size()-1)==list.get(list.size()-2))
                return false;
        }
        return true;
    }
}
