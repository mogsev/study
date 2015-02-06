package com.javarush.test.level02.lesson03.task03;

/* Мне так плохо!
Напиши программу, которая выводит на экран надпись: «Мне так плохо! Хочу, чтобы все умерли!».
*/
public class Solution
{
    public static void main(String[] args)
    {
        //исправьте ошибку в этом методе

        String s1 = "Мне так плохо!";
        String s2 = "Хочу, чтобы все умерли!";

        print(s1, s2);
    }

    private static void print(String s1, String s2)
    {
        System.out.println(s1 + " " + s2);
    }
}
