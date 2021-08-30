package com.example.algorithm.leetCode.plus;

public class LeetCode251 {


   static class Vector2D {

       static int x = 0,y = 0;
       static int maxX = 0;
       static int [][] vec;
        public Vector2D(int[][] vec) {
            maxX = vec.length;
            this.vec = vec;
        }

        public static int next() {
            //先输出，在移动指针 y碰壁之后 x = x + 1
            if(x >= maxX ){
                return -1;
            }
            int value = vec[x][y];
            if(y == vec[x].length - 1){
                x = x + 1;
                y = 0;
            }else if(y < vec[x].length - 1){
                y++;
            }
            return value;
        }

        public static boolean hasNext() {
            if(x < maxX ){
                return true;
            }
            return false;
        }


    }
    public static void main(String[] args) {
       int [][] ss = {{1,2},{3},{4}};
        Vector2D iterator  = new Vector2D(ss);

        System.out.println(iterator.next()); // 返回 1
        System.out.println(iterator.next()); // 返回 2
        System.out.println(iterator.next()); // 返回 3
        System.out.println(iterator.hasNext()) ;// 返回 true
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 4
        System.out.println(iterator.hasNext()); // 返回 false

    }
}
