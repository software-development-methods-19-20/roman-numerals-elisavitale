package dssc.roman;

import java.util.HashMap;

public class RomanNumeral {

    private int decimal;
    private static HashMap<Integer, String> conversionTable = fillConversionTable();
    private int[] powersOfTen = {0, 1, 2, 3};   // 0 -> units, 1 -> tens, 2 -> hundreds, 3 -> thousands

    private static HashMap<Integer, String> fillConversionTable() {
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

    public RomanNumeral(int decimal) {
        this.decimal = decimal;
    }

    public String fromDecimalToRoman() {
        if (decimal == 0) {
            return "";
        } else {
            return writeRomanNumeral();
        }
    }

    private String writeRomanNumeral() {
        return allPowersToRoman(splitDecimalInPowersOfTen());
    }

    private int[] splitDecimalInPowersOfTen() {
        int[] allNumbers = new int[4];
        for (int power : powersOfTen) {
            allNumbers[power] = extractPowersOfTen(power);
        }
        return allNumbers;
    }

    private int extractPowersOfTen(int power) {
        return (decimal % tenToThe(power + 1)) - (decimal % tenToThe(power));
    }

    private int tenToThe(int power) {
        return (int) Math.pow(10, power);
    }

    private String allPowersToRoman(int[] allPowers) {
        String romanString = "";
        for (int power : powersOfTen) {
            romanString = decimalPowersToRoman(allPowers[power], power) + romanString;
        }
        return romanString;
    }

    private String decimalPowersToRoman(int decimalToBeConverted, int power) {
        if (foundInConversionTable(decimalToBeConverted))
            return conversionTable.get(decimalToBeConverted);
        else
            return twoPossibleCases(decimalToBeConverted, power);
    }

    private boolean foundInConversionTable(int number) {
        return conversionTable.containsKey(number);
    }

    private String twoPossibleCases(int number, int power) {
        if (equalsNextRomanSymbolMinusOnePower(number, power)) {
            return nextRomanSymbolMinusOnePower(number, power);
        } else {
            return fiveFiftyOrFiveHundred(number, power) + repeatedPowersOfTen(number, power);
        }
    }

    private boolean equalsNextRomanSymbolMinusOnePower(int number, int powerOfTen) {
        return number % (5 * tenToThe(powerOfTen)) == 4 * tenToThe(powerOfTen);
    }

    private String nextRomanSymbolMinusOnePower(int number, int power) {
        return oneRomanPower(power) + nextRomanSymbol(number, power);
    }

    private String oneRomanPower(int power) {
        return conversionTable.get(tenToThe(power));
    }

    private String nextRomanSymbol(int number, int power) {
        return conversionTable.get(number + tenToThe(power));
    }

    private String fiveFiftyOrFiveHundred(int number, int power) {
        if (number >= 5 * (tenToThe(power)))
            return conversionTable.get(5 * tenToThe(power));
        else return "";
    }

    private String repeatedPowersOfTen(int number, int power) {
        int times = (number % (5 * tenToThe(power))) / tenToThe(power);
        return oneRomanPower(power).repeat(times);
    }
}
