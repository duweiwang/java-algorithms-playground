package com.wangduwei.algorithms.leetcode.array.matrix;

/**
 * 二维数组的查找，二分法实现
 * https://mp.weixin.qq.com/s/PHXWYXOcfR3xJ7NGTWtnyw
 *
 * @author : wangduwei
 * @date : 2020/6/21
 * @description :
 */
public class MatrixFind_binary {


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        int row = getRow(matrix, target);
        return find(matrix[row], target);
    }

    /*行内查找*/
    public boolean find(int[] data, int target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (data[mid] == target)
                return true;
            else if (data[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    /**
     * 查找在哪一行
     */
    public int getRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        int col = matrix[0].length - 1;
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][col] < target)
                top = mid + 1;
            else
                bottom = mid;
        }
        return top;
    }


}
