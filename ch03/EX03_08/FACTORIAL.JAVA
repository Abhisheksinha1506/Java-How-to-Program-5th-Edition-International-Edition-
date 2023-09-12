// Exercise 3.8 Solution
// Factorial.java
// Program calculates factorials

import java.applet.Applet;
import java.awt.*;

public class Factorial extends Applet {

   public void paint( Graphics g )
   {
      int fact, y = 20;

      g.drawString( "X", 5, 10 );
      g.drawString( "X!", 70, 10 );

      for ( int z = 1; z <= 5; z++ ) {
         fact = 1;

         for ( int w = 1; w <= z; w++ )
            fact *= w;

         g.drawString( String.valueOf( z ), 5, y );
         g.drawString( String.valueOf( fact ), 70, y );

         y += 10;
      }
   }
}
