package test.level14.lesson06.home01;

/**
 * Created by zhenya on 11.03.2015.
 */
public class RussianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + Country.RUSSIA + " Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
