// Fig. 8.16: StringBufferInsert.java
// This program demonstrates the insert
// methods of the StringBuffer class.
import java.awt.Graphics;
import java.applet.Applet;

public class StringBufferInsert extends Applet {
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
      buf.insert( 0, o );
      buf.insert( 0, ' ' );
      buf.insert( 0, s );
      buf.insert( 0, ' ' );
      buf.insert( 0, charArray );
      buf.insert( 0, ' ' );
      buf.insert( 0, b );
      buf.insert( 0, ' ' );
      buf.insert( 0, c );
      buf.insert( 0, ' ' );
      buf.insert( 0, i );
      buf.insert( 0, ' ' );
      buf.insert( 0, l );
      buf.insert( 0, ' ' );
      buf.insert( 0, f );
      buf.insert( 0, ' ' );
      buf.insert( 0, d );
   }

   public void paint( Graphics g )
   {
      g.drawString( "buf = " + buf.toString(), 25, 25 );
   }
}
