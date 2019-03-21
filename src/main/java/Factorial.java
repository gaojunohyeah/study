/**
 * <p>
 * Title:
 * </p>
 * Description:
 * <p>
 *
 * @author jerry
 * @version Date: 2019/3/19
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(calZeroNum(1004500));
        System.out.println(calZeroNum1(1004500));
        System.out.println(calBitZeroNum(1004500));
        System.out.println(calBitZeroNum1(1004500));

        System.out.println(calFactorial(10));
        System.out.println("haha");
    }

    /**
     * 给定一个整数 N，那么 N 的阶乘 N! 末尾有多少个 0？例如： N = 10，则 N！= 3628800，那么 N! 的末尾有两个0。
     *
     * @param N
     * @return
     */
    public static int calZeroNum(int N) {
        int n = 0;
        int deln = 5;
        if (N <= 0) {
            return 0;
        } else {
            for (int i = 1; i <= N; i++) {
                int num = i;
                while (num % deln == 0) {
                    n = n + 1;
                    num = num / deln;
                }
            }
        }

        return n;
    }

    public static int calZeroNum1(int N) {
        int n = 0;
        int deln = 5;
        if (N <= 0) {
            return 0;
        } else {
            while (N != 0) {
                n += N / deln;
                N = N / deln;
            }
        }

        return n;
    }

    /**
     * 求 N! 的二进制表示中最低位 1 的位置。例如 3！=6，二进制为 1010，所以 最低位 1 的位置在第二位。
     *
     * @param N
     * @return
     */
    public static int calBitZeroNum(int N) {
        int n = 0;
        int deln = 2;
        if (N <= 0) {
            return 0;
        } else {
            while (N != 0) {
                N >>= 1;
                n += N;
            }
        }

        return n;
    }

    public static int calBitZeroNum1(int N) {
        int n = 0;
        int deln = 2;
        if (N <= 0) {
            return 0;
        } else {
            int t = deln;
            while (t <= N) {
                n = n + (N / t);
                t = t * deln;
            }
        }

        return n;
    }

    public static String calFactorial(long N) {
        String n = "1";
        if (N < 0) {
            return "0";
        } else if (N == 1) {
            return "1";
        } else {
            for (int i = 1; i <= N; i++) {
                n = mul(n, String.valueOf(i));
            }
        }
        return n;
    }

    public static String mul(String s1, String s2) {
        // 先把字符串转化为 字符数组。
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = c1.length + c2.length;
        // 用来存放两个数的积,字符的初始值为 '\u0000'，也就是 0
        char[] c = new char[len];
        // 由于大整数的低位是在字符串的末尾，所以我们从末尾遍历来计算
        for (int i = c1.length - 1; i >= 0; i--) {
            int index = len - 1;
            int res = 0;//用来存放进位
            for (int j = c2.length - 1; j >= 0; j--) {
                int temp = (c1[i] - '0') * (c2[j] - '0') + c[index] + res;
                res = temp / 10;
                c[index--] = (char) (temp % 10);
            }
            // 每趟乘下来的进位要进行保存。
            c[index] = (char) res;
            len--;
        }
        // 最后把c中的字符加上 '0'
        for (int i = 0; i < c.length; i++) {
            c[i] += '0';
        }
        String s = new String(c);
        // n位数乘以m位数得到积位 (m+n)位数或者(n+m-1)位数
        // 我们只需要判断c[0]是否为0，为0则把它舍弃。
        if (c[0] == '0') {
            return s.substring(1);
        } else {
            return s;
        }
    }
}
