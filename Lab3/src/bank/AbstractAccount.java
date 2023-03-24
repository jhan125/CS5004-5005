// Jiali Han
// Lab3: Interfaces & Abstract Classes
// Assignment: Bank Account

/**
 * This abstract class represents what a banking account can do.
 * It implements IAccount interface.
 * It is the super-class for other sub-classes like SavingAccount and CheckingAccount.
 */

package bank;


public abstract class AbstractAccount implements IAccount {
    // make this field protected so it can be directly accessed or called
    // from a descendant class, but from nowhere else.
    protected double balance;

    /**
     * Creates a new account by specifying a “starter” amount of money to open it with.
     * The starter amount must be greater than or equal to one cent.
     * If the amount specified is negative OR the amount is less than one cent ($0.01),
     * throw an IllegalArgumentException
     *
     * @param starterAmount The “starter amount” for the account.
     * @throws IllegalArgumentException if starter amount is negative or less than 1 cent
     */
    public AbstractAccount(double starterAmount) throws IllegalArgumentException{
        if (starterAmount < 0 || starterAmount < 0.01) {
            throw new IllegalArgumentException("The starter amount cannot be negative or less than one cent.");
        } else {
            this.balance = starterAmount;
        }
    }

    /**
     * Deposits into an account.
     * This method takes a single parameter (of type double)
     * that represents the amount deposited into the account.
     * If the amount specified is negative, throw an IllegalArgumentException
     *
     * @param depositAmount The “deposit amount” for the account.
     * @throws IllegalArgumentException if deposit amount is negative or less than one cent.
     */
    @Override
    public void deposit(double depositAmount) throws IllegalArgumentException {
        if (depositAmount < 0 || depositAmount < 0.01) {
            throw new IllegalArgumentException("The deposit amount cannot be negative or less than one cent.");
        } else {
            this.balance += depositAmount;
        }
    }

    /**
     * Withdraws from an account and reduces the account balance by the amount specified.
     * If the amount specified is greater than the balance available,
     * or if the withdraw amount is negative or less than one cent,
     * this operation fails and returns false.
     * If the amount specified is negative, throw an IllegalArgumentException
     *
     * @param withdrawAmount The “withdraw amount” for the account.
     * @return boolean: true if the transaction is successful, false otherwise.
     */
    @Override
    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount < 0 || withdrawAmount < 0.01) {
            return false;
        } else if (withdrawAmount > this.balance) {
            return false;
        } else {
            this.balance -= withdrawAmount;
            return true;
        }
    }

    /**
     * Checks the balance of an account.
     * Returns a double representing the current account balance.
     *
     *  @return The current account balance.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Prints the account balance in dollars/cents format (e.g: $10.00).
     * You may want to look up the documentation for the String.format method for this part,
     * or use the DecimalFormat class if you wish.
     *
     * @return the account balance in dollars/cents format
     */
    public String toString() {
        return String.format("Account Balance: $%.2f", getBalance());
    }

    /**
     * This is a performMonthlyMaintenance method.
     * Saving and checking will have overriding methods.
     */
    @Override
    public void performMonthlyMaintenance() {
    }
}
