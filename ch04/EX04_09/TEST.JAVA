// Exercise 4.9 Solution
// Test.java
// Program tests Math.floor

import java.applet.Applet;
import java.awt.*;

public class Test extends Applet {
   TextField input;
   Label inputLabel;
   double x;

   public void init()
   {
      input = new TextField( 4 );
      inputLabel = new Label( "Enter a decimal number:" );
      add( inputLabel );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         Double temp = new Double( input.getText() );

         x = temp.doubleValue();
         showStatus( "Number: " + String.valueOf( x ) +
                     "    Math.floor( x + .5 ): " +
                     String.valueOf( Math.floor( x + .5 ) ) );
      }

      return true;
   }
}
