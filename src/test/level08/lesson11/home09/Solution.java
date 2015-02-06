package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date)
    {
        boolean isEven = false;
        Date thisDate = new Date(date);
        Date year = new Date(thisDate.getYear());
        long beginYear = year.getTime();
        long endDate = thisDate.getTime();
        long days = (endDate - beginYear) / (24 * 60 * 60 * 1000);
        if (days % 2 != 0) {
            isEven = true;
        }
        return isEven;
    }
}
