package com.wangduwei.algorithms.leetcode.array.matrix;

import org.junit.Test;

/**
 * 矩阵旋转的两种解法,图片旋转
 * https://mp.weixin.qq.com/s/ZIMuOvUJekiKx_UIvH1kjA
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @author : wangduwei
 * @date : 2020/6/6
 * @description :
 */
public class _48_RotateMatrix {

    /**
     * 好理解，从外向内，一层一层旋转
     */
    public static void rotatex(int[][] matrix) {
        int pos1 = 0, pos2 = matrix.length - 1;
        while (pos1 < pos2) {
            int offset = 0;
            while (offset < pos2 - pos1) {
                //左下角
                int temp = matrix[pos2 - offset][pos1];
                //右下->左下
                matrix[pos2 - offset][pos1] = matrix[pos2][pos2 - offset];
                //右上->右下
                matrix[pos2][pos2 - offset] = matrix[pos1 + offset][pos2];
                //左上->右上
                matrix[pos1 + offset][pos2] = matrix[pos1][pos1 + offset];
                //左下角->左上
                matrix[pos1][pos1 + offset] = temp;
                //0 = temp
                offset = offset + 1;
            }
            pos1 = pos1 + 1;
            pos2 = pos2 - 1;
        }
    }

    /*
    123
    456
    789
    */
    public void rotate(int[][] matrix) {
        int temp, width = matrix[0].length - 1;
        for (int x = 0, y = width; x < y; x++, y--) {
            for (int s = x, e = y; s < y; s++, e--) {
                temp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            }
        }
    }

    public void rotate3(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        //上下翻转
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        //对角线翻转=i和j坐标互换一下就行了
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }


    @Test
    public void testRotate() {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        print(matrix);
        rotate2(matrix);
        print(matrix);
        /*
        13-9-5-1-
        14-10-6-2-
        15-11-7-3-
        16-12-8-4-
         */
    }


    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
