// Exercise 4.16: RecursiveSum.java
// Recursively sum the elements of an array
import java.awt.*;
import java.applet.Applet;

public class RecursiveSum extends Applet {
   int result;

   public void start()
   {
      int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
   
      result = whatIsThis( a, a.length );
   }

   public void paint( Graphics g )
   {
      g.drawString( "Result is " + result, 25, 25 );
   }
   
   public int whatIsThis( int b[], int size )
   {
      if ( size == 1 )
         return b[0];
      else
         return b[ size - 1 ] + whatIsThis( b, size - 1 );
   }
}


