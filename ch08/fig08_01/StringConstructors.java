// Fig. 8.1: StringConstructors.java
// This program demonstrates the String class constructors.
import java.awt.Graphics;
import java.applet.Applet;

public class StringConstructors extends Applet {
   char charArray[] = { 'b', 'i', 'r', 't', 'h', ' ',
                        'd', 'a', 'y' };
   byte byteArray[] = { 'n', 'e', 'w', ' ',
                        'y', 'e', 'a', 'r' };
   StringBuffer buffer;
   String s, s1, s2, s3, s4, s5, s6, s7;
   
   public void init()
   {
      s = new String( "hello" );
      buffer = new StringBuffer();
      buffer.append( "Welcome to Java Programming!" );

      // use the String constructors
      s1 = new String();
      s2 = new String( s );
      s3 = new String( charArray );
      s4 = new String( charArray, 6, 3 );
      s5 = new String( byteArray, 0, 4, 4 );
      s6 = new String( byteArray, 0 );
      s7 = new String( buffer );
   }

   public void paint( Graphics g ) 
   {
      g.drawString( "s1 = " + s1, 25, 25 );
      g.drawString( "s2 = " + s2, 25, 40 );
      g.drawString( "s3 = " + s3, 25, 55 );
      g.drawString( "s4 = " + s4, 25, 70 );
      g.drawString( "s5 = " + s5, 25, 85 );
      g.drawString( "s6 = " + s6, 25, 100 );
      g.drawString( "s7 = " + s7, 25, 115 );
   }
}


