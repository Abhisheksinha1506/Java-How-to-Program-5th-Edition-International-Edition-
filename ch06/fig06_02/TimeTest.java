// Fig. 6.2: TimeTest.java
// Demonstrate errors resulting from attempts 
// to access private class members.
import java.awt.Graphics;
import java.applet.Applet;

public class TimeTest extends Applet {
   private Time t;

   public void init()
   {
      t = new Time();
   }
 
   public void paint( Graphics g )
   {
      t.hour = 7;

      g.drawString( "minute = " + t.minute, 25, 25 );
   }
}
