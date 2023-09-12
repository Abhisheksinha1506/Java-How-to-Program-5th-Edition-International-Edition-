// Fig. 9.4: DrawSCB.java
// Demonstrating drawString, drawChars and drawBytes
import java.applet.Applet;
import java.awt.Graphics;

public class DrawSCB extends Applet {
   private String s = "Using drawString!";
   private char c[] = { 'c', 'h', 'a', 'r', 's', ' ', '8' };
   private byte b[] = { 'b', 'y', 't', 'e', 1, 2, 3 };

   public void paint( Graphics g )
   {
      // draw a string at location (100, 25) on the applet
      g.drawString( s, 100, 25 );

      // draw a series of characters at location (100, 50)
      g.drawChars( c, 2, 3,  100, 50 );

      // draw a series of bytes at location (100, 75)
      g.drawBytes( b, 0, 5, 100, 75 );
   }
}
