// Fig. 6.10: ThisTest.java
// Using the this reference to refer to 
// instance variables and methods.
import java.awt.Graphics;
import java.applet.Applet;

public class ThisTest extends Applet {
   private int x = 12;   

   public void paint( Graphics g )
   {
      g.drawString( this.toString(), 25, 25 );
   }

   public String toString() 
   {
      return "x: " + x + "   this.x = " + this.x;
   }
}

