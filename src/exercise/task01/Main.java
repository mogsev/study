package exercise.task01;

/**
 * Created by zhenya on 08.07.2015.
 */
public class Main {
    String variable;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        B b = new B();
    }

    public Main(){
        printVariable();
    }

    protected void printVariable(){
        variable = "variable is initialized in Main Class";
    }
}
