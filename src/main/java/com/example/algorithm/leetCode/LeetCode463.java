package com.example.algorithm.leetCode;

/**
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，
 * 一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且
 * 宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class LeetCode463 {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},
        {1,1,1,0},
        {0,1,0,0},
        {1,1,0,0}};
        int count = islandPerimeter(grid);
        System.out.println(count);
    }

    /**
     * 暴力解法，双重循环，判断每个值是否是1，
     * 然后在判断这个值的上下左右，如果是0或者越界，
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int curValue = grid[i][j];
                if(curValue == 1){
                    if(i - 1 < 0){
                        count++;
                    }else{
                        if(grid[i - 1][j] == 0){
                            count ++;
                        }
                    }
                    if(i + 1 >= grid.length){
                        count++;
                    }else{
                        if(grid[i + 1][j] == 0){
                            count ++;
                        }
                    }
                    if(j - 1 < 0){
                        count++;
                    }else{
                        if(grid[i][j - 1] == 0){
                            count ++;
                        }
                    }

                    if(j + 1 >= grid[0].length){
                        count++;
                    }else{
                        if(grid[i][j + 1] == 0){
                            count ++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
