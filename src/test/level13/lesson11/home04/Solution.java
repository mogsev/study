package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;
/**
public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            ArrayList<String> list = new ArrayList<String>();
            while (true) {
                String str = reader.readLine();
                if (str.equals("exit")) {
                    break;
                } else {
                    list.add(str);
                }
            }
            FileWriter writer = new FileWriter(fileName);
            for (String st : list) {
                writer.write(st + "\n");
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(reader.readLine())));

        String next;
        do
        {
            next = reader.readLine();
            writer.write(next);

            if (!next.equals("exit"))
            {
                writer.newLine();
            }
            else break;
        }
        while (!next.equals("exit"));
        reader.close();
        writer.close();
    }
}
