// Fig. 5.8: SumArray.java
// Compute the sum of the elements of the array
import java.awt.Graphics;
import java.applet.Applet;

public class SumArray extends Applet {
   int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
   int total;

   // initialize instance variables
   public void init()
   {
      total = 0;

      for ( int i = 0; i < a.length; i++ ) 
         total += a[ i ];
   }

   // paint the applet
   public void paint( Graphics g )
   {
      g.drawString( "Total of array elements: " + total,
                    25, 25 );
   }
}
