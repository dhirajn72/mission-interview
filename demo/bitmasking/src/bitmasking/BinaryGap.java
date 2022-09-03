package bitmasking;
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }
    public static int binaryGap(int n) {
        int max = 0, flag = 0, dis = 0;
        while (n != 0) {
            int t = n % 2;
            n /= 2;
            if (t == 1 && flag == 1) {
                dis++;
                max = Math.max(max, dis);
                dis = 0;
            } else if (t == 1 && flag == 0) {
                flag = 1;
            } else if (t == 0 && flag == 1) {
                dis++;
            }
        }
        return max;
    }
}
