package leetcode;

/**
 * Created by lcyanxi on 2019/3/14
 * 回文数  123 -》 321
 */


public class ReverseNum {
    public static void main(String[] args) {
        int a = 483648;

        System.out.println(test2(a));
    }


    public static int test(int num) {
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        boolean flag = true;
        if (num < 0) {
            flag = false;
        }

        String tmp = String.valueOf(num);

        if (tmp.charAt(0) == '-') {
            tmp = tmp.substring(1, tmp.length());
        }
        String result = "";
        boolean sign = true;
        char tmpc[] = tmp.toCharArray();
        for (int i = tmpc.length - 1; i >= 0; i--) {
            if (sign && tmpc[i] == 0) {
                continue;
            }
            sign = false;
            // result = result.append(tmpc[i]);
            result = result + tmpc[i];
        }

        if (Long.parseLong(result) > Integer.MAX_VALUE) {
            return 0;
        }
        return flag ? Integer.parseInt(result) : (-Integer.parseInt(result));
    }

    public static int test2(int num) {
        int result = 0;
        while (num != 0) {
            int tmp = num % 10;
            num /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && tmp > 8)) return 0;
            result = result * 10 + tmp;
        }
        return 0;
    }
}
