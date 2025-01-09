package com.aston.homework.lesson2;

import java.util.Comparator;

/** Класс для сравнения integer в естественном порядке */
public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
