package com.wangduwei.algorithms.search;

public class OrderSearch {

    public static int orderSearch(int searchKey,int[] array){
        if(array==null||array.length<1)
            return -1;
        for(int i=0;i<array.length;i++){
            if(array[i]==searchKey){
                return i;
            }
        }
        return -1;

    }
}
