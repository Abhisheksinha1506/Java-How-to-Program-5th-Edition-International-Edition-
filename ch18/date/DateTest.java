// Fig. 18.4: DateTest.java
// Test class Date of the java.util package.
import java.util.Date;
import java.awt.Graphics;
import java.applet.Applet;

public class DateTest extends Applet {
   Date system, user;

   public void init()
   {
      system = new Date();
      user = new Date( 96, 6, 4 );
   }

   public void paint( Graphics g )
   {
      g.drawString( "System date: " +
                    system.toString(), 25, 25 );
      g.drawString( "User defined date: " +
                    user.toString(), 25, 40 );
   }
}
