package com.javarush.test.level02.lesson08.task05;

/* Дублирование строки
Написать функцию, которая выводит переданную строку на экран три раза, каждый раз с новой строки.
*/
public class Solution
{
    public static void print3(String s)
    {
        //Напишите тут ваш код
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }

    public static void main(String[] args)
    {
        print3("test 3");
        /* ожидаемый вывод на экран
        test 3
        test 3
        test 3
         */
    }
}