package dssc.roman;

import java.util.HashMap;

public class RomanNumeral {

    private int decimal;

    public RomanNumeral(int decimal){
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        if (decimal == 0) {
            return "";
        } else if (decimal < 4 ) {
            return "I".repeat(decimal);
        } else if (decimal == 4) {
            return "I" + "V";
        } else {
            return "V";
        }
    }
}
