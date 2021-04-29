package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean isShieldUnused = true;
    public Swordsman(boolean hasArmor) {
        super(100,10, hasArmor);
    }

    @Override
    public void sufferDamage(int damage) {
        if (isFirstHit()) {
            this.isShieldUnused = false;
        } else {
            super.sufferDamage(damage);
        }
    }

    public boolean isFirstHit() {
        return isShieldUnused;
    }
}
