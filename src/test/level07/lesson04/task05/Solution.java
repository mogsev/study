package test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        int[] bigNums = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < bigNums.length; i++) {
            bigNums[i] = Integer.parseInt(reader.readLine());
        }
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        for (int i = 0; i < bigNums.length; i++) {
            if (i < bigNums.length/2) {
                nums1[i] = bigNums[i];
            } else {
                nums2[i - bigNums.length/2] = bigNums[i];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            System.out.println(nums2[i]);
        }
    }
}
