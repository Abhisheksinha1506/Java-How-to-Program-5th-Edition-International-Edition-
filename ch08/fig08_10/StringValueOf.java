// Fig. 8.10: StringValueOf.java
// This program demonstrates the String class valueOf methods.
import java.awt.Graphics;
import java.applet.Applet;

public class StringValueOf extends Applet {
   char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
   boolean b = true;
   char c = 'Z';
   int i = 7;
   long l = 10000000;
   float f = 2.5f;
   double d = 33.333;
   Object o = "hello";  // Assign String to Object reference

   public void paint( Graphics g )
   {
      g.drawString( "char array = " +
                    String.valueOf( charArray ), 25, 25 );
      g.drawString( "part of char array = " +
                    String.valueOf( charArray, 3, 3 ),
                    25, 40 );

      g.drawString( "boolean = " + String.valueOf( b ),
                    25, 70 );
      g.drawString( "char = " + String.valueOf( c ),
                    25, 85 );
      g.drawString( "int = " + String.valueOf( i ), 
                    25, 100 );
      g.drawString( "long = " + String.valueOf( l ), 
                    25, 115 );
      g.drawString( "float = " + String.valueOf( f ), 
                    25, 130 );
      g.drawString( "double = " + String.valueOf( d ),
                    25, 145 );
      g.drawString( "Object = " + String.valueOf( o ), 
                    25, 160 );
   }
}
