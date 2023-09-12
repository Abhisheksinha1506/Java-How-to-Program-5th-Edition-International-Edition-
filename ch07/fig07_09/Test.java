// Fig. 7.9: Test.java
// Driver for Employee hierarchy
import java.awt.Graphics;
import java.applet.Applet;

public class Test extends Applet {
   private Employee ref;  // base-class reference
   private Boss b;
   private CommissionWorker c;
   private PieceWorker p;
   private HourlyWorker h;

   public void init()
   {
      b = new Boss( "John", "Smith", 800.00 );
      c = new CommissionWorker( "Sue", "Jones", 
                                400.0, 3.0, 150);
      p = new PieceWorker( "Bob", "Lewis", 2.5, 200 );
      h = new HourlyWorker( "Karen", "Price", 13.75, 40 );
   }

   public void paint( Graphics g )
   {
      ref = b;  // superclass reference to subclass object
      g.drawString( ref.toString() + " earned $" +
                    ref.earnings(), 25, 25 );
      g.drawString( b.toString() + " earned $" +
                    b.earnings(), 25, 40 );
   
      ref = c;  // superclass reference to subclass object
      g.drawString( ref.toString() + " earned $" +
                    ref.earnings(), 25, 55 );
      g.drawString( c.toString() + " earned $" + 
                    c.earnings(), 25, 70 );
   
      ref = p;  // superclass reference to subclass object
      g.drawString( ref.toString() + " earned $" + 
                    ref.earnings(), 25, 85 );
      g.drawString( p.toString() + " earned $" + 
                    p.earnings(), 25, 100 );
   
      ref = h;  // superclass reference to subclass object
      g.drawString( ref.toString() + " earned $" + 
                    ref.earnings(), 25, 115 );
      g.drawString( h.toString() + " earned $" + 
                    h.earnings(), 25, 130 );
   }
}
