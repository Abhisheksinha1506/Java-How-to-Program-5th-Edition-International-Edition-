// Fig. 6.8: EmployeeTest.java
// Demonstrating an object with a member object.
import java.awt.Graphics;
import java.applet.Applet;

public class EmployeeTest extends Applet {
   private Employee e;

   public void init()
   {
      e = new Employee( "Bob", "Jones", 7, 24, 49,
                        3, 12, 88 );
   }
   
   public void paint( Graphics g )
   {
      g.drawString( e.toString(), 25, 25 );
   }
}

