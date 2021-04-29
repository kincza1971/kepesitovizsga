package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit{
    private int attackCounter;
    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (isFirstAttack()) {
            attackCounter++;
            return super.doDamage() * 3;
        } else return super.doDamage();
    }

    public boolean isFirstAttack() {
        return attackCounter ==0;
    }
}
