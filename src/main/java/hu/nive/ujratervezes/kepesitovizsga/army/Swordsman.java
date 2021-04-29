package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean isFirstHit = true;
    public Swordsman(boolean hasArmor) {
        super(100,10, hasArmor);
    }

    @Override
    public void sufferDamage(int damage) {
        if (isFirstHit()) {
            this.isFirstHit = false;
        } else {
            super.sufferDamage(damage);
        }
    }

    public boolean isFirstHit() {
        return isFirstHit;
    }
}
