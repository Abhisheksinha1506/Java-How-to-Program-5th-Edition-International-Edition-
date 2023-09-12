// Fig. 5.4: InitArray.java
// initializing an array with a declaration
import java.awt.Graphics;
import java.applet.Applet;

public class InitArray extends Applet {
   int n[] = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };        

   // paint the applet
   public void paint( Graphics g )
   {
      int yPosition = 25;   // starting y position on applet

      g.drawString( "Element", 25, yPosition );
      g.drawString( "Value", 100, yPosition );
   
      for ( int i = 0; i < n.length; i++ ) {
         yPosition += 15;
         g.drawString( String.valueOf( i ), 25, yPosition );
         g.drawString( String.valueOf( n[ i ] ),
                       100, yPosition );
      }
   }
}
