package test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //Напишите тут ваш код
        /*for (int i = 0; i < 40; i++) {
            System.out.println(s.substring(i, s.length()));
        }*/
        //Напишите тут ваш код
        /*char[] ch = s.toCharArray();
        for (int i = 0; i < 40; i++) {
            for (int next = i; next < ch.length; next++) {
                System.out.print(ch[next]);
            }
            System.out.println();
        }*/
        //Напишите тут ваш код
        char[] n = s.toCharArray();

        for (int f = 0; f < 40; f++) {
            for (int i = f; i < n.length; i++) {
                System.out.print(n[i]);
            }
            System.out.println();
        }
    }
}

