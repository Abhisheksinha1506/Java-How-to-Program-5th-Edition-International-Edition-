// Exercise 4.19: RecursiveDisplay.java
// Recursively display the elements of an array
import java.awt.*;
import java.applet.Applet;

public class RecursiveDisplay extends Applet {
   int yPosition = 0;
   int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

   public void paint( Graphics g )
   {
      someFunction( a, 0, g );
   }
   
   public void someFunction( int b[], int x, Graphics g )
   {
      if ( x < b.length ) {
         someFunction( b, x + 1, g );
         g.drawString( String.valueOf( b[ x ] ), 25, yPosition );
         yPosition += 15;
      }
   }
}


