// Fig. 6.9: FriendlyDataTest.java
// Classes in the same package (i.e., the same directory)
// can access friendly data of other classes in the
// same package.
import java.awt.Graphics;
import java.applet.Applet;

public class FriendlyDataTest extends Applet {
   private FriendlyData d;

   public void init()
   {
      d = new FriendlyData();
   }

   public void paint( Graphics g )
   {
      g.drawString( "After instantiation: ", 25, 25 );
      g.drawString( d.toString(), 40, 40 );

      d.x = 77;
      d.s = new String( "Good bye" );
      g.drawString( "After changing values: ", 25, 55 );
      g.drawString( d.toString(), 40, 70 );
   }
}

class FriendlyData {
   int x;     // friendly instance variable
   String s;  // friendly instance variable

   // constructor
   public FriendlyData() 
   { 
      x = 0; 
      s = new String( "Hello" );
   }               

   public String toString() 
   {
      return "x: " + x + "    s: " + s;
   }
}


