// Displaying multiple strings
import java.applet.Applet;  // import Applet class
import java.awt.Graphics;   // import Graphics class

public class Welcome extends Applet {  
   public void paint( Graphics g )
   {
      g.drawString( "Welcome to", 25, 25 );
      g.drawString( "Java Programming", 25, 40 );
   }
}
