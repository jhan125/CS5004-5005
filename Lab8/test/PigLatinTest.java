/**
 * Lab 8
 * Name: Jiali Han
 */

import org.junit.Assert;
import org.junit.Test;
public class PigLatinTest {
    PigLatin p = new PigLatin();

    /**
     * Test pigLatinConvert method to verify
     * word with first vowel letter can be converted correctly.
     */
    @Test
    public void pigLatinTest1(){
        String input = "A";
        String expected = "AWAY";

        Assert.assertEquals(expected, p.pigLatinConvert(input));

        input = "ABOUT";
        expected = "ABOUTWAY";

        Assert.assertEquals(expected, p.pigLatinConvert(input));
    }

    /**
     * Test pigLatinConvert method to verify
     * word with first consonant letter can be converted correctly.
     */
    @Test
    public void pigLatinTest2() {
        String input = "MAKING";
        String expected = "AKINGMAY";

        Assert.assertEquals(expected, p.pigLatinConvert(input));

        input = "PIG";
        expected = "IGPAY";

        Assert.assertEquals(expected, p.pigLatinConvert(input));
    }

    /**
     * Test getPigLatin method to verify
     * words with both first consonant letters and vowel letters
     * can be converted correctly.
     */
    @Test
    public void pigLatinTest3(){
        String input = "MAKING A PIG DEAL ABOUT PIG LATIN";
        String expected = "AKINGMAY AWAY IGPAY EALDAY ABOUTWAY IGPAY ATINLAY";

        Assert.assertEquals(expected, p.getPigLatin(input));
    }
}
