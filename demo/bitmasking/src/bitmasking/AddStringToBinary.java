package bitmasking;

class AddStringToBinary {
    /*public String addBinary(String a, String b) {
        char[] arr1=a.toCharArray();
        char[] arr2=b.toCharArray();
        int val1=0;
        int pow=0;
        for(int i=arr1.length-1;i>=0;i--){
            val1+=arr1[i]*Math.pow(2,pow++);
        }
        for(int j=arr2.length-1;j>=0;j--){
            val2+=arr2[j]*Math.pow(2,pow++);
        }
        int total=val1+val2;
        StringBuilder result=new StringBuilder();
        while(total!=0){
            result.append(total%2);
            total=total/2;
        }
        return result;
    } */
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0)
                sum += a.charAt(i--) - '0';
            if(j >= 0)
                sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
}
