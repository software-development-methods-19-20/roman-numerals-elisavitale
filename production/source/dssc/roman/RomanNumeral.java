package dssc.roman;

import java.util.HashMap;

public class RomanNumeral {

    private int decimal;

    public RomanNumeral(int decimal){
        this.decimal = decimal;
    }

    private HashMap<Integer, String> conversionTable = getConversionTable();

    public static HashMap<Integer, String> getConversionTable() {
        HashMap<Integer, String> table = new HashMap<>();
        table.put(1, "I");
        table.put(5, "V");
        return table;
    }

    public String fromArabicToRomanNumber() {
        if (decimal == 0) {
            return "";
        } else {
            return writeRomanNumeral();
        }
    }

    public String writeRomanNumeral() {
        if (decimalInConversionTable()) {
            return conversionTable.get(decimal);
        } else
            return decomposeAndWriteNumber();
    }

    public boolean decimalInConversionTable() {
        return conversionTable.containsKey(decimal);
    }

    private String decomposeAndWriteNumber() {
        if (decimal < 4 ) {
            return "I".repeat(decimal);
        } else if (decimal == 4) {
            return "I" + "V";
        } else {
            return "V" + "I".repeat(decimal % 5);
        }
    }
}
