// Jiali Han
// Lab3: Interfaces & Abstract Classes
// Assignment: Bank Account

package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a class that test all methods in class SavingsAccount.
 */
class SavingsAccountTest {
    private SavingsAccount s1;
    @BeforeEach
    public void setUp() {
        s1 = new SavingsAccount(100.0);
    }

    @Test
    public void testIllegalConstructor() {
        // starter amount can't be negative or less than 1 cent
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> new SavingsAccount(-100.0), "Expected to throw IllegalArgumentException, but it didn't.");
        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> new SavingsAccount(0.001), "Expected to throw IllegalArgumentException, but it didn't.");
    }

    @Test
    public void getBalance() {
        Assertions.assertEquals(100.0, s1.getBalance(), 0.001);
    }

    @Test
    public void testIllegalDeposit() {
        // deposit amount can't be negative or less than 1 cent
        Exception exception1 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> s1.deposit(-100.0), "Expected to throw IllegalArgumentException, but it didn't.");
        Exception exception2 = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> s1.deposit(0.001), "Expected to throw IllegalArgumentException, but it didn't.");
    }
    @Test
    public void testDeposit() {
        s1.deposit(100.0);
        Assertions.assertEquals(200.0, s1.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // current balance is 200.0, so withdraw amount can't be more than balance
        Assertions.assertFalse(s1.withdraw(500.0));
        // withdraw amount can't be negative or less than 1 cent
        Assertions.assertFalse(s1.withdraw(-100.0));
        Assertions.assertFalse(s1.withdraw(0.001));
        // withdraw amount can be 100.0
        Assertions.assertTrue(s1.withdraw(100.0));
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("Account Balance: $100.00", s1.toString());
    }

    @Test
    public void performMonthlyMaintenance() {
        // test case 1: when there's no penalty
        // current withdrawTransaction = 1
        s1.performMonthlyMaintenance();
        Assertions.assertEquals(100.0, s1.getBalance(), 0.001);

        // test case 2: when there's penalty
        // after 7 withdraws, current withdrawTransaction = 7
        for (int i = 0; i < 7; i++) {
            s1.withdraw(10.0);
        }

        // charge penalty fee
        s1.performMonthlyMaintenance();
        Assertions.assertEquals(16.00, s1.getBalance(), 0.001);
    }
}