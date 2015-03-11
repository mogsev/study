package test.level09.lesson06.task02;

/* Исключение при работе со строками
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
String s = null;
String m = s.toLowerCase();
*/

public class Solution
{
    public static void main(String[] args) throws NullPointerException
    {
        //Напишите тут ваш код
        try {
            String s = null;
            String m = s.toLowerCase();
        }
        //Напишите тут ваш код
        catch (NullPointerException ex) {
            System.out.println("NullPointerException " + ex.getMessage());
        }
    }
}
