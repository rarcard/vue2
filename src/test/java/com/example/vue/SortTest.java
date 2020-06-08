package com.example.vue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SortTest {
    Sort sort;
    int[] res={1,12,55,66,77,99};
    @BeforeEach
    void setUp() {
        int[]arr={1,12,99,66,55,77};
        sort=new Sort(arr);
        System.out.println("前置执行");
    }
    @Test
     void BubbleSort(){
        sort.BubbleSort();
        System.out.println(sort.toString());
        Assertions.assertArrayEquals(res,sort.getArr());
    }
    @Test
    void SelectionSort(){
        sort.SelectionSort();
        System.out.println(sort.toString());
        Assertions.assertArrayEquals(res,sort.getArr());
    }
    @Test
    void InsertionSort(){
        sort.InsertionSort();
        System.out.println(sort.toString());
        Assertions.assertArrayEquals(res,sort.getArr());
    }
    @Test
    void InsertionSort2(){
        sort.InsertionSort2();
        System.out.println(sort.toString());
        Assertions.assertArrayEquals(res,sort.getArr());
    }
    @Test
    void ShellSort(){
        sort.ShellSort();
        System.out.println(sort.toString());
        Assertions.assertArrayEquals(res,sort.getArr());
    }
    @Test
    void Merge(){
            sort.Merge(0,2,5);
    }

    @Test
    void MergeSort(){
        sort.MergeSort(0,5);
        System.out.println(sort.toString());
        Assertions.assertArrayEquals(res,sort.getArr());
    }
    @Test
    void QuickSort(){
        sort.QuickSort(0,5);
        System.out.println(sort.toString());
        Assertions.assertArrayEquals(res,sort.getArr());
    }
}
