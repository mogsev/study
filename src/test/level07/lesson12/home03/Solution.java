package test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/
/**
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum;
        int  minimum;

        //Напишите тут ваш код
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(reader.readLine());
            nums[i] = num;
        }
        if (nums[0] > nums[1]) {
            maximum = nums[0];
            minimum = nums[1];
        } else {
            maximum = nums[1];
            minimum = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > maximum) {
                maximum = nums[i];
            }
            if (nums[i] < minimum) {
                minimum = nums[i];
            }
        }
        System.out.println(maximum);
        System.out.println(minimum);
    }
}
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int  maximum;
        int  minimum;
        int[] mas= new int[20];
        for (int i=0;i<mas.length;i++)mas[i]=Integer.parseInt(reader.readLine());
        maximum=mas[0];
        minimum=mas[0];
        for (int i=1;i<mas.length;i++){
            if (mas[i]>=maximum)maximum=mas[i];
            if (mas[i]<=minimum)minimum=mas[i];
        }
        System.out.println(maximum);
        System.out.println(minimum);
    }
}

