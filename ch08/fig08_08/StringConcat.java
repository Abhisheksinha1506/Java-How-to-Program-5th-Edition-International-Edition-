// Fig. 8.8: StringConcat.java
// This program demonstrates the String class concat method.
// Note that the concat method returns a new String object. It
// does not modify the object that invoked the concat method.
import java.awt.Graphics;
import java.applet.Applet;

public class StringConcat extends Applet {
   String s1 = new String( "Happy " ),
          s2 = new String( "Birthday" );

   public void paint( Graphics g )
   {
      g.drawString( "s1 = " + s1, 25, 25 );      
      g.drawString( "s2 = " + s2, 25, 40 );      
      g.drawString( "Result of s1.concat( s2 ) = " +
                    s1.concat( s2 ), 25, 55 );
      g.drawString( "s1 after concatenation = " + s1,
                    25, 70 );
   }
}
