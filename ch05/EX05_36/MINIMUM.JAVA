// Exercise 5.36 Solution
// Minimum.java
// Program finds the minimum value in an array.

import java.applet.Applet;
import java.awt.*;

public class Minimum extends Applet {
   final int MAX = 100;
   int smallest;

   public void init()
   { 
      smallest = MAX;
   }

   public void paint( Graphics g )
   {
      int a[] = { 22, 88, 8, 94, 78, 84, 96, 73, 34 };

      showStatus( String.valueOf( recursiveMinimum( a,
                                  0, a.length - 1 ) ) );
   }

   public int recursiveMinimum( int b[], int low, int high )
   {
      if ( b[ low ] < smallest )
         smallest = b[ low ];

      if ( low == high )
         return smallest;
      else
         return recursiveMinimum( b, low + 1, high );
   }
}
