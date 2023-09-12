// Fig. 9.15: DemoFont3.java
// Demonstrating isPlain, isBold and isItalic
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;

public class DemoFont3 extends Applet {
   private Font f;

   public void init()
   {
      // create a font object: 24-point bold italic courier
      f = new Font( "Courier", Font.ITALIC + Font.BOLD, 24 );
   }

   public void paint( Graphics g )
   {
      String s;

      g.setFont( f );          // set the current font to f 
      
      if ( f.isPlain() == true )
         s = "Font is plain.";
      else if ( f.isBold() == true && f.isItalic() == false )
         s = "Font is bold.";
      else if ( f.isItalic() == true && f.isBold() == false )
         s = "Font is italic.";
      else    // bold + italic
         s = "Font is bold italic.";

      g.drawString( s, 20, 40 );
  }
}
