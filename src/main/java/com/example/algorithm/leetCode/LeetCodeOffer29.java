package com.example.algorithm.leetCode;

public class LeetCodeOffer29 {


    public static void main(String[] args) {
        int [][]matrix ={{1,2,3},{4,5,6},{7,8,9}};
        int []order = spiralOrder(matrix);
        System.out.println(order);
    }

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null ||  matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int total = rows * columns;
        int [] order = new int[total];
        //定义了四个不同的方向
        // 第一个方向代表向右
        // 第二个方向代表想下
        // 第三个方向代表向左
        // 第四个方向代表向上
        // 用当前的row 和 colummn 加上这个ij 坐标就得到了后续的值
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[rows][columns];
        int row = 0;
        int column = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return order;
    }

}
