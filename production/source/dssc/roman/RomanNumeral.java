package dssc.roman;

import java.util.HashMap;

public class RomanNumeral {

    private HashMap<Integer, String> conversionTable = getConversionTable();

    public HashMap<Integer, String> getConversionTable() {
        HashMap<Integer, String> table = new HashMap<>();
        table.put(1, "I");
        table.put(5, "V");
        table.put(10, "X");
        return table;
    }

    public String fromArabicToRoman(int number) {
        if (number == 0) {
            return "";
        } else {
            return writeRomanNumeral(number);
        }
    }

    public String writeRomanNumeral(int number) {
        if (foundInConversionTable(number)) {
            return conversionTable.get(number);
        } else
            return decomposeAndWriteNumber(number);
    }

    public boolean foundInConversionTable(int number) {
        return conversionTable.containsKey(number);
    }

    private String decomposeAndWriteNumber(int number) {
        return getRomanTens(number) + getRomanUnits(number);
    }

    private String getRomanTens(int number) {
        number = (number % 100) - (number % 10) ;
        if (foundInConversionTable(number))
            return conversionTable.get(number);
        else
            return "X".repeat(number);
    }

    private String getRomanUnits(int number) {
        number %= 10;
        if (number % 5 == 4) {
            return "I" + fiveOrTen(number);
        } else {
            return Five(number) + Ones(number);
        }
    }

    private String fiveOrTen(int number) {
        return conversionTable.get(number + 1);
    }

    private String Ones(int number) {
        return "I".repeat(number % 5);
    }

    private String Five(int number) {
        if (number >= 5) return "V";
        else return "";
    }
}
