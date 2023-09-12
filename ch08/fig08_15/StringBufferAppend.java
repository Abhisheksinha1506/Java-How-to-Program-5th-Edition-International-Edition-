// Fig. 8.15: StringBufferAppend.java
// This program demonstrates the append
// methods of the StringBuffer class.
import java.awt.Graphics;
import java.applet.Applet;

public class StringBufferAppend extends Applet {
   Object o = "hello";  // Assign String to Object reference
   String s = "good bye";  
   char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
   boolean b = true;
   char c = 'Z';
   int i = 7;
   long l = 10000000;
   float f = 2.5f;
   double d = 33.333;
   StringBuffer buf;

   public void init()
   {
      buf = new StringBuffer();
   }

   public void start()
   {
      buf.append( o );
      buf.append( ' ' );
      buf.append( s );
      buf.append( ' ' );
      buf.append( charArray );
      buf.append( ' ' );
      buf.append( charArray, 0, 3 );
      buf.append( ' ' );
      buf.append( b );
      buf.append( ' ' );
      buf.append( c );
      buf.append( ' ' );
      buf.append( i );
      buf.append( ' ' );
      buf.append( l );
      buf.append( ' ' );
      buf.append( f );
      buf.append( ' ' );
      buf.append( d );
   }

   public void paint( Graphics g )
   {
      g.drawString( "buf = " + buf.toString(), 25, 25 );
   }
}
