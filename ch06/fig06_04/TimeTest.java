// Fig. 6.4: TimeTest.java
// Using overloaded constructors
import java.awt.Graphics;
import java.applet.Applet;

public class TimeTest extends Applet {
   private Time t1, t2, t3, t4, t5;

   public void init()
   {
      t1 = new Time();
      t2 = new Time( 2 );
      t3 = new Time( 21, 34 );
      t4 = new Time( 12, 25, 42 );
      t5 = new Time( 27, 74, 99 );
   }
 
   public void paint( Graphics g )
   {
      g.drawString( "Constructed with:", 25, 25 );
      g.drawString( "all arguments defaulted:", 25, 40 );
      g.drawString( "   " + t1.toMilitaryString(),
                    25, 55 );
      g.drawString( "   " + t1.toString(), 25, 70 );

      g.drawString( "hour specified; minute " + 
                    "and second defaulted:", 25, 85 );
      g.drawString( "   " + t2.toMilitaryString(),
                    25, 100 );
      g.drawString( "   " + t2.toString(), 25, 115 );

      g.drawString( "hour and minute specified; " + 
                    "second defaulted:", 25, 130 );
      g.drawString( "   " + t3.toMilitaryString(),
                    25, 145 );
      g.drawString( "   " + t3.toString(), 25, 160 );

      g.drawString( "hour, minute, and second specified:",
                    25, 175 );
      g.drawString( "   " + t4.toMilitaryString(),
                    25, 190 );
      g.drawString( "   " + t4.toString(), 25, 205 );

      g.drawString( "all invalid values specified:",
                    25, 220 );
      g.drawString( "   " + t5.toMilitaryString(),
                    25, 235 );
      g.drawString( "   " + t5.toString(), 25, 250 );
   }
}


