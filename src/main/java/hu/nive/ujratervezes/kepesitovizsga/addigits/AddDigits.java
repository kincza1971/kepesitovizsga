package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public int addDigits(String input) {
        if (input == null || input.isBlank()) {
            return -1;
        }
        int sum =0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }
}
