package com.wangduwei.algorithms.other.minimal_id;

/**
 * 分区求解
 */
public class D_PartitionSolution {
    /*寻找下一个可用的最小Id
 在乱序数组中寻找最小缺失数
 参数：arr 输入数组地址,begin当前划分数组的开始位置下标，end结束位置下标*/
    int findNextId(int[] arr, int begin, int end) {

        if (begin > end) {//出口条件
            return begin + 1;//自己列出实例观察
        }
        int mid = begin + ((end - begin) >> 1);//中间元素的下标
        int midK = mid - begin + 1;//当前数组划分中中间元素的位置，即第几个(不是下标)
        int q = selectK(arr, begin, end, midK); //中间元素的值
        if (q == mid + 1)//左边是紧密的
            return findNextId(arr, mid + 1, end);//在右边查找缺失值
        else
            return findNextId(arr, begin, mid - 1); //在左边查找缺失值

    }

    /*乱序数组中寻找第k小元素(即顺序的第k个元素)*/
    int selectK(int[] arr, int begin, int end, int k) {
        int q = partition2(arr, begin, end);//主元的下标
        int nowQ = q - begin + 1;//nowK:主元在当前的数组划分中是第几个元素(注意不是下标)
        if (nowQ < k)//当前主元位置小于k,即k在主元右侧
            return selectK(arr, q + 1, end, k - nowQ);//在右数组中k新的相对位置下标(代入nowQ的值发现等价与k+begin-(q+1))//即新的k的下标
        else if (nowQ > k)
            return selectK(arr, begin, q - 1, k);//k在当前数组划分的左半部分，位置还是ke
        else
            return arr[q];//索引元素值的时候又得用回下标q了
    }

    /*双向扫描分区函数,将数组分为两部分左边小于主元，右边大于主元*/
    int partition2(int arr[], int begin, int end) {
        int pivot = arr[begin];
        int left = begin + 1;
        int right = end;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot)//因为left在变化所以这里也要有left<=right的判断条件
                left++;
            while (left <= right && arr[right] > pivot)
                right--;
            //当arr[left]>pivot&&arr[right]<=pivot时，交换它俩的值
            if (left < right) {//如果left==right就没有交换的必要了
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        int tmp = arr[begin];//交换主元到右指针的位置
        arr[begin] = arr[right];
        arr[right] = tmp;

        return right;
    }
}
