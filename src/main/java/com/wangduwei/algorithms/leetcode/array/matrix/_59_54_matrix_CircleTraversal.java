package com.wangduwei.algorithms.leetcode.array.matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋打印矩阵
 *
 * @author : wangduwei
 * @date : 2020/6/17
 * @description :
 */
public class _59_54_matrix_CircleTraversal {

    @Test
    public void testCircleTraversal() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        CircleTraversal(a);
    }

    /**
     * 59. 螺旋矩阵 II
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
//
//    作者：jyd
//    链接：https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public void visit(int a[][], int n) {
        int p = 0, q = n - 1;
        int count = 0;

        while (count < n * n) {
            for (int i = p; i <= q; i++)//从上面开始赋值
                a[p][i] = ++count;

            for (int i = p + 1; i <= q; i++)//从右边开始赋值
                a[i][q] = ++count;

            for (int i = q - 1; i >= p; i--)//从下面开始赋值
                a[q][i] = ++count;

            for (int i = q - 1; i >= p + 1; i--)
                a[i][p] = ++count;
            p++;
            q--;
        }
    }

//————————————————
//    版权声明：本文为CSDN博主「gzj_1101」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/gzj_1101/java/article/details/56840746

    //54. 螺旋矩阵
    //给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    public static List<Integer> CircleTraversal(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return result;

        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;

        int total = matrix.length * matrix[0].length;

        while (total >= 1) {
            for (int i = l; i <= r && total >= 1; i++) {
                result.add(matrix[t][i]);
                total--;
            }
            t++;
            for (int i = t; i <= b && total >= 1; i++) {
                result.add(matrix[i][r]);
                total--;
            }
            r--;
            for (int i = r; i >= l && total >= 1; i--) {
                result.add(matrix[b][i]);
                total--;
            }
            b--;
            for (int i = b; i >= t && total >= 1; i--) {
                result.add(matrix[i][l]);
                total--;
            }
            l++;
        }
        return result;
    }
}
