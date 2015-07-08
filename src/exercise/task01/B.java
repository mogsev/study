package exercise.task01;

/**
 * Created by zhenya on 08.07.2015.
 */
public class B extends Main {
    String variable;

    public B(){
        System.out.println("variable value = " + variable);
    }

    protected void printVariable(){
        variable = "variable is initialized in B Class";
    }
}
