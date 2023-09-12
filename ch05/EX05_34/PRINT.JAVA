// Exercise 5.34 Solution
// Print.java
// Program prints a string 

import java.applet.Applet;
import java.awt.*;

public class Print extends Applet {
   int x = 0;
   Graphics g2;

   public void paint( Graphics g )
   {
      int a[] = { 8, 22, 88, 34, 84, 21, 94 };

      g2 = g;
      printArray( a, 0, a.length - 1 );
   }

   public void printArray( int b[], int low, int high )
   {
      g2.drawString( String.valueOf( b[ low ] ), x += 30, 20 );

      if ( low == high )
         return;
      else
         printArray( b, low + 1, high );
   }
}
