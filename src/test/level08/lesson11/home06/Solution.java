package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human children1 = new Human("дочь Катя", false, 4);
        Human children2 = new Human("сын Васька", true, 6);
        Human children3 = new Human("дочь Катя", false, 8);
        Human father = new Human("папа Вова", true, 40, children1, children2, children3);
        Human mother = new Human("мама Настя", false, 35, children1, children2, children3);
        Human grandFather1 = new Human("дед Василий", true, 74, father);
        Human grandFather2 = new Human("дед Петя", true, 64, mother);
        Human grandMother1 = new Human("бабушка Аня", false, 60, father);
        Human grandMother2 = new Human("бабушка Катя", false, 62, mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
    }

    public static class Human
    {
        //Написать тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children = new ArrayList<Human>();

        Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, Human ... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (children.length > 0) {
                for (int i = 0; i < children.length; i++) {
                    this.children.add(children[i]);
                }
            }
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }
            return text;
        }
    }

}
