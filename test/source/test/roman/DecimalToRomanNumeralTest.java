package test.roman;

import dssc.roman.RomanNumeral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DecimalToRomanNumeralTest {

    public DecimalToRomanNumeralTest(){
    }

    @Test
    void zeroIsEmptyString() {
        RomanNumeral romanNumeral = new RomanNumeral(0);
        Assertions.assertEquals("", romanNumeral.toString());
    }

    @Test
    void oneIsI() {
        RomanNumeral romanNumeral = new RomanNumeral(1);
        Assertions.assertEquals("I", romanNumeral.toString());
    }



}
