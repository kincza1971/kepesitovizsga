package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {
    List<MilitaryUnit> units = new ArrayList<>();

    public void addUnit(MilitaryUnit unit) {
        units.add(unit);
    }

    public void damageAll(int damage) {
        Iterator<MilitaryUnit> it = units.iterator();
        while (it.hasNext()) {
            hitAndRemoveIfHpLow(damage, it);
        }
    }

    private void hitAndRemoveIfHpLow(int damage, Iterator<MilitaryUnit> it) {
        MilitaryUnit unit;
        unit= it.next();
        unit.sufferDamage(damage);
        if (unit.getHitPoints()<25) {
            it.remove();
        }
    }

    public int getArmyDamage() {
        int sumDamage = 0;
        for (MilitaryUnit unit : units) {
            sumDamage += unit.doDamage();
        }
        return sumDamage;
    }

    public int getArmySize() {
        return units.size();
    }
}

//Sereg (Collections feladat, 20 pont, tesztosztály: ArmyTest)
//A hadseregnek az alábbi metódusai vannak:
//
//addUnit(MilitaryUnit militaryUnit), amivel egy katonai egységet tudunk hozzáadni a sereghez,
//
//damageAll(int damage), ami a sereg minden egységének életerejéből levonja a paraméterül kapott értéket,
// valamint eltávolítja a seregből azokat az egységeket, melyeknek így 25 pont alá csökkent az életerejük (azaz harcképtelenek vagy halottak),
//
//getArmyDamage(), ami visszaadja, hogy az aktuális támadással mennyi sebzést okoz a sereg összesen,
//
//getArmySize(), ami visszaadja, hogy hány egységből áll a sereg.
