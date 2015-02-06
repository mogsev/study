package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    //Напишите тут ваш код
    private String name;
    private int age;
    private String gender;

    Friend(String name) {
        this.name = name;
    }

    Friend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Friend(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}