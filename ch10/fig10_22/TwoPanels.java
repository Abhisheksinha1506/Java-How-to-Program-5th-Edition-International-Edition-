// Fig. 10.22: TwoPanels.java
// Creating Panel objects.
import java.applet.Applet;
import java.awt.*;

public class TwoPanels extends Applet {
   private Panel p1, p2;
   private Label label1, label2;

   public void init()
   {
      p1 = new Panel();   // create a panel object
      p2 = new Panel();   // create a second object
      label1 = new Label( " first panel" );
      label2 = new Label( "second panel" );

      // change p1's background to yellow
      p1.setBackground( Color.yellow );

      // change p2's background to pink
      p2.setBackground( Color.pink );

      p1.add( label1 );    // add label to p1
      p2.add( label2 );    // add label to p2

      add( p1 );    // add panel to applet
      add( p2 );    // add panel to applet
   }
}
