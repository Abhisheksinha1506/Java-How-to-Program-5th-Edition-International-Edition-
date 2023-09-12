// Fig. 8.4: StringStartEnd.java
// This program demonstrates the methods startsWith and
// endsWith of the String class.
import java.awt.Graphics;
import java.applet.Applet;

public class StringStartEnd extends Applet{
   String strings[] = { "started", "starting", 
                        "ended", "ending" };

   public void paint( Graphics g )
   {
      int yPosition = 25;

      // Test method startsWith
      for ( int i = 0; i < strings.length; i++ )
         if ( strings[ i ].startsWith( "st" ) ) {
            g.drawString( "\"" + strings[ i ] +
               "\" starts with \"st\"", 25, yPosition );
            yPosition += 15;
         }

      yPosition += 15;

      // Test method startsWith starting from position
      // 2 of the string
      for ( int i = 0; i < strings.length; i++ )
         if ( strings[ i ].startsWith( "art", 2 ) ) {
            g.drawString( "\"" + strings[ i ] +
               "\" starts with \"art\" at position 2",
               25, yPosition );
            yPosition += 15;
         }

      yPosition += 15;

      // Test method endsWith
      for ( int i = 0; i < strings.length; i++ )
         if ( strings[ i ].endsWith( "ed" ) ) {
            g.drawString( "\"" + strings[ i ] +
               "\" ends with \"ed\"", 25, yPosition );
            yPosition += 15;
         }
   }
}
