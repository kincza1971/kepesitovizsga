package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    private int hitPoints;
    private int attackDamage;
    private boolean hasArmor;

    protected MilitaryUnit(int hitPoints, int attackDamage, boolean hasArmor) {
        this.hitPoints = hitPoints;
        this.attackDamage = attackDamage;
        this.hasArmor = hasArmor;
    }

    public int getHitPoints() {
        return hitPoints;
    }


    public boolean isHasArmor() {
        return hasArmor;
    }
    
    public int doDamage() {
        return attackDamage;
    }
    
    public void sufferDamage(int damage) {
        if (isHasArmor()) {
            hitPoints = hitPoints > damage/2 ? getHitPoints() - damage/2 : 0;
        } else{
            hitPoints = hitPoints > damage ? getHitPoints() - damage : 0;
        }
    }
}

