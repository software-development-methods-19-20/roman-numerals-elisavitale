package test.roman;

import dssc.roman.RomanNumeral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DecimalToRomanNumeralTest {

    public DecimalToRomanNumeralTest(){
    }

    private void check(int decimal, String expected) {
        RomanNumeral romanNumeral = new RomanNumeral(decimal);
        Assertions.assertEquals(expected, romanNumeral.toString());
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
    void fiveIsV() {
        check(5, "V");
    }

}
