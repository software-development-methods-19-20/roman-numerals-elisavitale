package dssc.roman;

import java.util.HashMap;

public class RomanNumeral {

    private HashMap<Integer, String> conversionTable = getConversionTable();

    public HashMap<Integer, String> getConversionTable() {
        HashMap<Integer, String> table = new HashMap<>();
        table.put(1, "I");
        table.put(5, "V");
        table.put(10, "X");
        table.put(50, "L");
        table.put(100, "C");
        table.put(500, "D");
        table.put(1000, "M");
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
        else if (number % 50 == 40)
            return "X" + fiftyOrHundred(number);
        else return Fifty(number) + Tens(number);
    }

    private String fiftyOrHundred(int number) {
        return conversionTable.get(number + 10);
    }

    public String Fifty(int number) {
        if (number >= 50) return "L";
        else return "";
    }

    public String Tens(int number) {
        return "X".repeat((number % 50) / 10);
    }

    private String getRomanUnits(int number) {
        number %= 10;
        int powerOfTen = 0;
        if (equalsNextSymbolMinusOnePower(number, powerOfTen)) {
            return onePower(powerOfTen) + nextSymbol(number, powerOfTen);
        } else {
            return Five(number, powerOfTen) + Ones(number, powerOfTen);
        }
    }

    private boolean equalsNextSymbolMinusOnePower(int number, int powerOfTen) {
        return number % (5*Math.pow(10, powerOfTen)) == 4*Math.pow(10, powerOfTen);
    }

    private String onePower(int powerOfTen) {
        return conversionTable.get((int) Math.pow(10, powerOfTen));
    }

    private String nextSymbol(int number, int powerOfTen) {
        return conversionTable.get(number + ((int) Math.pow(10, powerOfTen)));
    }

    private String Ones(int number, int powerOfTen) {
        return conversionTable.get((int) Math.pow(10, powerOfTen)).repeat(number % 5);
    }

    private String Five(int number, int powerOfTen) {
        if (number >= 5*((int) Math.pow(10, powerOfTen)))
            return conversionTable.get(5*((int) Math.pow(10, powerOfTen)));
        else return "";
    }

    private int tenToThe(int power) {
        return (int) Math.pow(10, power);
    }
}
