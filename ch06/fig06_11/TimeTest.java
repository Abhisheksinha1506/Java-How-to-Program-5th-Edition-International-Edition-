// Fig. 6.11: TimeTest.java
// Chaining method calls together with the this reference
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
      t.setHour( 18 ).setMinute( 30 ).setSecond( 22 );
      g.drawString( "Military time: " + 
                    t.toMilitaryString(), 25, 25 );
      g.drawString( "Standard time: " + t.toString(),
                    25, 40 );
      
      g.drawString( "New standard time: " + 
         t.setTime( 20, 20, 20 ).toString(), 25, 70 );      
   }
}


