package com.abc.zh;

public class Test implements TestInterface{


    @org.junit.Test
    public void method() {
        char[] arr = new char[] { 'a', 'b', 'c' };
        System.out.println(arr);//
        int[] arr1 = new int[] { 1, 2, 3 };
        System.out.println(arr1);//
        double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
        System.out.println(arr2);//

        int a = 5;
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);//

        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//


        System.out.println("==========================");
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//


        System.out.println("=============================");
        String zH = TestInterface.Z_H;
        System.out.println(zH);

    }
}
