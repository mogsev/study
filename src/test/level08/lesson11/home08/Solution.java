package test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        //Напишите тут ваш код
        for (int i = 0; i < array.length - 1; i++) {
            for (int next = 0; next < array.length - 1 - i; next++) {
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
