package dssc.roman;

import java.util.HashMap;

public class RomanNumeral {

    private int decimal;

    public RomanNumeral(int decimal) {
        this.decimal = decimal;
    }

    private HashMap<Integer, String> conversionTable = fillConversionTable();

    private HashMap<Integer, String> fillConversionTable() {
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

    public String fromDecimalToRoman() {
        if (decimal == 0) {
            return "";
        } else {
            return writeRomanNumeral();
        }
    }

    public String writeRomanNumeral() {
        if (decimalFoundInConversionTable(decimal)) {
            return conversionTable.get(decimal);
        } else
            return decomposeDecimalAndWriteRomanNumeral();
    }

    public boolean decimalFoundInConversionTable(int number) {
        return conversionTable.containsKey(number);
    }

    private String decomposeDecimalAndWriteRomanNumeral() {
        return getRomanHundreds() + getRomanTens() + getRomanUnits();
    }

    private String getRomanHundreds() {
        int hundreds = (decimal % 1000) - (decimal % 100);
        int powerOfTen = 2;
        if (decimalFoundInConversionTable(hundreds))
            return conversionTable.get(hundreds);
        else
            return twoCases(hundreds, powerOfTen);
    }

    private String getRomanTens() {
        int tens = (decimal % 100) - (decimal % 10) ;
        int powerOfTen = 1;
        if (decimalFoundInConversionTable(tens))
            return conversionTable.get(tens);
        else
            return twoCases(tens, powerOfTen);
    }

    private String getRomanUnits() {
        int units = decimal % 10;
        int powerOfTen = 0;
        if (decimalFoundInConversionTable(units))
            return conversionTable.get(units);
        else
            return twoCases(units, powerOfTen);
    }

    private String twoCases(int number, int power) {
        if (equalsNextSymbolMinusOnePower(number, power)) {
            return nextSymbolMinusOnePower(number, power);
        } else {
            return fiveTimesPowerOfTen(number, power) + remainingPowersOfTen(number, power);
        }
    }

    private String nextSymbolMinusOnePower(int number, int power) {
        return oneRomanPower(power) + nextRomanSymbol(number, power);
    }

    private boolean equalsNextSymbolMinusOnePower(int number, int powerOfTen) {
        return number % (5*tenToThe(powerOfTen)) == 4*tenToThe(powerOfTen);
    }

    private String oneRomanPower(int power) {
        return conversionTable.get(tenToThe(power));
    }

    private String nextRomanSymbol(int number, int power) {
        return conversionTable.get(number + tenToThe(power));
    }

    private String remainingPowersOfTen(int number, int power) {
        return oneRomanPower(power).repeat((number % (5*tenToThe(power))) / tenToThe(power));
    }

    private String fiveTimesPowerOfTen(int number, int power) {
        if (number >= 5*(tenToThe(power)))
            return conversionTable.get(5*tenToThe(power));
        else return "";
    }

    private int tenToThe(int power) {
        return (int) Math.pow(10, power);
    }
}
