package com.example.vue;

import java.util.Arrays;

/**
 * @Author zyx
 * @Description:排序算法集合类 默认升序 int
 * @Create: 2020/6/6 15:04
 */
public class Sort {
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    /**
     * @Author zyx
     * @Description:冒泡算法
     * @Create: 2020/6/6 16:46
     */
    public void BubbleSort() {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {        //外层循环排序次数
            for (int j = 0; j < arr.length - 1; j++) {    //相邻位置比较大小
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * @Author zyx
     * @Description:选择排序 不稳定 5 8 5 2 9 第一遍5与2交换之后不稳定
     * @Create: 2020/6/6 16:47
     */
    public void SelectionSort() {
        int temp, min;
        for (int i = 0; i < arr.length - 1; i++) {   //
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {    // 变换最小标记位置
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * @Author zyx
     * @Description:插入排序 从后往前排
     * @Create: 2020/6/6 18:03
     */
    public void InsertionSort() {
        int cur, pre;
        for (int i = 1; i < arr.length; i++) { //未排序数下标，认定之前的是已经排序好的
            cur = arr[i];
            pre = i - 1; //当前值的前一位
            while (pre >= 0 && arr[pre] > cur) {  //已排序数  当前值与前一位比较 大的往后移动
                arr[pre + 1] = arr[pre];   //比temp大的都往后移  pre+1即为当前位置
                pre--;
            }
            arr[pre + 1] = cur;
        }
    }

    /**
     * @Author zyx
     * @Description:插入排序 从前往后
     * @Create: 2020/6/6 18:52
     */
    public void InsertionSort2() {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {   //内层循环 认定i之前为有序
                if (arr[i] < arr[j]) {  //i位置不变 从前往后移动
                    temp = arr[j];    //大的移动到i位
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * @Author zyx
     * @Description:希尔排序 分组 插入
     * @Create: 2020/6/7 12:17
     */
    public void ShellSort() {
        for (int gap = (int) Math.floor(arr.length / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {   //向下取整 取分组间隔
            /* 以gap为界向后运动 每个分组并不是一次性完成排序的  */
            for (int i = gap; i < arr.length; i++) {   //各个分组交替进行插入排序 从后往前
                int cur = arr[i];
                int pre = i - gap;  //前一个位置
                while (pre >= 0 && arr[pre] > cur) {
                    arr[pre + gap] = arr[pre];  //pre+gap当前位置
                    pre = pre - gap;
                }
                arr[pre + gap] = cur;
            }
        }
    }

    /**
     * @Author zyx
     * @Description:归并排序 分成左右两组 左右要排好序 合并  部分排序
     * @Create: 2020/6/7 14:01
     */
    public void Merge(int left, int mid, int right) {
        int left_size = mid - left + 1;
        int right_size = right - mid;
        int i, j, k;
        int left_arr[] = new int[left_size];
        int right_arr[] = new int[right_size];
        // 左右数组赋值
        for (i = left; i <= mid; i++) {
            left_arr[i - left] = arr[i];
        }
        for (i = mid + 1; i <= right; i++) {
            right_arr[i - mid - 1] = arr[i];
        }
        k = left;  //注意K的值=left left为这部分的起点
        i = 0;
        j = 0;
        /* 左右比较大小 左小则左+1并再次比较 右边同理 */
        while (i < left_size && j < right_size) {
            if (left_arr[i] < right_arr[j]) {
                arr[k++] = left_arr[i++];
            } else {
                arr[k++] = right_arr[j++];
            }
        }
        /* 剩余拼接 */
        while (i < left_size) {
            arr[k++] = left_arr[i++];
        }
        while (j < right_size) {
            arr[k++] = right_arr[j++];
        }
    }

    /**
     * @Author zyx
     * @Description:归并排序 乱序递归 不断地切分 部分排序  分治
     * @Create: 2020/6/7 14:03
     */
    public void MergeSort(int left, int right) {
        int mid;
        if (left != right) {
            mid = (left + right) / 2;
            MergeSort(left, mid);   //递归
            MergeSort(mid + 1, right);  //递归
            Merge(left, mid, right);
        }
    }

    /**
     * @Author zyx
     * @Description:快速排序 分治 递归
     * @Create: 2020/6/7 18:05
     */
    public void QuickSort(int left, int right) {
        if (left < right) {
            int pivot = Quick2(left, right);     //对分区快排
            QuickSort(left, pivot - 1);  //左分区递归
            QuickSort(pivot + 1, right);  //右分区递归
        }
    }

    /**
     * @Author zyx
     * @Description:快速排序 对分区操作
     * @Create: 2020/6/7 18:07
     */
    public int Quick(int left, int right) {
        int pivot = left;
        while (left < right) {
            if (arr[right] >= arr[pivot]) {
                right--;
            } else if(left<right){
                if (arr[left] <= arr[pivot]) {
                    left++;
                } else if(left<right) {
                    swap(right, left);
                }
            }
        }
        /* left=right 将标准位置换到left=right位 */
        swap(right, pivot);
        return right;
    }

    public int Quick2(int left, int right) {
        int pivot = left; //确定标准位
        while (left < right) {
            /* 从右往左 查出比基准值小的数以待交换 */
            while (arr[right] > arr[pivot] && left < right) {  //内层循环须判断left<right
                right--;
            }
            while (arr[left] <= arr[pivot] && left < right) {    //进去时可能满足left<right 出来时不一定满足
                left++;
            }
            if (left < right) {
                swap(left, right);
            }
        }
        swap(right, pivot);
        return right;
    }

    /**
     * @Author zyx
     * @Description:三角交换函数
     * @Create: 2020/6/7 19:46
     */
    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
