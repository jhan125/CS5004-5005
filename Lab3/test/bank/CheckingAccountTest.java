// Jiali Han
// Lab3: Interfaces & Abstract Classes
// Assignment: Bank Account

package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is a class that test all methods in class CheckingAccount.
 */
class CheckingAccountTest {
    private CheckingAccount c1;

    @BeforeEach
    public void setUp() {
        c1 = new CheckingAccount(100.0);
    }

    @Test
    public void testIllegalConstructor() {
        // starter amount can't be negative or less than 1 cent
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> new CheckingAccount(-100.0), "Expected to throw IllegalArgumentException, but it didn't.");
        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> new CheckingAccount(0.001), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void getBalance() {
        Assertions.assertEquals(100.0, c1.getBalance(), 0.001);
    }

    @Test
    public void testIllegalDeposit() {
        // deposit amount can't be negative or less than 1 cent
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> c1.deposit(-100.0), "Expected to throw IllegalArgumentException, but it didn't.");
        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> c1.deposit(0.001), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void testDeposit() {
        c1.deposit(100.0);
        Assertions.assertEquals(200.0, c1.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // current balance is 200.0, so withdraw amount can't be more than balance
        Assertions.assertFalse(c1.withdraw(500.0));
        // withdraw amount can't be negative or less than 1 cent
        Assertions.assertFalse(c1.withdraw(-100.0));
        Assertions.assertFalse(c1.withdraw(0.001));
        // withdraw amount can be 100.0
        Assertions.assertTrue(c1.withdraw(100.0));

    }

    @Test
    public void testToString() {
        Assertions.assertEquals("Account Balance: $100.00", c1.toString());
    }

    @Test
    public void testMaintenance() {
        // test case 1: when there's no penalty
        // current balance = 100.0
        c1.performMonthlyMaintenance();
        Assertions.assertEquals(100.0, c1.getBalance(), 0.001);

        // test case 2: when there's penalty
        // after withdraw, current balance = 50.0
        c1.withdraw(50.0);
        c1.performMonthlyMaintenance();
        // charge penalty fee
        Assertions.assertEquals(45.0, c1.getBalance(), 0.001);

        // test case 3: when there's no penalty
        // after deposit, current balance = 145.0
        c1.deposit(100.0);
        // no penalty fee charged
        Assertions.assertEquals(145.0, c1.getBalance(), 0.001);
        // after withdraw, current balance = 45.0
        c1.withdraw(100.0);
        // charge penalty fee
        c1.performMonthlyMaintenance();
        Assertions.assertEquals(40.0, c1.getBalance(), 0.001);
    }
}