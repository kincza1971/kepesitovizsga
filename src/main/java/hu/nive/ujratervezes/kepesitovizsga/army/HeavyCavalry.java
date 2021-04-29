package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit{
    private boolean isFirstAttack = true;
    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (isFirstAttack) {
            this.isFirstAttack = false;
            return super.doDamage() * 3;
        } else return super.doDamage();
    }

    public boolean isFirstAttack() {
        return isFirstAttack;
    }
}
