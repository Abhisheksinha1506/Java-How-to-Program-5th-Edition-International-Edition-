// Fig. 6.8: Employee.java
// Declaration of the Employee class.
public class Employee {
   private String firstName;
   private String lastName;
   private MyDate birthDate;
   private MyDate hireDate;

   public Employee( String fName, String lName,
                    int bMonth, int bDay, int bYear,
                    int hMonth, int hDay, int hYear)
   {
      firstName = fName;
      lastName = lName;
      birthDate = new MyDate( bMonth, bDay, bYear );
      hireDate = new MyDate( hMonth, hDay, hYear );
   }

   public String toString()
   {
      return lastName + ", " + firstName +
             "  Hired: " + hireDate.toString() +
             "  Birthday: " + birthDate.toString();
   }
}

