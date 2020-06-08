package com.example.vue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringBootTest
@DisplayName("A special test case")
class Triangle2Test {
    @Autowired
    private Triangle2 t2;

    @BeforeEach
    void setUps() {
        t2=new Triangle2();
    }
    
    /**
     * @Author zyx
     * @Description:等腰三角形测试
     * @Create: 2020/5/16 20:22
     */
    @Test
    @DisplayName("A")
    void isTriangles() {
        int res = t2.isTriangles(3, 2, 3);
        assertTrue(3 == res, "17905437 周应祥");
    }

    /**
     * @Author zyx
     * @Description:判断三角形 参数化测试
     * @Create: 2020/5/17 21:39
    */
    @ParameterizedTest
    @CsvSource({"0,1,2,30","1,3,4,5","2,3,3,3","3,2,3,3"})
    void isTrianglesx(int a,double b,double c,double d){
        assertEquals(a,t2.isTriangles(b,c,d));
    }

    /**
     * @Author zyx
     * @Description:三角形面积测试 已知三边长
     * @Create: 2020/5/16 22:44
    */
    @Test
    void area(){
        double res=t2.area(3,4,5);
        System.out.println(res);

        assertEquals(6,res,"17905437 周应祥");

    }

    /**
     * @Author zyx
     * @Description:三角形面积 前置条件测试
     * @Create: 2020/5/17 22:14
    */
    @DisplayName("assumption")
    @Test
    void area2(){
        double res=t2.area(3,4,5);
        System.out.println(res);

        assumeTrue(res>20,"不满足条件");
    }
}