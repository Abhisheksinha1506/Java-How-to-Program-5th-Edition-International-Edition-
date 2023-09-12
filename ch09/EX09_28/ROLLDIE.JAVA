// Exercise 9.28 Solution
// RollDie.java
// Roll a six-sided die 6000 times

import java.applet.Applet;
import java.util.Random;
import java.awt.*;

public class RollDie extends Applet {
   private int face, roll, frequency[];    
   private Random r;   

   // initialize instance variables
   public void init()
   {
      roll = 1;
      frequency = new int[ 7 ];  
      r = new Random();
   }

   // paint the applet
   public void paint( Graphics g )
   {
      int yPosition = 25;  

      for ( ; roll <= 6000; roll++ ) {
         face = 1 + Math.abs( r.nextInt() % 6 );
         ++frequency[ face ];

         g.setColor( Color.white );
         g.fillRect( 0, 0, 275, 125 );   // 275 x 125
         g.setColor( Color.black );

         g.drawString( "Face", 25, yPosition );
         g.drawString( "Frequency", 100, yPosition );

         for ( int i = 1; i < frequency.length; i++ ) {
            yPosition += 15;
            g.drawString( String.valueOf( i ), 25, yPosition );
            g.drawString( String.valueOf( frequency[ i ] ),
                          100, yPosition );
         }

         // slow drawing down
         for ( int j = 1; j < 100000; j++ )
            ;     // do nothing

         yPosition = 25;
      }
   }
}
