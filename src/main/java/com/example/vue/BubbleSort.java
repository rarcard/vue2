package com.example.vue;
/**
 * @Author zyx
 * @Description:冒泡排序算法
 * @Create: 2020/6/6 14:38
*/
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr={99,1,0,88,44,101,66,38,54,12};
        int temp;
        for(int i=0;i<arr.length-1;i++){        //外层循环排序次数
            for(int j=0;j<arr.length-1;j++){    //相邻位置比较大小
                if(arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int k:arr){
            System.out.print(k+" ");
        }
    }
}
