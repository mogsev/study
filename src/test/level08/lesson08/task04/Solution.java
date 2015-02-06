package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Арнольд", new Date("JUNE 2 1981"));
        map.put("Кличко", new Date("JANUARY 3 1982"));
        map.put("Мандарин", new Date("MAY 4 1983"));
        map.put("Апельсин", new Date("SEPTEMBER 1 1984"));
        map.put("Заяц", new Date("JUNE 1 1985"));
        map.put("Свинтус", new Date("DECEMBER 1 1986"));
        map.put("Слон", new Date("OCTOBER 1 1987"));
        map.put("Кот", new Date("NOVEMBER 1 1988"));
        map.put("Пес", new Date("AUGUST 1 1989"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> entry = iterator.next();
            int month = entry.getValue().getMonth();
            if (month == 5 || month == 6 || month == 7) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        removeAllSummerPeople(createMap());
    }
}
