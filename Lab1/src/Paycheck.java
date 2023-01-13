/**
 * Name: Jiali Han
 * Lab 01
 * This is a Paycheck class that calculates employee pay for the week.
 * A Paycheck has an employee's  rate, and the hours worked.
 */

import java.math.RoundingMode;
import java.math.BigDecimal;

public class Paycheck {
  double rate;
  double hours;
  double totalPay;
  double payAfterTax;

  /**
   * This constructor the rate, and hours worked as parameters and calculates (and stores) the total pay for the week.
   * sets the instance values appropriately.
   * @param double rate  the rate of this Employee
   * @param double hours the working hours of this Employee
   */
  public Paycheck(double rate, double hours) {
    this.rate = rate;
    this.hours = hours;
    this.totalPay = this.getTotalPay();
    this.payAfterTax = this.getPayAfterTaxes();
  }

  /**
   * This method returns the total pay for the week (make sure to round it to nearest cents)
   * @return double totalPay  the total weekly pay of this Employee
   */
  public double getTotalPay() {
    double totalPay = 0;
    // Paychecks calculate the weekly pay based as rate * hours if the number of hours worked is 40 or less.
    if (this.hours >= 0 && this.hours <= 40) {
      totalPay = this.rate * this.hours;
    } else if (this.hours > 40) { // If the hours worked exceeds 40, the Paycheck applies an overtime rate of 1.5x for all of the hours in excess of 40.
      totalPay = rate * 40 + rate * 1.5 * (hours - 40);
    }
    // Since we're using US dollars and don't pay employees in fractions of cents.
    // If an employee earned more than 0 but less than 1 cent, we'll pay them the 1 cent.
    BigDecimal output = new BigDecimal(totalPay).setScale(2, RoundingMode.CEILING);
    totalPay = output.doubleValue();
    return totalPay;
  }

  /**
   * This method returns the amount paid the employee after a flat tax is deducted based on this scale
   * @return double paymentAfterTax  the total weekly pay after flat taxes of this Employee
   */
  public double getPayAfterTaxes() {
    double paymentAfterTax;
    // If the employee total payment is less than $400, deduct 10% of the total payment to obtain "payment after taxes"
    if (totalPay < 400) {
      paymentAfterTax = (1 - 0.1) * totalPay;
    } else { // If the employee total payment is $400 or more, deduct 15% of the total payment to obtain "payment after taxes"
      paymentAfterTax = (1 - 0.15) * totalPay;
    }
    return paymentAfterTax;
  }

  /**
   * This method returns a String representing the current payment AFTER taxes are assessed.
   * @return String output  the string representing the current payment AFTER taxes are assessed.
   */
  public String toString() {
    String output = String.format("Payment after taxes: $ %f", payAfterTax);
    return output;
  }
}
