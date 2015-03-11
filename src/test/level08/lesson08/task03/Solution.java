package test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Сикайло", "Евгений");
        map.put("Петровский", "Игорь");
        map.put("Гановский", "Олег");
        map.put("Химач", "Сергей");
        map.put("Гирук", "Саша");
        map.put("Дацюк", "Вадим");
        map.put("Арбат", "Данила");
        map.put("Гуманюк", "Сергей");
        map.put("Нагиев", "Нагибатор");
        map.put("Олений", "Олень");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int num = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(name)) {
                num++;
            }
        }
        return num;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int num = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(familiya)) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Евгений"));
        System.out.println(getCountTheSameLastName(map, "Сикайло"));
    }
}
