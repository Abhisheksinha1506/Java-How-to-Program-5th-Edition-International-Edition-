// Exercise 4.41 Solution
// Divisor.java
// Program recursively finds the greatest
// common divisor of two numbers.

import java.applet.Applet;
import java.awt.*;

public class Divisor extends Applet {
   TextField input1, input2;
   Label label1, label2;

   public void init()
   {
      input1 = new TextField( 4 );
      input2 = new TextField( 4 );
      label1 = new Label( "Enter first number:" );
      label2 = new Label( "Enter second number:" );
      add( label1 );
      add( input1 );
      add( label2 );
      add( input2 );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input2 ) {
         int num1, num2;

         num1 = Integer.parseInt( input1.getText() );
         num2 = Integer.parseInt( input2.getText() );

         showStatus( "GCD is: " + gcd( num1, num2 ) );
      }

      return true;
   }

   public int gcd( int x, int y )
   {
      if ( y == 0 )
         return x;
      else
         return gcd( y, x % y ); 
   }
}
