// Exercise 5.15 Solution
// Roll36.java
// Program simulates rolling two
// six-sided die 36,000 times

// NOTE: this program could take a
// few seconds before displaying the data

import java.applet.Applet;
import java.awt.*;

public class Roll36 extends Applet {
   int total[];

   public void init()
   {
      total = new int[ 13 ];

      for ( int i = 0; i < total.length; i++ )
         total[ i ] = 0;

      roll2Dice();
   }

   public void roll2Dice()
   {
      int face1, face2;

      for ( int x = 1; x <= 36000; x++ ) {
         face1 = ( int ) ( 1 + Math.random() * 6 );
         face2 = ( int ) ( 1 + Math.random() * 6 );

         total[ face1 + face2 ]++;
      }
   }

   public void paint( Graphics g )
   {
      int y = 60;

      g.drawString( "Sum", 5, 60 );
      g.drawString( "Frequency", 85, 60 );

      // ignore subscripts 0 and 1
      for ( int k = 2; k < total.length; k++ ) {
         g.drawString( String.valueOf( k ), 5, y += 10 );
         g.drawString( String.valueOf( total[ k ] ), 85, y );

         double percent = ( double ) total[ k ] / 36000.0;
         g.drawString( "%" + percent, 150, y );
      }
   }
}
