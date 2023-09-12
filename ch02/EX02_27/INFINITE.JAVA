// Exercise 2.27 Solution
// Infinite.java
// Program creates an infinite loop

import java.applet.Applet;
import java.awt.*;

public class Infinite extends Applet {
   int x;
   Label instruction;
   TextField t;

   public void init()
   {
      x = 2;
      instruction = new Label( "Generate a text field event: " );
      t = new TextField( 2 );
      add( instruction );
      add( t );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == t ) {

         while ( true ) {
            x *= 2;
            System.out.print( x );
            System.out.print( "  " );
            showStatus( String.valueOf( x ) );
         }
      }

      return true;
   }
}
