package test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String str = null;
        boolean isExit = true;
        while(isExit) {
            str = reader.readLine();
            if(str.equals("сумма")) {
                isExit = false;
            } else {
                sum += Integer.parseInt(str);
            }
        }
        System.out.println(sum);
    }
}
