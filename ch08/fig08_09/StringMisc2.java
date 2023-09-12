// Fig. 8.9: StringMisc2.java
// This program demonstrates the String class replace,
// toLowerCase, toUpperCase, trim, toString, and toCharArray
// methods.
import java.awt.Graphics;
import java.applet.Applet;

public class StringMisc2 extends Applet {
   String s1 = new String( "hello" ),
          s2 = new String( "GOOD BYE" ),
          s3 = new String( "   spaces   " );

   public void paint( Graphics g )
   {
      g.drawString( "s1 = " + s1, 25, 25 );
      g.drawString( "s2 = " + s2, 25, 40 );
      g.drawString( "s3 = " + s3, 25, 55 );

      // test method replace      
      g.drawString( "Replace 'l' with 'L' in s1: " +
                    s1.replace( 'l', 'L' ), 25, 85 );

      // test toLowerCase and toUpperCase
      g.drawString( "s1 after toUpperCase = " + 
                    s1.toUpperCase(), 25, 115 );
      g.drawString( "s2 after toLowerCase = " +
                    s2.toLowerCase(), 25, 130 );

      // test trim method
      g.drawString( "s3 after trim = \"" + s3.trim() + "\"",
                    25, 160 );

      // test toString method
      g.drawString( "s1 = " + s1.toString(), 25, 190 );

      // test toCharArray method
      char charArray[] = s1.toCharArray();
      g.drawString( "s1 as a character array = ", 25, 220 );
      g.drawChars( charArray, 0, charArray.length, 172, 220 );
   }
}
