package com.wfs.springvue.sortTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaoPaoSort {
    public static void main(String[] args) {
        Integer[] integers={10,2,3,5,9,7,4,333,322,1};
        //冒泡
        //maoPaoSort(integers);
        radixSort(integers);
        for (int i=0;i<integers.length;i++){
            System.out.print(integers[i]+" ");
        }
    }

    //基数排序
    public  static void radixSort (Integer[] array){
        int n=1;//代表位数对应的数：1,10,100...
        int k=0;//保存每一位排序后的结果用于下一位的排序输入
        int[][] bucket=new int[10][array.length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] num=new int[array.length];//用于保存每个桶里有多少个数字 ,最多为输入数组长度
        while(n<=array.length)
        {
            for(int e:array) //将数组array里的每个数字放在相应的桶里
            {
                int digit=(e/n)%10;
                bucket[digit][num[digit]]=e;
                num[digit]++;
            }
            for(int i=0;i<array.length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if(num[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for(int j=0;j<num[i];j++)
                    {
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                num[i]=0;//将桶里计数器置0，用于下一次位排序
            }
            n*=10;
            k=0;//将k置0，用于下一轮保存位排序结果
        }
    }

    //冒泡
    public static void maoPaoSort( Integer[] integers){
        Integer site=integers.length;
        for (int i=0;i<site-1;i++) {
            for (int j=1;j<site-1-i;j++){
                if (integers[j]>integers[j-1]){
                    int tem = integers[j];
                    integers[j] = integers[j-1];
                    integers[j-1] = tem;

                }
            }
        }
    }

    //直接插入排序
    public static void directInsertSort(int [] array){
        int tem = 0;
        for(int i = 1;i<array.length;i++){
            int j = i-1;
            tem = array[i];
            for(;j>=0&&array[j]>tem;j--){
                array[j+1] =array[j];//将大于array[i]的数整体后移一单位
            }
            array[j+1] = tem;
        }
    }
    //快速排序
    public static void rapidSort(int [] array){
        if(array == null||array.length<1){
            System.out.println("Error");
            return;
        }
        rapidSort(array,0, array.length-1);
    }
    public static void rapidSort(int [] array,int start,int end){
        if(start>end){
            return;
        }
        int i = start;
        int j = end;
        int k = array[i];
        boolean flag = true;
        while(i!=j){
            if(flag){
                if(k>array[j]){
                    swap(array,i,j);
                    flag = false;
                }else{
                    j--;
                }
            }else{
                if(k<array[i]){
                    swap(array,i,j);
                    flag = true;
                }else{
                    i++;
                }
            }
        }
        //递归
        rapidSort(array, start, j-1);
        rapidSort(array, i+1, end);


    }
    /*
     * 交换两个元素的位置
     */
    public static void swap(int [] array,int i,int j){
        int tem = 0;
        tem = array[i];
        array[i] = array[j];
        array[j] = tem;

    }

}
