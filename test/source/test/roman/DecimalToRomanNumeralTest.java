package test.roman;

import dssc.roman.RomanNumeral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecimalToRomanNumeralTest {

    public DecimalToRomanNumeralTest(){
    }

    private void check(int decimal, String expected) {
        RomanNumeral romanNumeral = new RomanNumeral(decimal);
        Assertions.assertEquals(expected, romanNumeral.fromDecimalToRoman());
    }

    @Test
    void zeroIsEmptyString() {
        check(0, "");
    }

    @Test
    void oneIsI() {
        check(1, "I");
    }

    @Test
    void twoIsII() {
        check(2, "II");
    }

    @Test
    void threeIsIII() {
        check(3, "III");
    }

    @Test
    void fourIsIV() {
        check(4, "IV");
    }

    @Test
    void fiveIsV() {
        check(5, "V");
    }

    @Test
    void sixIsVI() { check(6, "VI"); }

    @Test
    void nineIsIX() { check(9, "IX"); }

    @Test
    void elevenIsXI() { check(11, "XI"); }

    @Test
    void twentyfour() { check(24, "XXIV"); }

    @Test
    void fortyeightIsXLVIII() { check(48, "XLVIII"); }

    @Test
    void oneHundredTwentySevenIsCXXVII() { check(127, "CXXVII"); }

    @Test
    void fourHundredNinetyEightIsCDXCVIII() { check(498, "CDXCVIII"); }
}
