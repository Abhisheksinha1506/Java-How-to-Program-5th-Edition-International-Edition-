// Fig. 9.18: Metrics.java
// Demonstrating methods of the FontMetrics class, Graphics
// class and Toolkit class useful for obtaining font metrics
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;

public class Metrics extends Applet {
   private Font font1, font2;

   public void init()
   {
      font1 = new Font( "Courier", Font.BOLD, 14 ); 
      font2 = new Font( "TimesRoman", Font.PLAIN, 10 );
   }

   public void paint( Graphics g )         
   {
      g.setFont( font1 );   // set the current font

      // display the current font in the status bar
      showStatus( g.getFont().toString() );

      // get information about the current font font1
      int ascent = g.getFontMetrics().getAscent();
      int descent = g.getFontMetrics().getDescent();
      int height = g.getFontMetrics().getHeight();
      int leading = g.getFontMetrics().getLeading();

      String s1 = "Ascent of Font font1 is   " +
                  String.valueOf( ascent );

      String s2 = "Descent of Font font1 is  " +
                  String.valueOf( descent );

      String s3 = "Height of Font font1 is   " +
                  String.valueOf( height );

      String s4 = "Leading of Font font1 is  " +
                  String.valueOf( leading );

      g.drawString( s1, 10, 10 );
      g.drawString( s2, 10, 20 );
      g.drawString( s3, 10, 30 );
      g.drawString( s4, 10, 40 );

      // get information about the font font2
      ascent = g.getFontMetrics( font2 ).getAscent();
      descent = g.getFontMetrics( font2 ).getDescent();
      height = g.getFontMetrics( font2 ).getHeight();
      leading = g.getFontMetrics( font2 ).getLeading();

      s1 = "Ascent of Font font2 is   " +
           String.valueOf( ascent );

      s2 = "Descent of Font font2 is  " +
           String.valueOf( descent );

      s3 = "Height of Font font2 is   " +
           String.valueOf( height );

      s4 = "Leading of Font font2 is  " +
           String.valueOf( leading );
      
      g.drawString( s1, 10, 60 );
      g.drawString( s2, 10, 70 );
      g.drawString( s3, 10, 80 );
      g.drawString( s4, 10, 90 );

      g.drawString( "   Font list:", 10, 110 );

      // get the list of fonts
      String fonts[] = 
         Toolkit.getDefaultToolkit().getFontList();

      for ( int i = 0; i < fonts.length; i++ )
         g.drawString( fonts[ i ], 10, i * 10 + 120 ); 
   }
}
