/**
 * Name: Jiali Han
 * Lab 01
 * This is a class PaycheckTest to test methods in class Paycheck.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaycheckTest {
  private Paycheck abc_paycheck;
  private Paycheck abc_paycheck2;
  @Before
  public void setUp() {
    this.abc_paycheck = new Paycheck(10.0, 1.0);
    this.abc_paycheck2 = new Paycheck(10.0, 50.0);
  }
  @Test
  public void testGetTotalPay() {
    // Test case1: when the employee has 40 or less working hours
    Assert.assertEquals(10.0, abc_paycheck.getTotalPay(), 0.001);
    // Test case2: when the employee has more than 40 working hours
    Assert.assertEquals(550.0, abc_paycheck2.getTotalPay(), 0.001);
  }

  @Test
  public void testGetPayAfterTaxes() {
    // Test case1: when totalPay is less than 400, deduct 10% of the total payment to obtain "payment after taxes"
    Assert.assertEquals(9.0, abc_paycheck.getPayAfterTaxes(), 0.001);
    // Test case2: when totalPay is 400 or more, deduct 15% of the total payment to obtain "payment after taxes"
    Assert.assertEquals(467.5, abc_paycheck2.getPayAfterTaxes(), 0.001);
  }

  @Test
  public void testToString() {
    String actual1 = abc_paycheck.toString();
    String expected1 = "Payment after taxes: $ 9.000000";
    Assert.assertEquals("Message Error", expected1, actual1);

    String actual2 = abc_paycheck2.toString();
    String expected2 = "Payment after taxes: $ 467.500000";
    Assert.assertEquals("Message Error", expected2, actual2);
  }
}