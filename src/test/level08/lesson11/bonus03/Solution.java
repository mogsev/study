package test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //Напишите тут ваш код
        for (int i = 0; i < array.length - 1; i++) {
            for (int next = 0; next < array.length - 1 - i; next++) {
                if (isGreaterThen(array[next], array[next + 1])) {
                    String str = array[next];
                    array[next] = array[next + 1];
                    array[next + 1] = str;
                }
            }
            if (isGreaterThen(array[i], array[i + 1])) {
                String str = array[i];
                array[i] = array[i + 1];
                array[i + 1] = str;
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
