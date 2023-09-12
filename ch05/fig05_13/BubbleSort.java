// Fig. 5.13: BubbleSort.java
// This program sorts an array's values into
// ascending order
import java.awt.Graphics;
import java.applet.Applet;

public class BubbleSort extends Applet {
   int a[] = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };
   int hold;  // temporary holding area for swap
   
   public void paint( Graphics g )
   {
      print( g, "Data items in original order", a, 25, 25 );
 	
      sort();

      print( g, "Data items in ascending order", a, 25, 55 );
   }

   public void sort() 
   {   
      for ( int pass = 1; pass < a.length; pass++ ) // passes
         for ( int i = 0; i < a.length - 1; i++ ) // one pass   
            if ( a[ i ] > a[ i + 1 ] ) {      // one comparison
               hold = a[i];                   // one swap
               a[ i ] = a[ i + 1 ];
               a[ i + 1 ] = hold;
            }
   }

   public void print( Graphics g, String head, int b[],
                      int x, int y )
   {
      g.drawString( head, x, y ); 
      x += 15;
      y += 15; 
   
      for ( int i = 0; i < b.length; i++ ) {
         g.drawString( String.valueOf( b[ i ] ), x, y );
         x += 20;
      }
   }
}


