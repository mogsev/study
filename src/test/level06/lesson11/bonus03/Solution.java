package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //Напишите тут ваш код
        int[] nums = new int[5];
        nums[0] = Integer.parseInt(reader.readLine());
        nums[1] = Integer.parseInt(reader.readLine());
        nums[2] = Integer.parseInt(reader.readLine());
        nums[3] = Integer.parseInt(reader.readLine());
        nums[4] = Integer.parseInt(reader.readLine());

        Arrays.sort(nums);
        for (int i = 0; i < 5; i++) {
            System.out.println(nums[i]);
        }
    }
}
