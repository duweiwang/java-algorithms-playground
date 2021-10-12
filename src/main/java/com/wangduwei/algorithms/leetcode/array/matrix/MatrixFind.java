package com.wangduwei.algorithms.leetcode.array.matrix;

/**
 * <p>二维数组的查找[剑指offer]
 *
 * @author : wangduwei
 * @since : 2019/11/23  10:11
 **/
public class MatrixFind {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        boolean isExist = new MatrixFind().isExist(array, 7);
        System.out.println(isExist);
    }

    /**
     * 查找指定元素是否存在数组中
     * <p>
     * [1,2,8,9]
     * [2,4,9,12]
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 存在 true
     */
    public boolean isExist(int[][] matrix, int target) {
        int columns = matrix[0].length - 1, rows = matrix.length - 1;
        //边界值处理
        int currentRow = 0, currentColumn = columns;

        while (currentColumn >= 0 && currentRow <= rows) {
            if (matrix[currentRow][currentColumn] == target) {
                return true;
            }
            if (matrix[currentRow][currentColumn] < target) {
                currentRow++;
            }
            if (matrix[currentRow][currentColumn] > target) {
                currentColumn--;
            }
        }
        return false;
    }

}
