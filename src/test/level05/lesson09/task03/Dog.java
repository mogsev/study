package test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //Напишите тут ваш код
    private String name;
    private int growth;
    private String color;

    Dog(String name) {
        this.name = name;
    }

    Dog(String name, int growth) {
        this.name = name;
        this.growth = growth;
    }

    Dog(String name, int growth, String color) {
        this.name = name;
        this.growth = growth;
        this.color = color;
    }
}
