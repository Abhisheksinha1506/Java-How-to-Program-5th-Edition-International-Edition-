// Fig. 5.17: InitArray.java
// Initializing multidimensional arrays
import java.awt.Graphics;
import java.applet.Applet;

public class InitArray extends Applet {
   int array1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };        
   int array2[][] = { { 1, 2 }, { 4 } };        

   // paint the applet
   public void paint( Graphics g )
   { 
      g.drawString( "Values in array1 by row are", 25, 25 );
      printArray( array1, g, 40 );
   
      g.drawString( "Values in array2 by row are", 25, 70 );
      printArray( array2, g, 85 );
   }

   public void printArray( int a[][], Graphics g, int y )
   {
      int x = 25;

      for ( int i = 0; i < a.length; i++ ) {

         for ( int j = 0; j < a[ i ].length; j++ )  {
            g.drawString( String.valueOf( a[ i ][ j ] ), x, y );
            x += 15;
         }

         x = 25;
         y += 15;
      }
   }
}
