package test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

import java.lang.reflect.Array;

public class Solution
{
    public static void main(String[] args)
    {
        //Напишите тут ваш код
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 1; i <= 10; i++) {
            for (int n = 0; n < nums.length; n++) {
                System.out.print(i*nums[n] + " ");
            }
            System.out.println();
        }
    }
}