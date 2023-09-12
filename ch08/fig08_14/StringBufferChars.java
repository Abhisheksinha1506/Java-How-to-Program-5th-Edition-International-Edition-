// Fig. 8.14: StringBufferChars.java
// The charAt, setCharAt, and getChars methods 
// of class StringBuffer.
import java.awt.Graphics;                  
import java.applet.Applet;

public class StringBufferChars extends Applet {
   StringBuffer buf;
   char charArray[];

   public void init()
   {
      buf = new StringBuffer( "hello there" );
      charArray = new char[ 100 ];
   }

   public void paint ( Graphics g )
   {
      g.drawString( "buf = " + buf.toString(), 25, 25 );
      g.drawString( "Character at 0: " + buf.charAt( 0 ),
                    25, 40 );
      g.drawString( "Character at 4: " + buf.charAt( 4 ),
                    25, 55 );

      buf.getChars( 0, buf.length(), charArray, 0 );
      g.drawString( "The characters are: ", 25, 85 );
      g.drawChars( charArray, 0, charArray.length, 142, 85 );

      buf.setCharAt( 0, 'H' );
      buf.setCharAt( 6, 'T' );
      g.drawString( "buf = " + buf.toString(), 25, 115 );
   }
}

