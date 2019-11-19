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
        table.put(10, "X");
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
        return getRomanUnits();
    }

    private String getRomanUnits() {
        decimal %= 10;
        if (decimal < 4 ) {
            return "I".repeat(decimal);
        } else if (decimal == 4) {
            return "I" + "V";
        } else if (decimal < 9) {
            return "V" + "I".repeat(decimal % 5);
        } else {
            return "I" + "X";
        }
    }
}
