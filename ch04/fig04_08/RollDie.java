// Fig. 4.8: RollDie.java
// Roll a six-sided die 6000 times
import java.awt.Graphics;
import java.applet.Applet;

public class RollDie extends Applet {
   int frequency1 = 0, frequency2 = 0,
       frequency3 = 0, frequency4 = 0,
       frequency5 = 0, frequency6 = 0;      
   
   // summarize results
   public void start()
   {
      for ( int roll = 1; roll <= 6000; roll++ ) {
         int face = 1 + (int) ( Math.random() * 6 );
   
         switch ( face ) {
            case 1:
               ++frequency1;
               break;
            case 2:
               ++frequency2;
               break;
            case 3:
               ++frequency3;
               break;
            case 4:
               ++frequency4;
               break;
            case 5:
               ++frequency5;
               break;
            case 6:
               ++frequency6;
               break;
         }
      }
   }

   // display results
   public void paint( Graphics g )
   {
      g.drawString( "Face", 25, 25 );
      g.drawString( "Frequency", 100, 25 );
      g.drawString( "1", 25, 40 );
      g.drawString( Integer.toString( frequency1 ), 100, 40 );
      g.drawString( "2", 25, 55 );
      g.drawString( Integer.toString( frequency2 ), 100, 55 );
      g.drawString( "3", 25, 70 );
      g.drawString( Integer.toString( frequency3 ), 100, 70 );
      g.drawString( "4", 25, 85 );
      g.drawString( Integer.toString( frequency4 ), 100, 85 );
      g.drawString( "5", 25, 100 );
      g.drawString( Integer.toString( frequency5 ),
                    100, 100 );
      g.drawString( "6", 25, 115 );
      g.drawString( Integer.toString( frequency6 ),
                    100, 115 );
   }
}
