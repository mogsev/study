package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
   /** public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        //напишите здесь ваш код
        int i = 0;
        int n = Integer.parseInt(reader.readLine());
        while(i < n) {
            maximum = Math.max(Integer.parseInt(reader.readLine()), maximum);
            i++;
        }
        System.out.println(maximum);
    }
    */
   public static void main(String[] args) throws Exception
   {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(reader.readLine());
       int buf = Integer.parseInt(reader.readLine());
       for (int i = 0; i < N - 1 ; i++) {
           int a = Integer.parseInt(reader.readLine());
           int max=Math.max(buf,a);
            buf = max;
        }
        int maximum = buf;
        System.out.println(maximum);
}

}
