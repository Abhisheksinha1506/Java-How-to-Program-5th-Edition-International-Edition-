// Exercise 4.25 Solution
// PerfectNum.java
// Program determines if a number
// is a "perfect" number

import java.applet.Applet;
import java.awt.*;

public class PerfectNum extends Applet {

   public void paint( Graphics g )
   {
      int y = 5;

      for ( int a = 2; a <= 1000; a++ )
         if ( perfect( a ) == true )
            g.drawString( String.valueOf( a ) +
                          " is perfect.", 5, y += 15 );
   }

   public boolean perfect( int value )
   {
      int factorSum = 1;

      for ( int b = 2; b <= value / 2; b++ )
         if ( value % b == 0 )
            factorSum += b;

      if ( factorSum == value )
         return true;

      return false;
   }
}
