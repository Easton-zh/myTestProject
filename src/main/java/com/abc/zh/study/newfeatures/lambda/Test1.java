package com.abc.zh.study.newfeatures.lambda;

public class Test1 {

    public static void main(String[] args) {

        //无参无返回
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("this is [NoReturnNoParam] interface !");
        };
        noReturnNoParam.method();

        //一个参数无返回
        NoReturnOneParam noReturnOneParam = (int a) -> {
            System.out.println("this is [NoReturnOneParam] interface, one param:" + a);
        };
        noReturnOneParam.method(6);

        //多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a, int b) -> {
            System.out.println("this is [NoReturnMultiParam] interface , multi param:" + "{" + a +"," + + b +"}!");
        };
        noReturnMultiParam.method(6, 8);

        //无参有返回值
        ReturnNoParam returnNoParam = () -> {
            System.out.print("this is [ReturnNoParam] interface!");
            return 1;
        };
        int res = returnNoParam.method();
        System.out.println("-------->[ReturnNoParam] return:" + res);

        //一个参数有返回值
        ReturnOneParam returnOneParam = (int a) -> {
            System.out.println("this is [ReturnOneParam] interface , one param:" + a);
            return 1;
        };
        int res2 = returnOneParam.method(6);
        System.out.println("--------->[ReturnOneParam] return:" + res2);

        //多个参数有返回值
        ReturnMultiParam returnMultiParam = (int a, int b) -> {
            System.out.println("this is [ReturnMultiParam] interface ,multi param:" + "{" + a + "," + b +"}");
            return 1;
        };
        int res3 = returnMultiParam.method(6, 8);
        System.out.println("---------->[ReturnMultiParam] return:" + res3);

    }
}
