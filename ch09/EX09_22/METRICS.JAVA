// Exercise 9.22 Solution
// Metrics.java
// Program displays fonts and font metrics

import java.applet.Applet;
import java.awt.*;

public class Metrics extends Applet {
   private Font font1;

   public void init()
   {
      font1 = new Font( "TimesRoman", Font.PLAIN, 10 );
   }

   public void paint( Graphics g )         
   {
      g.setFont( font1 );   
      g.drawString( "   Font list:", 5, 8 );
      g.drawString( "Ascent", 150, 8 );
      g.drawString( "Descent", 190, 8 );
      g.drawString( "Height", 230, 8 );
      g.drawString( "Leading", 270, 8 );

      // get the list of fonts
      String fonts[] = 
         Toolkit.getDefaultToolkit().getFontList();

      for ( int i = 0; i < fonts.length; i++ ) {
         Font temp = new Font( fonts[ i ], Font.BOLD, 10 );
         g.setFont( temp );
         g.drawString( fonts[ i ], 10, i * 10 + 20 );

         int ascent = g.getFontMetrics( temp ).getAscent();
         int descent = g.getFontMetrics( temp ).getDescent();
         int height = g.getFontMetrics( temp ).getHeight();
         int leading = g.getFontMetrics( temp ).getLeading();

         g.setFont( font1 );
         g.drawString( String.valueOf( ascent ), 150, i * 10 + 20 );
         g.drawString( String.valueOf( descent ), 190, i * 10 + 20 );
         g.drawString( String.valueOf( height ), 230, i * 10 + 20 );
         g.drawString( String.valueOf( leading ), 270, i * 10 + 20 );
      }
   }
}
