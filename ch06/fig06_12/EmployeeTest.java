// Fig. 6.12: EmployeeTest.java
// Test Employee class with static class variable,
// static class method, and dynamic memory.
import java.awt.Graphics;
import java.applet.Applet;

public class EmployeeTest extends Applet {      
   public void paint( Graphics g )
   {
      g.drawString( "Employees before instantiation: " +
                    Employee.getCount(), 25, 25 );
      Employee e1 = new Employee( "Susan", "Baker" );
      Employee e2 = new Employee( "Bob", "Jones" );
   
      g.drawString( "Employees after instantiation: " +
                    e1.getCount(), 25, 40 );
   
      g.drawString( "Employee 1: " + e1.getFirstName() +
                    " " + e1.getLastName(), 25, 70 );
      g.drawString( "Employee 2: " + e2.getFirstName() +
                    " " + e2.getLastName(), 25, 85 );

      e1 = null;
      e2 = null;

      System.gc();  // explicit call to garbage collector

      g.drawString( "Employees after garbage collection: " +
                    Employee.getCount(), 25, 115 );
   }
}

