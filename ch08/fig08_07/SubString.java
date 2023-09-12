// Fig. 8.7: SubString.java
// This program demonstrates the String class substring methods.
import java.awt.Graphics;
import java.applet.Applet;

public class SubString extends Applet {
   String letters = "abcdefghijklmabcdefghijklm";

   public void paint( Graphics g )
   {
      // test substring methods
      g.drawString( "Substring from index 20 to end is " +
         "\"" + letters.substring( 20 ) + "\"", 25, 25 );

      g.drawString( "Substring from index 0 upto 6 is " +
         "\"" + letters.substring( 0, 6 ) + "\"", 25, 40 );
   }
}
