package com.aston.homework.lesson2;

import java.util.Comparator;

/** Класс для сравнения string по длине слова */
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
