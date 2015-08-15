package exercise.task02;

import java.util.ArrayList;

/**
 * Created by zhenya on 15.08.2015.
 * Задача
 * Дано N прямоугольников со сторонами, паралельными осям кординат.
 * Требуется определить площадь фигуры, образованной объединением данных прямоугольников.
 */
public class Square {

    public static void main(String args[]) {
        System.out.println("Begin");
        int sq1[] = {1, 1, 7, 7};
        int sq2[] = {1, 0, 2, 5};
        int sq3[] = {4, 1, 8, 3};
        int sq4[] = {4, 4, 6, 6};
        int sq5[] = {0, 2, 6, 6};
        int sq6[] = {10, 2, 13, 5};
        int sq7[] = {6, 6, 8, 8};
        int sq8[] = {7, 7, 9, 9};
        int sq9[] = {8, 6, 10, 8};
        int sq10[] = {9, 5, 11, 7};

        ArrayList<int[]> list = new ArrayList<>();

        list.add(sq1);
        list.add(sq2);
        list.add(sq3);
        list.add(sq4);
        list.add(sq5);
        list.add(sq6);
        list.add(sq7);
        list.add(sq8);
        list.add(sq9);
        list.add(sq10);

        int x = 0, y = 0;
        for (int sq[] : list) {
            x = max(x, sq[2]);
            y = max(y, sq[3]);
        }

        int square[][] = new int[y][x];
        System.out.println("******************************");
        for (int i = 0; i < y; i++) {
            for (int n = 0; n < x; n++) {
                System.out.print(square[i][n]);
            }
            System.out.println();
        }
        System.out.println("******************************");

        for (int sq[] : list) {
            for (int x1 = sq[1]; x1 < sq[3]; x1++ ) {
                for (int y1 = sq[0]; y1 < sq[2]; y1++) {
                    square[x1][y1] = 1;
                }
            }
        }

        print(square, y, x);

        printSquare(square, y, x);

        System.out.println("End");
    }

    private static void printSquare(int[][] square, int x, int y) {
        int m = 0;
        for (int i = 0; i < x; i++) {
            for (int n = 0; n < y; n++) {
                if (square[i][n] == 1) {
                    m = m + 1;
                }
            }
        }
        System.out.println(m);
    }

    private static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    private static int min(int x, int y) {
        return (x < y) ? x : y;
    }

    private static void print(int sq[][], int x, int y) {
        System.out.println("******************************");
        for (int i = 0; i < x; i++) {
            for (int n = 0; n < y; n++) {
                System.out.print(sq[i][n]);
            }
            System.out.println();
        }
        System.out.println("******************************");
    }
}
