// Jiali Han
// Lab3: Interfaces & Abstract Classes
// Assignment: Bank Account

/**
 * This a class represents what a savings banking account can do.
 * This class extends AbstractAccount and implements IAccount.
 * It's unique in its withdraw() method and performMonthlyMaintenance() method.
 */


package bank;

public class SavingsAccount extends AbstractAccount {
    // counter for transactions
    private int withdrawTransaction;
    // initialize a variable represents the threshold for charging penalty fee
    private static double threshold = 6.0;
    // initialize a variable represents the charging penalty fee
    private static double penalty = 14.0;

    /**
     * This is a constructor helps instiantate SavingsAccount objects.
     * It inherits the AbstractAccount constructor.
     * @param starterAmount the starter amount of account.
     * @throws IllegalArgumentException If starter account is smaller than 1 cent.
     */
    public SavingsAccount(double starterAmount) throws IllegalArgumentException {
        super(starterAmount);
    }

    /** This method overrides the AbstractAccount withdraw() method.
     * For a SavingsAccount withdraw() method:
     * Savings accounts allow for 6 penalty-free withdrawal transactions per month.
     * Savings accounts allow for an unlimited number of deposits per month.
     * If the amount specified for the withdrawal is negative, the operation fails.
     * If the number of withdrawals for the month is greater than 6,
     * a transaction penalty of $14 is deducted from the account when monthly maintenance is performed
     *
     * @param withdrawAmount The “withdraw amount” for the account.
     * @return true if the transaction is successful, false otherwise.
     */
    @Override
    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount < 0 || withdrawAmount < 0.01) {
            return false;
        } else if (withdrawAmount > balance) {
            return false;
        } else {
            withdrawTransaction += 1;
            balance -= withdrawAmount;
            return true;
        }
    }

    /** This method overrides the AbstractAccount method.
     * Savings accounts allow for 6 penalty-free withdrawal transactions per month.
     * If the number of withdrawals for the month is greater than 6,
     * a transaction penalty of $14 is deducted from the account when monthly maintenance is performed
     */
    @Override
    public void performMonthlyMaintenance() {
        if (withdrawTransaction > SavingsAccount.threshold) {
            balance -= SavingsAccount.penalty;
        }
        withdrawTransaction = 0;
    }
}
