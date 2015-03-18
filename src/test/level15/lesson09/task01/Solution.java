package test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.000, "One");
        labels.put(2.000, "Two");
        labels.put(3.000, "Three");
        labels.put(4.000, "Four");
        labels.put(5.000, "Five");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
