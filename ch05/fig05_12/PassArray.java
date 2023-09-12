// Fig. 5.12: PassArray.java
// Passing arrays and individual array elements to methods
import java.awt.Graphics;
import java.applet.Applet;

public class PassArray extends Applet {
   int a[] = {0, 1, 2, 3, 4};

   public void paint( Graphics g )
   {
      int xPosition = 25, yPosition = 25;

      g.drawString(
         "Effects of passing entire array call-by-reference:",
         xPosition, yPosition );
      yPosition += 15;
      g.drawString( "The values of the original array are:",
                    xPosition, yPosition );
      xPosition += 15;
      yPosition += 15;

      for ( int i = 0; i < a.length; i++ ) {
         g.drawString( String.valueOf( a[ i ] ),
                       xPosition, yPosition );
         xPosition += 15;
      }
   
      xPosition = 25;
      yPosition += 30;

      modifyArray( a );  // array a passed call-by-reference
   
      g.drawString( "The values of the modified array are:",
                    xPosition, yPosition );   
      xPosition += 15;
      yPosition += 15;

      for ( int i = 0; i < a.length; i++ ) {
         g.drawString( String.valueOf( a[ i ] ),
                       xPosition, yPosition );
         xPosition += 15;
      }
   
      xPosition = 25;
      yPosition += 30;

      g.drawString(
         "Effects of passing array element call-by-value:",
         xPosition, yPosition );
      yPosition += 15;
      g.drawString( "a[3] before modifyElement: " + a[ 3 ],
                    xPosition, yPosition );
      yPosition += 15;
   
      modifyElement( a[ 3 ] );
   
      g.drawString( "a[3] after modifyElement: " + a[ 3 ],
                    xPosition, yPosition );
   }
   
   public void modifyArray( int b[] )
   {
      for ( int j = 0; j < b.length; j++ )
         b[ j ] *= 2;
   }
   
   public void modifyElement( int e )
   {
      e *= 2;
   }   
}
