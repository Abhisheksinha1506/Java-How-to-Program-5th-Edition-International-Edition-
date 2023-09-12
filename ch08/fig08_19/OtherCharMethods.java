// Fig. 8.19: OtherCharMethods.java
// Demonstrate the non-static methods of class
// Character from the java.lang package.
import java.awt.Graphics;
import java.applet.Applet;

public class OtherCharMethods extends Applet {
   Character c1, c2;

   public void init()
   {
      c1 = new Character( 'A' );
      c2 = new Character( 'a' );
   }

   public void paint( Graphics g )
   {
      g.drawString( "c1 = " + c1.charValue(), 25, 25 );
      g.drawString( "c2 = " + c2.toString(), 25, 40 );
      g.drawString( "hash code for c1 = " +
                    c1.hashCode(), 25, 70 );
      g.drawString( "hash code for c2 = " +
                    c2.hashCode(), 25, 85 );

      if (  c1.equals( c2 ) )
         g.drawString( "c1 and c2 are equal", 25, 115 );
      else
         g.drawString( "c1 and c2 are not equal", 25, 115 );
   }
}
