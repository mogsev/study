package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name;
        private String lastName;
        private boolean sex;
        private int age;
        private int weight;
        private String address;

        Human(String name) {
            this.name = name;
        }

        Human(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        Human(String name, String lastName, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
        }

        Human(String name, String lastName, boolean sex, int age) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, String lastName, boolean sex, int age, int weight) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
        }

        Human(String name, String lastName, boolean sex, int age, int weight, String address) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.address = address;
        }

        Human(Human human) {
            this.name = human.name;
            this.lastName = human.lastName;
            this.sex = human.sex;
            this.age = human.age;
            this.weight = human.weight;
            this.address = human.address;
        }

        Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        Human (String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        Human (String name, String lastName, String address) {
            this.name = name;
            this.lastName = lastName;
            this.address = address;
        }
    }
}
