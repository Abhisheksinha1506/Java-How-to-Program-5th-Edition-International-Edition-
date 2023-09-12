// Fig. 4.16: MethodOverload.java
// Using overloaded methods
import java.awt.Graphics;
import java.applet.Applet;

public class MethodOverload extends Applet {
   public void paint( Graphics g )
   {
      g.drawString( "The square of integer 7 is " + square( 7 ),
                    25, 25 );
      g.drawString( "The square of double 7.5 is " + 
                    square( 7.5 ), 25, 40 );
   }
   
   int square( int x )
   {
      return x * x;
   }
   
   double square( double y )
   {
      return y * y;
   }
}
