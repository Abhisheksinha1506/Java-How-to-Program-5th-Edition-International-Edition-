// Fig. 8.6: StringIndexMethods.java
// This program demonstrates the String 
// class index methods.
import java.awt.Graphics;
import java.applet.Applet;

public class StringIndexMethods extends Applet {
   String letters = "abcdefghijklmabcdefghijklm";

   public void paint( Graphics g )
   {
      // test indexOf to locate a character in a string
      g.drawString( "'c' is located at index " +
         letters.indexOf( (int) 'c' ), 25, 25 );

      g.drawString( "'a' is located at index " +
         letters.indexOf( (int) 'a', 1 ), 25, 40 );

      g.drawString( "'$' is located at index " +
         letters.indexOf( (int) '$' ), 25, 55 );

      // test lastIndexOf to find a character in a string
      g.drawString( "Last 'c' is located at index " +
         letters.lastIndexOf( (int) 'c' ), 25, 85 );

      g.drawString( "Last 'a' is located at index " +
         letters.lastIndexOf( (int) 'a', 25 ), 25, 100 );

      g.drawString( "Last '$' is located at index " +
         letters.lastIndexOf( (int) '$' ), 25, 115 );

      // test indexOf to locate a substring in a string
      g.drawString( "\"def\" is located at index " +
         letters.indexOf( "def" ), 25, 145 );

      g.drawString( "\"def\" is located at index " +
         letters.indexOf( "def", 7 ), 25, 160 );

      g.drawString( "\"hello\" is located at index " +
         letters.indexOf( "hello" ), 25, 175 );

      // test lastIndexOf to find a substring in a string
      g.drawString( "Last \"def\" is located at index " +
         letters.lastIndexOf( "def" ), 25, 205 );

      g.drawString( "Last \"def\" is located at index " +
         letters.lastIndexOf( "def", 25 ), 25, 220 );

      g.drawString( "Last \"hello\" is located at index " +
         letters.lastIndexOf( "hello" ), 25, 235 );
   }
}
