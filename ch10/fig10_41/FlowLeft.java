// Fig. 10.41: FlowLeft.java
// Demonstrating FlowLayout left alignment.
import java.applet.Applet;
import java.awt.*;

public class FlowLeft extends Applet {
   private TextField t1, t2, t3, t4;
   
   public void init()
   {
      // set layout 
      setLayout( new FlowLayout( FlowLayout.LEFT ) );

      t1 =  new TextField( "Left " );
      t1.setEditable( false );
      add( t1 );

      t2 = new TextField( "Left " );
      t2.setEditable( false );
      add( t2 );

      t3 =  new TextField( "Left " );
      t3.setEditable( false );
      add( t3 );

      t4 = new TextField( "Left " );
      t4.setEditable( false );
      add( t4 );
   }
}
