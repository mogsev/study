package test.level14.lesson06.home01;

/**
 * Created by zhenya on 11.03.2015.
 */
public class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 12;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + Country.BELARUS + " Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
