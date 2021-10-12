package com.wangduwei.algorithms.leetcode.array;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

/**
 * <p>移除重复2次后的元素
 *
 * @author : wangduwei
 * @since : 2020/4/3  14:23
 **/
public class RemoveMoreThan2 extends BaseSortAlgorithms {

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2, 2, 3, 4, 4};
        new RemoveMoreThan2().removeMoreThan2(A);
        display(A);
    }


    public void removeMoreThan2(int[] num) {
        int i = 0;
        boolean skip = true;
        for (int j = 1; j < num.length; j++) {
            if (num[i] == num[j] && skip){
                i++;
                skip = false;
                continue;
            }
            if (num[i] != num[j]){
                i++;
                num[i] = num[j];
                skip = true;
            }
        }
        while(i<num.length){
            num[i] = 0;
            i++;
        }
    }

}
