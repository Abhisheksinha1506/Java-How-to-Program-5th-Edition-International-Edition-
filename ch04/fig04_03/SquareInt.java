// Fig. 4.3: SquareInt.java
// A programmer-defined square method
import java.awt.Graphics;
import java.applet.Applet;

public class SquareInt extends Applet {
   // output the squared values of 1 through 10
   public void paint( Graphics g )
   {
      int xPosition = 25; 

      for ( int x = 1; x <= 10; x++ ) {
         g.drawString( String.valueOf( square( x ) ), 
                       xPosition, 25);
         xPosition += 20;         
      }
   }
   
   // square method definition 
   public int square(int y)
   {
      return y * y;
   }
}
