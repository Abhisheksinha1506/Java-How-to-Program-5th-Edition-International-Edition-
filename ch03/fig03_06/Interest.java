// Fig. 3.6: Interest.java
// Calculating compound interest
import java.awt.Graphics;
import java.applet.Applet;

public class Interest extends Applet {
   public void paint( Graphics g )
   {
      double amount, principal = 1000.0, rate = .05;
      int yPos = 40;

      g.drawString( "Year", 25, 25 );
      g.drawString( "Amount on deposit", 100, 25 );
 
      for ( int year = 1; year <= 10; year++ ) {
         amount = principal * Math.pow( 1.0 + rate, year );
         g.drawString( Integer.toString( year ), 25, yPos );
         g.drawString( Double.toString( amount ), 100, yPos );
         yPos += 15;
      }
   }
}

