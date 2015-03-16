package test.level14.lesson08.home05;

/**
 * Created by zhenya on 16.03.2015.
 */
public class Computer {
    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }

    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Computer() {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
    }
}
