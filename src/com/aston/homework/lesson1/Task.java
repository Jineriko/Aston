package com.aston.homework.lesson1;


import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        // task1
        String string = "I love Java";
        Homework.turnString(string);

        System.out.println("--------------------");

        // task2
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        Homework.getDistinctNumbers(ints);

        System.out.println("--------------------");

        // task3
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        System.out.println(Homework.findSecondMaxElement(arr));

        System.out.println("--------------------");

        // task4
        String string1 = "Hello world";
        String string2 = "    fly me    to the moon    ";
        System.out.println(Homework.lengthOfLastWord(string2));

        System.out.println("--------------------");

        // task5
        String string3 = "abc";
        String string4 = "112233";
        String string5 = "aba";
        String string6 = "112211";
        System.out.println(Homework.isPalindrome(string6));
    }

    public class Homework {

        // Перевернуть строку и вывести на консоль
        // String string = "I love Java";
        public static void turnString(String string) {
            StringBuilder sb = new StringBuilder(string);
            System.out.println(sb.reverse().toString());
        }

        // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        // Удалить дубликаты из массива и вывести в консоль
        public static void getDistinctNumbers(int[] ints) {
            int[] distinctNumbers = Arrays.stream(ints).distinct().toArray();
            System.out.println(Arrays.toString(distinctNumbers));
        }

        // Дан массив, заполненный уникальными значениями типа int.
        // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
        public static Integer findSecondMaxElement(int[] arr) {
            int[] sortedArray = arr;
            Arrays.sort(sortedArray);
            return sortedArray[sortedArray.length - 2];
        }

        // Найти длину последнего слова в строке. В строке только буквы и пробелы.
        // "Hello world" - 5
        // "    fly me    to the moon    " - 4
        public static Integer lengthOfLastWord(String string) {
            String[] words = string.trim().split(" ");
            return words[words.length - 1].length();
        }

        // Определить, что строка является палиндромом
        // Сложность по памяти O(1), не создавать новые String, StringBuilder
        // Примеры:
        // abc - false
        // 112233 - false
        // aba - true
        // 112211 - true
        public static boolean isPalindrome(String string) {
            int lengthString = string.length();
            for (int i = 0; i < lengthString / 2; i++) {
                if (string.charAt(i) != string.charAt(lengthString - 1 - i))
                    return false;
            }
            return true;
        }
    }
}
