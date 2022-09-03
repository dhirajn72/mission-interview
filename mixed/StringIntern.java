public class StringIntern{
    public static void main(String[] args){
        String s1="abc";
        String s2=new String("abc");
        String s3=new String("ABC");
        String s4=s1.intern();
        String s5=s2.intern();
        System.out.println(s1==s4);
        System.out.println(s2==s5);
        System.out.println(s1==s5);
        System.out.println(s1.intern()==s2.intern());

    }
}
