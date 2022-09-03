package bitmasking;

import java.util.ArrayList;
import java.util.List;

public class NumberComplement{
     public int findComplement(int num) {
         int i=0,res=0;
         List<Integer> list=new ArrayList<>();
         while(num!=0){
             int mod=num%2;
             list.add(mod);
             num=num/2;
         }
         for(int bit:list){
             bit=bit==0?1:0;
             res+=bit*Math.pow(2,i++);
         }
         return res;
    }
}
