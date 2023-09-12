// Fig. 3.5: Sum.java
// Counter-controlled repetition with the for structure
import java.awt.Graphics;
import java.applet.Applet;

public class Sum extends Applet {
   public void paint( Graphics g )
   {
      int sum = 0;

      for ( int number = 2; number <= 100; number += 2 )
         sum += number;

      g.drawString( "Sum is " + sum, 25, 25 );
   }
}

