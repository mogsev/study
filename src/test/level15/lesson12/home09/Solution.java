package test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = str.substring(str.indexOf("?") + 1);
        String param[] = url.split("&");
        String obj = null;

        for (String s : param) {
            try {
                System.out.print(s.substring(0, s.indexOf("=")) + " ");
            } catch (Exception ex) {
                System.out.print(s + " ");
            }
            if (s.contains("obj")) {
                obj = s;
            }
        }
        System.out.println();
        if (!(obj == null)) {
            try {
                alert(Double.parseDouble(obj.substring(obj.indexOf("=") + 1)));
            } catch (Exception ex) {
                alert(obj.substring(obj.indexOf("=") + 1));
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
