// Fig. 5.11: RollDie.java
// Roll a six-sided die 6000 times
import java.awt.Graphics;
import java.applet.Applet;
import java.util.Random;

public class RollDie extends Applet {
   int face;
   int frequency[];    
   Random r;   // create the random number generator

   // initialize instance variables
   public void init()
   {
      frequency = new int[ 7 ];  
      r = new Random();

      for ( int roll = 1; roll <= 6000; roll++ ) {
         face = 1 + Math.abs( r.nextInt() % 6 );
         ++frequency[ face ];
      }
   }

   // paint the applet
   public void paint( Graphics g )
   {
      int yPosition = 25;  

      g.drawString( "Face", 25, yPosition );
      g.drawString( "Frequency", 100, yPosition );
   
      for ( face = 1; face < frequency.length; face++ ) {
         yPosition += 15;
         g.drawString( String.valueOf( face ), 25, yPosition );
         g.drawString( String.valueOf( frequency[ face ] ),
                       100, yPosition );
      }
   }
}
