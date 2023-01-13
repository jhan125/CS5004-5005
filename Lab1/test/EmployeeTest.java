/**
 * Name: Jiali Han
 * Lab 01
 * This is a class EmployeeTest to test methods in class Employee.
 */

import org.junit.Assert;
import org.junit.Test;
public class EmployeeTest {

  @Test
  public void testAddHoursWorked() {
    Employee abc = new Employee("abc", "001", 10.0);
    // abc.hours was originally 0.0, after adding 1 working hour, abc.hours should be 1.0
    abc.addHoursWorked(1.0);
    Assert.assertEquals(1.0, abc.getHoursWorked(), 0.001);
  }

  @Test
  public void testResetHoursWorked() {
    Employee abc = new Employee("abc", "001", 10.0);
    abc.addHoursWorked(1.0);
    // reset working hour to 0.0
    abc.resetHoursWorked();
    Assert.assertEquals(0.0, abc.getHoursWorked(), 0.001);
  }

  @Test
  public void testGetHoursWorked() {
    Employee abc = new Employee("abc", "001", 10.0);
    abc.addHoursWorked(1.0);
    Assert.assertEquals(1.0, abc.getHoursWorked(), 0.001);
  }

  @Test
  public void testGetWeeklyCheck() {
    Employee abc = new Employee("abc", "001", 10.0);
    abc.addHoursWorked(1.0);
    // check if this returns a new Paycheck object that is initialized with rate and hours worked by the Employee.
    Paycheck abc_paycheck = abc.getWeeklyCheck();
    Assert.assertEquals(10.0, abc_paycheck.rate, 0.001);
    Assert.assertEquals(1.0, abc_paycheck.hours, 0.001);
  }

  @Test
  public void testToString() {
    Employee abc = new Employee("abc", "001", 10.0);
    abc.addHoursWorked(1.0);
    String actual = abc.toString();
    String expected = "Name: abc\nID: 001\nPayment after taxes: $ 9.0";
    Assert.assertEquals("Message Error", expected, actual);
  }
}