package test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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
        map.put("Арбат", "Вадим");
        map.put("Гуманюк", "Сергей");
        map.put("Нагиев", "Олег");
        map.put("Олений", "Игорь");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> entry : copy.entrySet()) {
            String name = entry.getValue();
            String lastName = entry.getKey();
            for (Map.Entry<String, String> entry2 : copy.entrySet()) {
                String name2 = entry2.getValue();
                String lastname2 = entry2.getKey();
                if (!(lastName.equals(lastname2)) && name.equals(name2) ) {
                    removeItemFromMapByValue(map, name);
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }
}
