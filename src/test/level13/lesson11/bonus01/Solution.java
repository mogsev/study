package test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listNumber = new ArrayList<Integer>();
        String fileName;
        try {
            fileName = reader.readLine();
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNext()) {
                int num = Integer.parseInt(scan.next());
                if (num % 2 == 0) {
                    listNumber.add(num);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < listNumber.size() - 1; i++) {
            for (int next = 0; next < listNumber.size() - 1; next++) {
                if (listNumber.get(next) > listNumber.get(next + 1)) {
                    Integer num = listNumber.get(next);
                    listNumber.set(next, listNumber.get(next + 1));
                    listNumber.set(next + 1, num);
                }
            }
            if (listNumber.get(i) > listNumber.get(i + 1)) {
                Integer num = listNumber.get(i);
                listNumber.set(i, listNumber.get(i + 1));
                listNumber.set(i + 1, num);
            }
        }
        for (Integer num : listNumber) {
            System.out.println(num);
        }
    }
}
