package test.level14.lesson06.home01;

/**
 * Created by zhenya on 11.03.2015.
 */
public class MoldovanHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 8;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + Country.MOLDOVA + " Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
