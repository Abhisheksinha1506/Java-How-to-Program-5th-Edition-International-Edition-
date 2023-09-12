// Fig. 7.5: Test.java
// Demonstrate when superclass and subclass
// constructors and finalizers are called.
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Circle circle1, circle2;

   public void init()
   {
      circle1 = new Circle( 4.5, 7.2, 2.9 );
      circle2 = new Circle( 10, 5, 5 );
   }

   public void start()
   {
      circle2 = null; // Circle can now be garbage collected
      circle1 = null; // Circle can now be garbage collected

      System.gc();    // call the garbage collector 
   }

   public void paint( Graphics g )
   {
      g.drawString( 
         "See command line or Java Console for output",
         25, 25 );
   }
}
