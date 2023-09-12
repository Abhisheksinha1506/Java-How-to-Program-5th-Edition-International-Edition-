// Exercise 1.29 Solution
// OddEven.java
// Program determines if a number is odd or even

import java.applet.Applet;
import java.awt.*;

public class OddEven extends Applet {
   TextField input;
   Label inputLabel;
   int number;

   public void init()
   {
      input = new TextField( 4 );
      inputLabel = new Label( "Enter a number:" );
      add( inputLabel );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      number = Integer.parseInt( input.getText() );

      if ( number % 2 == 0 )
         showStatus( "Number is even." );

      if ( number % 2 != 0 )
         showStatus( "Number is odd." );

      return true;
   }
}
