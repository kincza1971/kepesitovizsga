package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public int addDigits(String input) {
        if (input == null || input.isBlank()) {
            return -1;
        }
        int summa =0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                summa += Character.getNumericValue(c);
            }
        }
        return summa;
    }
}

//Hozd létre az AddDigits osztályt, és annak az addDigits(String input) metódusát.
//
//A metódus feladata, hogy a paraméterben kapott Stringben található összes számjegyet adja össze, és ennek
// az összegét adja vissza. Ha a bemeneti String üres, vagy null, adjon vissza -1 értéket.