package test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        int num4 = Integer.parseInt(reader.readLine());
        if (num1 >= num2 && num1 >= num3 && num1 >= num4) {
            System.out.println(num1);
        } else if (num2 >= num1 && num2 >= num3 && num2 >= num4) {
            System.out.println(num2);
        } else if (num3 >= num1 && num3 >= num2 && num3 >= num4) {
            System.out.println(num3);
        } else {
            System.out.println(num4);
        }
    }
}
