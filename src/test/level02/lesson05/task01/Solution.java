package test.level02.lesson05.task01;

/* Не бейте меня!
Напиши программу, которая выводит на экран надпись «Не бейте меня!.. Я предам кого угодно!» 3 раза.
*/
public class Solution
{
    public static void main(String[] args)
    {
        //текст сливается в одну строку, должно быть три строки
        //исправь эту ошибку

        String s1 = "Не бейте меня!.. ";
        String s2 = "Я предам кого угодно!";

        for (int i = 0; i < 3; i++)
        {
            System.out.print(s1);
            System.out.println(s2);
        }
    }
}
