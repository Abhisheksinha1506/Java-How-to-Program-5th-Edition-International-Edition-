// Exercise 6.18: TimeTest.java
// Class TimeTest to exercise class Time
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
      g.drawString( "The initial military time is: " +
                    t.toMilitaryString(), 25, 25 );
      g.drawString( "The initial standard time is: " +
                    t.toString(), 25, 40 );

      t.setTime( 13, 27, 6 );
      g.drawString( "Military time after setTime is: " +
                    t.toMilitaryString(), 25, 70 );
      g.drawString( "Standard time after setTime is: " +
                    t.toString(), 25, 85 );

      t.setTime( 99, 99, 99 );
      g.drawString( "After attempting invalid settings:",
                    25, 115 );
      g.drawString( "Military time: " +
                    t.toMilitaryString(), 25, 130 );
      g.drawString( "Standard time: " + t.toString(),
                    25, 145 );
   }
}
