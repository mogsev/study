package com.javarush.test.level10.lesson11.home08;

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //Напишите тут ваш код
        ArrayList<String> result[] = new ArrayList[3];
        result[0] = new ArrayList<String>();
        result[0].add("dfgsdfg sfdg sdfg sdfgs dfg sdfg");
        result[1] = new ArrayList<String>();
        result[1].add("qwqwqrtyrtyryui yuioyuio");
        result[2] = new ArrayList<String>();
        result[2].add("vbnvbn uikhuiy 123");
        return result;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}