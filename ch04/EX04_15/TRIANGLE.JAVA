// Exercise 4.15 Solution
// Triangle.java
// Program calculates the hypotenuse of
// a right triangle.

import java.applet.Applet;
import java.awt.*;

public class Triangle extends Applet {
   TextField sideInput, side2Input;
   Label sidePrompt, sidePrompt2;

   public void init()
   {
      sideInput = new TextField( 4 );
      side2Input = new TextField( 4 );
      sidePrompt = new Label( "Enter side 1: " );
      sidePrompt2 = new Label( "Enter side 2: " );
      add( sidePrompt );
      add( sideInput );
      add( sidePrompt2 );
      add( side2Input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == side2Input ) {
         Double d2 = new Double( side2Input.getText() );
         Double d = new Double( sideInput.getText() );
         double side1, side2;

         side1 = d.doubleValue();
         side2 = d2.doubleValue();

         double h = hypotenuse( side1, side2 );

         showStatus( "Hypotenuse is : " + String.valueOf( h ) );
      }

      return true;
   }

   public double hypotenuse( double s1, double s2 )
   {
      double hypotSquared = Math.pow( s1, 2 ) + Math.pow( s2, 2 );

      return Math.sqrt( hypotSquared );
   }
}
