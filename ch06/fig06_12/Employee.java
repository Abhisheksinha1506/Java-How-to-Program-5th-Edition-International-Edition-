// Fig. 6.12: Employee.java
// Declaration of the Employee class.
public class Employee {
   private String firstName;
   private String lastName;
   private static int count;  // # of objects instantiated

   public Employee( String fName, String lName )
   {
      firstName = fName;
      lastName = lName;

      ++count;  // increment static count of employees
      System.out.println( "Employee object constructor: " +
                          firstName + " " + lastName );
   }

   public void finalize()
   {
      --count;  // decrement static count of employees
      System.out.println( "Employee object finalizer: " +
                          firstName + " " + lastName );
   }

   public String getFirstName() 
      { return new String( firstName ); }

   public String getLastName()
      { return new String( lastName ); }

   public static int getCount() { return count; } 
}

