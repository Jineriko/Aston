package com.aston.homework.lesson2;

import java.util.*;

/** Класс создан исключительно для тестирования класса MyArrayList */
public class Test {
    public static void main(String[] args) {
        MyArrayList<String> collection = new MyArrayList<>();

//        for (int i = 0; i < 15; i++) {
//            collection.add(i);
//        }
//        System.out.println(collection);
//        System.out.println("------------------");
//
//        collection.remove(14);
//        System.out.println(collection);
//        System.out.println("------------------");
//
//        System.out.println(collection.get(10));
//
//        System.out.println("------------------");
//        collection.clear();
//        System.out.println(collection);
//
//        System.out.println("------------------");

//        for (int i = 0; i < 5000; i++) {
//            collection.add(new Random().nextInt(100));
//        }
//        System.out.println(collection);

//        Map<Integer, Integer> map = new TreeMap<>();
//        for (int i = 0; i < collection.size(); i++) {
//            if (!map.containsKey(collection.get(i))) {
//                map.put(collection.get(i), 1);
//            } else {
//                map.put(collection.get(i), map.get(collection.get(i)) + 1);
//            }
//        }

//        System.out.println(map);
//
//        collection.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        System.out.println(collection);

//        System.out.println(collection);
//        collection.sort(new IntegerComparator());
//        System.out.println(collection);

//        collection.quickSort(new IntegerComparator());
//        System.out.println(collection);

//        collection.remove(49);
//        System.out.println(collection);
        collection.add("A");
        collection.add("privet");
        collection.add("poka");
        collection.add("some word");
        collection.add("another word + chislo");

        System.out.println(collection);
//        collection.sort(new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        System.out.println(collection);

//        collection.quickSort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        System.out.println(collection);

        collection.sort(new StringComparator());
        System.out.println(collection);


    }
}
