package com.aston.homework.lesson2;

import java.util.Arrays;
import java.util.Comparator;

/** Своя реализация коллекции MyArrayList, аналог коллекции ArrayList.
 * Содержит только основные методы для работы с коллекцией.
 * Работает с generics */

public class MyArrayList<T> {
    /** Массив для хранения объектов, из-за ограничения generics тип данных выбран object */
    private Object[] elements;
    /** Изначальный объем(вместимость) массива */
    private static final int BASE_CAPACITY = 10;
    /** Количество элементов в массиве */
    private int size;

    /** Конструктор, инициализирует изначальный объем массива и размер */
    public MyArrayList(){
        elements = new Object[BASE_CAPACITY];
        size = 0;
    }

    /** Добавление элемента в массив */
    public void add(T element){
        // Проверки на null и заполненность массива
        checkNull(element);
        isFullArray();
        elements[size] = element;
        size++;
    }

    /** Добавление элемента по индексу в массив */
    public void add(int index, T element){
        // Проверки на корректность index, null и заполненность массива
        checkIndex(index);
        checkNull(element);
        isFullArray();
        // все элементы от индекса сдвигаются вправо на 1, после чего на нужную позицию вставляется элемент
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /** Получение элемента по индексу */
    public T get(int index){
        // Проверка на корректность index
        checkIndex(index);
        return (T) elements[index];
    }

    /** Удаление элемента по индексу */
    public void remove(int index){
        // Проверка на корректность index
        checkIndex(index);
        // все элементы начиная с позиции index сдвигаются на 1 влево,
        // после чего последнему элементу присваивается null для удаления
        for (int i = index; i < size ; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    /** Переопределение toString для более удобного(читаемого) вывода на экран */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] == null)
                continue;
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /** Очищение всей коллекции */
    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    /** Геттер для получения размера коллекции */
    public int size(){
        return size;
    }

    /** Сортировка коллекции стандартным способом */
    public void sort(Comparator<? super T> comparator){
        // Проверка comparator на null
        checkComparator(comparator);
        Arrays.sort((T[])elements, 0, size, comparator);
    }

    /** Сортировка коллекции способом быстрой сортировки */
    public void quickSort(Comparator<? super T> comparator){
        // Проверка comparator на null
        checkComparator(comparator);
        // метод быстрой сортировки
        quickSortHelper((Comparator<T>) comparator, 0, size - 1);
    }

    /** Метод быстрой сортировки */
    private void quickSortHelper(Comparator<? super T> comparator, int from, int to){
        if (from < to) {
            // Выбор индекса опорного элемента и разделение массива
            int pivotIndex = partition(comparator, from, to);
            // Вызов рекурсивной функции для двух половин массива
            quickSortHelper(comparator, from, pivotIndex - 1);
            quickSortHelper(comparator, pivotIndex + 1, to);
        }
    }

    /** Разделение массива на два подмассива для quickSortHelper */
    private int partition(Comparator<? super T> comparator, int from, int to){
        // Границы массива справа и слева
        int leftIndex = from;
        int rightIndex = to;

        // Опорный элемент берется за первый элемент в массиве
        T pivot = (T) elements[from];
        while(leftIndex <= rightIndex){

            // Движение по массиву с начала к концу, ищем элемент, который больше опорного
            while (comparator.compare((T) elements[leftIndex], pivot) < 0){
                leftIndex++;
            }

            // Движение по массиву с конца к началу, ищем элемент, который меньше опорного
            while (comparator.compare((T) elements[rightIndex], pivot) > 0){
                rightIndex--;
            }

            // Меняем местами элементы, которые нашли выше
            if(leftIndex <= rightIndex){
                T temp = (T) elements[leftIndex];
                elements[leftIndex] = elements[rightIndex];
                elements[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }
        // если не находим пару возвращаем первый элемент
        return leftIndex;
    }

    /** Проверка на заполненность массива */
    private void isFullArray(){
        if(size == elements.length){
            // Увеличение объема(вместимости) коллекции в два раза
            int newCapacity = size * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /** Проверка на корректность индекса (чтобы попадал в рамки) */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Не верно указан индекс: " + index + ", последний индекс в массиве: " + (size - 1));
        }
    }

    /** Проверка на null */
    private void checkNull(T element){
        if (element == null)
            throw new IllegalArgumentException("Значение не может быть null");
    }

    /** Проверка comparator на null */
    private void checkComparator(Comparator<? super T> comparator){
        if (comparator == null)
            throw new IllegalArgumentException("Comparator не может быть null");
    }
}
