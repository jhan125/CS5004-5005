// Jiali Han
// Lab3: Interfaces & Abstract Classes
// Assignment: Bank Account


package bank;


/**
 * This a class represents what a checking banking account can do.
 * This class extends AbstractAccount and implements IAccount.
 * It's unique in its performMonthlyMaintenance() method.
 */
public class CheckingAccount extends AbstractAccount {
    // make those fields private for security and privacy

    // initialize a variable represents the threshold for charging penalty fee
    private static double threshold = 100.0;
    // initialize a variable represents whether to charge penalty in monthly maintenance
    private boolean penaltyCharge;
    // initialize a variable represents the charging penalty fee
    private static double penalty = 5.0;

    /**
     * This is a constructor helps instiantate CheckingAccount objects.
     * It inherits the AbstractAccount constructor.
     * @param starterAmount the starter amount of account.
     * @throws IllegalArgumentException If starter account is smaller than 1 cent.
     */
    public CheckingAccount(double starterAmount) throws IllegalArgumentException {
        super(starterAmount);
        if (getBalance() < threshold) {
            this.penaltyCharge = true;
        } else {
            this.penaltyCharge = false;
        }
    }

    /** This method overrides the AbstractAccount withdraw() method.
     * Withdraws amount from checking account.
     * If balance falls below $100, a penalty fee would be charged during maintenance.
     *
     * @param withdrawAmount  The amount to be withdrawn
     * @return boolean: true if the transaction is successful, false otherwise.
     */
    @Override
    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount < 0 || withdrawAmount < 0.01) {
            return false;
        } else if (withdrawAmount > balance) {
            return false;
        } else {
            balance -= withdrawAmount;
            if (balance < CheckingAccount.threshold) {
                penaltyCharge = true;
            }
            return true;
        }
    }

    /** This method overrides the AbstractAccount method.
     * Charges montly fees and gives a "clean slate".
     * A minimum balance of $100 must be maintained throughout the month to avoid fees
     * If the checking balance falls below $100 at ANY time during the month
     * (before maintenance is performed)
     * an account maintenance fee of $5 is charged when the monthly maintenance is performed.
     */
    @Override
    public void performMonthlyMaintenance() {
        // first check if current balance meets the 100 threshold
        if (balance < CheckingAccount.threshold) {
            penaltyCharge = true;
        }
        // if balance < threshold, charges penalty in montly fee
        if (penaltyCharge == true) {
            balance -= penalty;
        }
        // then update boolean penaltyCharge based on balance
        if (balance >= CheckingAccount.threshold) {
            penaltyCharge = false;
        } else {
            penaltyCharge = true;
        }
    }
}
