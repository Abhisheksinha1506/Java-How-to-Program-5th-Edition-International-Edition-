// Exercise 4.30 Solution
// Coin.java
// Program simulates tossing a coin.

import java.applet.Applet;
import java.awt.*;

public class Coin extends Applet {
   int heads, tails;
   Button b;

   public void init()
   {
      b = new Button( "Toss" );
      add( b );
      heads = 0;
      tails = 0;
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == b ) {

         if ( flip() == true )
            ++heads;
         else
            ++tails;
      }

      showStatus( "Heads: " + heads + "    Tails: " + tails );
      return true;
   }

   public boolean flip()
   {
      if ( ( int ) ( Math.random() * 2 ) == 1 )
         return true;
      else
         return false;
   }
}
