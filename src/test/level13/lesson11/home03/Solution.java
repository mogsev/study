package test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            fileName = reader.readLine();
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNext()) {
                System.out.println(scan.next());
            }
           }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
