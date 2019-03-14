package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lcyanxi on 2019/3/14
 */

public class Solution {
    public static void main(String[] args) {
        String str = "asadaqasad";
        System.out.println( test2(str));
       // test1();

    }

    /**
     * 双重for
     * @param str 输入字符串
     * @return 最大子串长度
     */
    public static int solution(String str) {
        int longest = 0;
        char tmp[] = str.toCharArray();
        List list = new ArrayList();
        for (int j = 0; j < str.length(); j++) {
            for (int i = j; i < str.length(); i++) {
                if (list.contains(tmp[i])) {
                    break;
                } else {
                    list.add(tmp[i]);
                }
            }
            longest=Math.max(longest,list.size());
            if (longest >= (str.length() - j + 1)) {
                break;
            }
            list.clear();
        }

        return longest;
    }

    /**
     * set 集合
     * @param str 输入字符串
     * @return 最大子串长度
     */
    public static int test2(String str) {
        int index = str.length();
        int longest = 0;
        int i = 0;int j = 0;
        Set<Character> set=new HashSet<>();
        while (i < index && j < index) {
            if (!set.contains(str.charAt(j))){
                set.add(str.charAt(j++));
                longest=Math.max(longest,j-i);
            }else {
                set.remove(str.charAt(i++));
            }
        }
        return longest;
    }


}

