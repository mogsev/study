package serializer;

import java.io.*;

/**
 * Created by zhenya on 05.02.2015.
 */

public class Serializer {

    //Serializable object
    static void store(Serializable o, File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(o);
        out.close();
    }

    //Deserializable object
    static Object load(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        return in.readObject();
    }

    //deap clone
    static Object deepclone(final Serializable o) throws IOException, ClassNotFoundException {
        final PipedOutputStream pipeout = new PipedOutputStream();
        PipedInputStream pipein = new PipedInputStream();
        Thread writer = new Thread() {
            public void run() {
                ObjectOutputStream out = null;
                try {
                    out = new ObjectOutputStream(pipeout);
                    out.writeObject(o);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                finally {
                    try {
                        out.close();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        };
        writer.start();
        ObjectInputStream in = new ObjectInputStream(pipein);
        return in.readObject();
    }
}