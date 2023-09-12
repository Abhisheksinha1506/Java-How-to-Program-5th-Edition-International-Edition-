// Exercise 4.29 Solution
// Average.java
// Program displays a number
// representing the student's average

import java.applet.Applet;
import java.awt.*;

public class Average extends Applet {
   TextField input;
   Label prompt;

   public void init()
   {
      input = new TextField( 4 );
      prompt = new Label( "Enter average:" );
      add( prompt );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         int number = Integer.parseInt( input.getText() );

         if ( number >= 0 && number <= 100 )
            showStatus( "Point is: " + qualityPoints( number ) );
         else
            showStatus( "Invalid input." );
      }

      return true;
   }

   public int qualityPoints( int grade )
   {
      if ( grade >= 90 ) 
         return 4;
      else if ( grade >= 80 )
         return 3;
      else if ( grade >= 70 )
         return 2;
      else if ( grade >= 60 )
         return 1;
      else
         return 0;   
   }
}
