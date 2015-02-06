package com.javarush.test.level07.lesson04.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

/**
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
        //initialize(create and fill) an array here - инициализируйте (создайте и заполните) массив тут
        int[] nums = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        return nums;
    }

    public static int max(int[] array) {
        //find the max value here - найдите максимальное значение в этом методе
        int max = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] >= array[i + 1]) {
                max = array[i];
            } else {
                max = array[i + 1];
            }
        }
        return max;
    }
}
*/
public class Solution
{
    static int max;
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
        //initialize(create and fill) an array here - инициализируйте (создайте и заполните) массив тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list= new int[20];
        for(int i=0; i<list.length; i++)
        {
            String s=reader.readLine();
            list[i]=Integer.parseInt(s);
        }
        return list;
    }

    public static int max(int[] array) {
        //find the max value here - найдите максимальное значение в этом методе
        max = array[0];
        for(int i=1; i<array.length; i++)
        {
            if (array[i] > max)
                max = array[i];
        }

        return max;
    }
}