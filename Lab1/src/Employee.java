/**
 * Name: Jiali Han
 * Lab 01
 * This is an Employee class that represents a single hourly employee.
 * Employee has a name (String), employee ID (String), the number of hours worked in a given week (double), and pay rate (double).
 */


public class Employee {
  private String name;
  private String ID;
  private double hours;
  private double rate;

  /**
   * This constructor takes a name, ID, and pay rate as parameters and
   * sets the instance values appropriately.
   * @param String name the name of this Employee
   * @param String ID   the ID of this Employee
   * @param double rate the rate of this Employee
   */
  public Employee(String name, String ID, double rate) {
    this.name = name;
    this.ID = ID;
    this.rate = rate;
    this.hours = 0;
  }

  /**
   * This method takes a parameter (double) and adds the value of that parameter
   * to the current number of hours the Employee has worked this week.
   * @param double workingHours the working hours of this Employee
   */
  public void addHoursWorked(double workingHours) {
    if (this.hours >= 0) {
      this.hours += workingHours;
    }
  }

  /**
   * This method resets the employee’s hours worked for the week to zero.
   */
  // this method
  public void resetHoursWorked() {
    this.hours = 0;
  }

  /**
   * This method returns (double) representing the hours worked for the employee.
   * @return double hours the working hours of this Employee
   */
  public double getHoursWorked() {
    return this.hours;
  }

  /**
   * This method returns a new Paycheck object that is initialized with rate and hours worked by the Employee.
   * @return Paycheck abc_paycheck the paycheck object initialized with rate and hours worked by this Employee
   */
  public Paycheck getWeeklyCheck() {
    Paycheck abc_paycheck = new Paycheck(this.rate, this.hours);
    return abc_paycheck;
  }

  /**
   * This method returns a String allowing Employee objects to be represented
   * by the employee name, ID, and current week's payment after taxes are assessed.
   * @return String output a String allowing Employee objects to be represented
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(this.name).append("\n");
    sb.append("ID: ").append(this.ID).append("\n");
    sb.append("Payment after taxes: $ ").append(this.getWeeklyCheck().getPayAfterTaxes());
    String output = sb.toString();
    return output;
  }
}
