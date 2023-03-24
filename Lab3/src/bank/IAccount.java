// Jiali Han
// Lab3: Interfaces & Abstract Classes
// Assignment: Bank Account

/**
 * This interface represents a bank account. It is the super-type for
 * any other type of traditional financial account a bank might offer
 */

package bank;

public interface IAccount {
    /**
     * Takes a double amount and deposit into the account.
     *
     * @param amount double the amount to be deposited
     */
    public void deposit(double amount);

    /**
     * Reduces the account balance by the amount specified.
     *
     * @param amount double the amount to be withdrawn
     * @return boolean indicating state of transaction
     */
    public boolean withdraw(double amount);

    /**Returns the account balance.
     *
     * @return double the account balance
     */
    public double getBalance();

    /**
     * Charges fees and resets transaction counter to zero if applicable.
     */
    public void performMonthlyMaintenance();
}
