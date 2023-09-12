// Fig. 8.5: StringHashCode.java
// This program demonstrates the method 
// hashCode of the String class.
import java.awt.Graphics;
import java.applet.Applet;

public class StringHashCode extends Applet {
   String s1 = "hello",
          s2 = "Hello";

   public void paint( Graphics g )
   {
      g.drawString( "The hash code for \"" +
         s1 + "\" is " + s1.hashCode(), 25, 25 );
      g.drawString( "The hash code for \"" +
         s2 + "\" is " + s2.hashCode(), 25, 40 );
   }
}
