// Fig. 8.12: StringBufferConstructors.java
// This program demonstrates the StringBuffer constructors.
import java.awt.Graphics;
import java.applet.Applet;

public class StringBufferConstructors extends Applet {
   StringBuffer buf1, buf2, buf3;
   
   public void init()
   {
      buf1 = new StringBuffer();
      buf2 = new StringBuffer( 10 );
      buf3 = new StringBuffer( "hello" );
   }

   public void paint( Graphics g )
   {
      g.drawString( "buf1 = " + "\"" + buf1.toString() + "\"",
                    25, 25 );
      g.drawString( "buf2 = " + "\"" + buf2.toString() + "\"",
                    25, 40 );
      g.drawString( "buf3 = " + "\"" + buf3.toString() + "\"",
                    25, 55 );
   }
}
