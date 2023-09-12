// Fig. 8.13: StringBufferCapLen.java
// This program demonstrates the length and
// capacity methods of the StringBuffer class.
import java.awt.Graphics;
import java.applet.Applet;

public class StringBufferCapLen extends Applet {
   StringBuffer buf;

   public void init()
   {
      buf = new StringBuffer( "hello" );
   }

   public void paint ( Graphics g )
   {
      g.drawString( "buf = " + buf.toString(), 25, 25  );
      g.drawString( "length = " + buf.length(), 25, 40 );
      g.drawString( "capacity = " + buf.capacity(),
                    25, 55 );

      buf.ensureCapacity( 50 );
      g.drawString( "New capacity = " + buf.capacity(),
                    25, 85 );

      buf.setLength( 10 );
      g.drawString( "New length = " + buf.length(),
                    25, 115 );
   }
}
