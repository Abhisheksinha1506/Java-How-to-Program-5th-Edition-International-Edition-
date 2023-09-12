// Fig. 5.7: FinalTest.java
// using a properly initialized constant variable
import java.awt.Graphics;
import java.applet.Applet;

public class FinalTest extends Applet {
   final int x = 7;  // initialize constant variable

   public void paint( Graphics g )
   {
      g.drawString( "The value of x is: " + x, 25, 25 ); 
   }
}

