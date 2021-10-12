package com.wangduwei.algorithms.leetcode.array;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>整数的下一个最大值
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author : wangduwei
 * @since : 2020/5/7  14:39
 **/
public class _31_NextBiggerInt extends BaseSortAlgorithms {

    public static void main(String[] args) {
        int num = 1347654;
//        String nextInt = NextBiggerInt.findNextInt(num);
        String nextInt = _31_NextBiggerInt.findNextInt2(num);
        System.out.println(nextInt);
    }

    private static String findNextInt(int num) {
        //将该自然数放入数组
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (num % 10 > 0) {
            nums.add(0, num % 10);
            num = num / 10;
        }
        //为了和原数接近,我们要保持高位不变,低位在最小范围内变换顺序
        //从右向左寻找逆序区域的临界值
        int cricitalPoint = findCricitalPoint(nums);
        if (cricitalPoint > 0) {
            //存在,就把临界值的前一个数和逆序区域中刚刚大于该数的数字交换位置,然后把逆序区域变为顺序
            return reorder(nums, cricitalPoint);
        }
        return "";
    }

    /**
     * 倒序遍历链表，找到前一个值小于后一个值的分界点
     */
    private static int findCricitalPoint(ArrayList<Integer> nums) {
        for (int i = nums.size() - 1; i > 0; i--) {
            if (nums.get(i) > nums.get(i - 1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 把逆序区域临界值的前一位和逆序区域中刚刚大于该数的数字交换位置,并把逆序区域变为顺序
     */
    private static String reorder(ArrayList<Integer> nums, int index) {
        //把逆序临界值的前一位和逆序区域中刚刚大于该数的数字交换位置
        //记录临界值的前一个数
        int left = nums.get(index - 1);
        for (int i = nums.size() - 1; i >= index; i--) {//循环逆序区域
            int right = nums.get(i);
            if (left < right) {
                nums.set(index - 1, right);
                nums.set(i, left);
                break;
            }
        }
        //把逆序区域变为顺序
        for (int i = index, j = nums.size() - 1; i < j; i++, j--) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
        return nums.toString();
    }

    //----------Array Impl---------------------

    private static int[] int2array(int value) {
        String strValue = String.valueOf(value);
        int[] nums = new int[strValue.length()];
        int i = nums.length - 1;
        while (value % 10 > 0 && i >= 0) {
            nums[i] = value % 10;
            value = value / 10;
            i--;
        }
        return nums;
    }

    /*找到数组大小分割点*/
    private static int findSplitIndex(int[] arrays) {
        for (int i = arrays.length - 1; i > 1; i--) {
            if (arrays[i] > arrays[i-1]){
                return i;
            }
        }
        return -1;
    }

    private static String findNextInt2(int num) {
        int[] intArray = int2array(num);
        int index = findSplitIndex(intArray);
        String result = findBiggerAndSwap(intArray,index);
        return result;
    }

    private static String findBiggerAndSwap(int[] nums, int index) {
        int temp = nums[index - 1];
        //倒着找刚刚比他大的值，交换位置
        for (int i = nums.length - 1; i >= index; i--) {
            int right = nums[i];
            if (temp < right) {
                nums[index - 1]= right;
                nums[i] =temp;
                break;
            }
        }
        reversArray(nums,index,nums.length - 1);
        return Arrays.toString(nums);
    }

    private static void reversArray(int[] array ,int start,int end){
        for (int i = start, j = end; i < j; i++, j--) {
            swap(array,i,j);
        }
    }

   @Test
    public void testInt2Array() {
        AlgorithmCommon.printArray(int2array(123456789));
    }

    @Test
    public void testSplitArray(){
        System.out.print(findSplitIndex(new int[]{1,3,5,7,6,5,4}));
    }

}
