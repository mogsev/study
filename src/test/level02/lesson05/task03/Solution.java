package com.javarush.test.level02.lesson05.task03;

/* Я больше не хочу жить на этой планете.
Напиши программу, которая выводит на экран надпись «Я больше не хочу жить на этой планете.» 20 раз.
*/
public class Solution
{
    public static void main(String[] args)
    {
        //заполните пустые строки words[3-7], чтобы программа вывела правильный текст
        String[] words = new String[8];
        words[0] = "Я";
        words[1] = "больше";
        words[2] = "не";
        words[3] = "хочу";
        words[4] = "жить";
        words[5] = "на";
        words[6] = "этой";
        words[7] = "планете.";

        //Передаем объект, на который ссылается words, в метод print20Times
        //Там на него будет ссылаться другая переменная - array
        print20Times(words);
    }

    private static void print20Times(String[] array) {  // array и words ссылаются на один объект в памяти
        for (int i = 0; i < 20; i++)    //нужно вывести 20 строк, поэтому напишем цикл от 0 до 20
        {
            for (int j = 0; j < array.length; j++) //для каждого слова, которое есть в array
            {
                System.out.print(array[j] + " ");  //выводим одно слово, потом добавляем пробел
            }
            System.out.println(); //переходим на новую строку, чтобы текст не сливался
        }
    }
}
