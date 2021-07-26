package com.abc.zh.study.newfeatures.lambda.ex;

import java.util.ArrayList;
import java.util.Collections;

public class Exe4 {

    public static void main(String[] args) {
        //遍历集合
        ArrayList<Integer> list1 = new ArrayList<>();

        Collections.addAll(list1, 1,2,3,4,5);

        //lambda表达式 方法引用
        list1.forEach(System.out::println);

        list1.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });



        System.out.println("---------------------------------------------");
        //删除集合中某个元素
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(11, "小牙刷", 12.05 ));
        items.add(new Item(5, "日本马桶盖", 999.05 ));
        items.add(new Item(7, "格力空调", 888.88 ));
        items.add(new Item(17, "肥皂", 2.00 ));
        items.add(new Item(9, "冰箱", 4200.00 ));
        items.removeIf(ele -> ele.getId() == 7);
        //通过 foreach 遍历，查看是否已经删除
        items.forEach(System.out::println);

        System.out.println("==============================================");
        //集合内元素的排序
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(13, "背心", 7.80));
        list.add(new Item(11, "半袖", 37.80));
        list.add(new Item(14, "风衣", 139.80));
        list.add(new Item(12, "秋裤", 55.33));

        /*
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getId()  - o2.getId();
            }
        });
        */

        list.sort((o1, o2) -> o1.getId() - o2.getId());

        System.out.println(list);
    }
}
