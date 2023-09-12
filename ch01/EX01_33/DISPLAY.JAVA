// Exercise 1.33 Solution
// Display.java
// Program prints a unicode character
// and its integer equivalent

import java.applet.Applet;
import java.awt.*;

public class Display extends Applet {

   public void paint( Graphics g )
   {
      g.drawString( "The character " + 'A' +
                    " has the value " + ( int ) 'A', 5, 10 );

      g.drawString( "The character " + 'B' +
                    " has the value " + ( int ) 'B', 5, 20 );

      g.drawString( "The character " + 'C' +
                    " has the value " + ( int ) 'C', 5, 30 );

      g.drawString( "The character " + 'a' +
                    " has the value " + ( int ) 'a', 5, 40 );

      g.drawString( "The character " + 'b' +
                    " has the value " + ( int ) 'b', 5, 50 );

      g.drawString( "The character " + 'c' +
                    " has the value " + ( int ) 'c', 5, 60 );

      g.drawString( "The character " + '0' +
                    " has the value " + ( int ) '0', 5, 70 );

      g.drawString( "The character " + '1' +
                    " has the value " + ( int ) '1', 5, 80 );

      g.drawString( "The character " + '2' +
                    " has the value " + ( int ) '2', 5, 90 );

      g.drawString( "The character " + '$' +
                    " has the value " + ( int ) '$', 5, 100 );

      g.drawString( "The character " + '*' +
                    " has the value " + ( int ) '*', 5, 110 );

      g.drawString( "The character " + '/' +
                    " has the value " + ( int ) '/', 5, 120);

      g.drawString( "The character " + ' ' +
                    " has the value " + ( int ) ' ', 5, 130 );

      g.drawString( "The character " + ',' +
                    " has the value " + ( int ) ',', 5, 140 );
   }
}
