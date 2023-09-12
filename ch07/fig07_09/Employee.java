// Fig. 7.9: Employee.java
// Abstract base class Employee

public abstract class Employee {
   private String firstName;
   private String lastName;

   // Constructor
   public Employee( String first, String last )
   {
      firstName = new String ( first );
      lastName = new String( last );
   }
   
   // Return a copy of the first name
   public String getFirstName() 
      { return new String( firstName ); }

   // Return a copy of the last name
   public String getLastName() 
      { return new String( lastName ); }

   // Abstract method that must be implemented for each 
   // derived class of Employee from which objects 
   // are instantiated.
   abstract double earnings(); 
}

