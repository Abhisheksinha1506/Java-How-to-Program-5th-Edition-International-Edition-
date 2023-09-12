// Fig. 9.13: DemoFont2.java
// Demonstrating the Font methods for
// retrieving font information
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;

public class DemoFont2 extends Applet {
   private Font f;

   public void init()
   {
      // create a font object: 24-point bold italic courier
      f = new Font( "Courier", Font.ITALIC + Font.BOLD, 24 );
   }

   public void paint( Graphics g )
   {
      int style, size;
      String s, name;

      g.setFont( f );          // set the current font to f
      style = f.getStyle();    // determine current font style
      
      if ( style == Font.PLAIN )
         s = "Plain ";
      else if ( style == Font.BOLD )
         s = "Bold ";
      else if ( style == Font.ITALIC )
         s = "Italic ";
      else    // bold + italic
         s = "Bold italic ";

      size = f.getSize();    // determine current font size
      s += size + " point "; 
      name = f.getName();    // determine current font name
      s += name;
      g.drawString( s, 20, 40 );

      // display font family
      g.drawString( "Font family is " + f.getFamily(), 20, 60 );
  }
}
