// Exercise 9.14 Solution
// Fonts.java
// This program gets a list of fonts

import java.applet.Applet;
import java.awt.*;

public class Fonts extends Applet {
   private Font f;

   public void paint( Graphics g )
   {
      int xy = 20;    
      String list[] = Toolkit.getDefaultToolkit().getFontList();

      for ( int i = 0; i < list.length; i++, xy += 10 ) {
         f = new Font( list[ i ], Font.BOLD, 12 );
         g.setFont( f );
         g.drawString( list[ i ], xy, xy );
      }
   }
}
