package com.example.algorithm.leetCode;

import com.example.algorithm.dataStructure.ArrayStack;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
public class LeetCode844 {

    public static void main(String[] args) {
        backspaceCompare("ab##"
                ,"c#d#");
    }

    public static boolean backspaceCompare(String S, String T) {
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < sc.length; i++){
            if(sc[i] == '#'){
                if(sb1.length() != 0){
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            }else{
                sb1.append(sc[i]);

            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < tc.length; i++){
            if(tc[i] == '#'){
                if(sb2.length() != 0){
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            }else{
                sb2.append(tc[i]);

            }

        }
        String s = sb1.toString();
        String s2 = sb2.toString();
        return s.equals(s2);
    }
}
