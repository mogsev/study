package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры Имя и два числа, вывести надпись:
name1 получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String sNum1 = reader.readLine();
        String sNum2 = reader.readLine();
        int num1 = Integer.parseInt(sNum1);
        int num2 = Integer.parseInt(sNum2);
        System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");
    }
}