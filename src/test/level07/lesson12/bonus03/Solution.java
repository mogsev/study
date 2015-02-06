package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //Напишите тут ваш код
        for (int i = 0; i < array.length - 1; i++)
        {
            //System.out.println("i = " + i + ": " + Arrays.toString(array));
            for (int next = 0; next < array.length - 1 - i; next++) {
                //System.out.println("next = " + next + ": " + Arrays.toString(array));
                if (array[next] < array[next + 1]) {
                    int num = array[next];
                    array[next] = array[next + 1];
                    array[next + 1] = num;
                }
            }
            if (array[i] < array[i + 1]) {
                int num = array[i];
                array[i] = array[i + 1];
                array[i + 1] = num;
            }
        }
    }
}