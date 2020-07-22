package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
 *
 */
public class LeetCodeOffer12 {
    public static void main(String[] args) {
        //字符串对应的坐标以及状态
        char[][] board = {{'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}};
        String word = "asaa";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null){
            return false;
        }
        boolean [][]isVisited = new boolean[board.length][board[0].length];
        char [] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(board,i,j,isVisited,chars,0)){
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean dfs(char[][] board,int i,int j ,boolean[][] isVisited,char []chars,int index) {
        if(index == chars.length){
            return true;
        }
        if (i < 0 || j < 0  || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != chars[index]){
            return false;
        }

        isVisited[i][j] = true;
        boolean res = dfs(board, i + 1, j , isVisited, chars, index + 1) ||
                dfs(board, i - 1, j , isVisited, chars, index + 1) ||
                dfs(board, i, j + 1 , isVisited, chars, index + 1) ||
                dfs(board, i, j - 1, isVisited, chars, index + 1);
        isVisited[i][j] = false;
        return res;
    }
}
