// Fig. 10.42: Flow.java
// Demonstrating FlowLayout component spacing.
import java.applet.Applet;
import java.awt.*;

public class Flow extends Applet {
   private TextField t1, t2, t3, t4, t5, t6;
   private Panel p1, p2, p3;
   
   public void init()
   {
      p1 = new Panel();
      p2 = new Panel();
      p3 = new Panel();

      // set layout for panel p1
      p1.setLayout( new FlowLayout( FlowLayout.RIGHT,
                                    0, 10 ) );

      t1 = new TextField( "Text " );
      t2 = new TextField( "Field " );
      p1.add( t1 );
      p1.add( t2 );

      // set layout for panel p2
      p2.setLayout( new FlowLayout( FlowLayout.LEFT,
                                    10, 0 ) );

      t3 = new TextField( "Text " );
      t4 = new TextField( "Field " );
      p2.add( t3 );
      p2.add( t4 );

      p3.setLayout( new FlowLayout( FlowLayout.CENTER,
                                    10, 10 ) );

      t5 = new TextField( "Text " );
      t6 = new TextField( "Field " );
      p3.add( t5 );
      p3.add( t6 );

      // change background colors of panels
      p1.setBackground( Color.pink );
      p2.setBackground( Color.yellow );
      p3.setBackground( Color.cyan );
      add( p1 );
      add( p2 );
      add( p3 );
   }
}
