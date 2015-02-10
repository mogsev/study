package io.readandwrite;

import java.io.*;

/**
 * Created by zhenya on 10.02.2015.
 */
public class ReadWriteFile {
    public static void main(String[] args) {
        File fileRead = new File("d:/temp/test/test.txt");
        File fileWrite = new File("d:/temp/test/test2.txt");

        try {
            InputStream inputStream = new FileInputStream(fileRead);
            while (true) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
