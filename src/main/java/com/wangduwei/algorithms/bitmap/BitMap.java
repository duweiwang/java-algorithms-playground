package com.wangduwei.algorithms.bitmap;

/**
 * <p>位图算法。
 *
 * @author : wangduwei
 * @since : 2020/4/15  13:59
 **/
public class BitMap {

    /**
     * 保存数据的连续内存，1个byte能存储8个数据。
     * 7   6  5  4  3  2  1  0
     * 15 14 13 12 11 10  9  8
     * 23 22 21 20 19 18 17 16
     * ...
     */
    private byte[] bytes;

    /**
     * 这里是简单的Bitmap实现，BitMap比较完备的实现是带有自动扩容处理的。
     * @param capacity 能够存储的数据量
     */
    public BitMap(int capacity){
        // capacity个数据需要多少个bit呢，capacity/8 + 1
        bytes = new byte[(capacity >> 3) + 1];
    }

    /**
     * 通过num/8来得到存储num的二进制位所在的字节在bytes数组中的索引
     * @param num
     * @return
     */
    private int getIndexInByteArray(int num) {
        int arrayIndex = num >> 3; // num / 8
        return arrayIndex;
    }
    /**
     *
     * 通过num%8来得到存储num的二进制位在所属的字节中的postion
     * @param num
     * @return 0~7
     */
    private int getPostionInTheByte(int num) {
        int position = num & 0x07; // num % 8
        return position;
    }

    public void add(int ... nums) {
        for (int num : nums) {
            addOne(num);
        }
    }
    /**
     * 添加一个数
     * @param num
     */
    private void addOne(int num){
        // 要将二进制数A中倒数第三个二进制位的值置1，就需要"A | 0x00000100"
        bytes[getIndexInByteArray(num)] |= 1 << getPostionInTheByte(num);
    }

    /**
     * 数是否存在
     * @param num
     * @return
     */
    public boolean contains(int num){
        // 判断二进制数A中倒数第三个二进制位的值是否为0，就需要看"A & 0x00000100"结果是否等于0
        return (bytes[getIndexInByteArray(num)] & (1 << getPostionInTheByte(num))) !=0;
    }

    /**
     * 删除一个数
     * @param num
     */
    public void remove(int num){
        // 要将二进制数A中倒数第三个二进制位的值置0，就需要 "A & 0x11111011"，即 "A & (~0x00000100)"
        bytes[getIndexInByteArray(num)] &= ~(1 << getPostionInTheByte(num));

    }
}
