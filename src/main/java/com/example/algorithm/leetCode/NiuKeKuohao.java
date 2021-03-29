package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Stack;

public class NiuKeKuohao {

    public static boolean isValid (String s) {
        // write code here
        //先转成一个char数组，然后左边进栈，遇到有括号直接出栈，如果没匹配到，直接返回false
        //当遍历完成之后，栈中还有元素，依然是false ，否则，成功
        char[] ch = s.toCharArray();
        HashMap<Character,Character> map = initData();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < ch.length; i++){
            if(map.containsKey(ch[i])){
                stack.push(ch[i]);
            }else{
                if(stack.empty()){
                    return false;
                }else{
                    Character stackValue = stack.pop();
                    if(ch[i] == map.get(stackValue)){
                        continue;
                    }
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;

    }

    private static HashMap<Character,Character> initData(){
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        return map;
    }

    private boolean isValid2(String s){
        while(true){
            int len = s.length();
            s=s.replace("()","");
            s=s.replace("[]","");
            s=s.replace("{}","");
            if(len == s.length()){
                break;
            }
        }
        boolean ss = s.length() == 0;
        return ss;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean flag = true;

    }
}
