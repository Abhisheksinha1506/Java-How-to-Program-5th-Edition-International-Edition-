// Exercise 4.17 Solution
// EvenOdd.java
// Determines if a number is odd or even

import java.applet.Applet;
import java.awt.*;

public class EvenOdd extends Applet {
   TextField input;
   Label prompt;

   public void init()
   {
      input = new TextField( 4 );  
      prompt = new Label( "Enter first number: " );
      add( prompt );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         int number;

         number = Integer.parseInt( input.getText() );    

         if ( isEven( number ) == true )
            showStatus( String.valueOf( number ) +
                        " is even" );             
         else
            showStatus( String.valueOf( number ) +
                        " is odd " );
      }

      return true;
   }

   public boolean isEven( int num )
   {
      if ( num % 2 == 0 )
         return true;

      return false;
   }
}
