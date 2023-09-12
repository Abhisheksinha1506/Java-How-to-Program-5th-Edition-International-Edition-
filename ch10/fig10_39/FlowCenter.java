// Fig. 10.39: FlowCenter.java
// Demonstrating FlowLayout center alignment.
import java.applet.Applet;
import java.awt.*;

public class FlowCenter extends Applet {
   private TextField t1, t2, t3, t4;
   
   public void init()
   {
      // set layout 
      setLayout( new FlowLayout( FlowLayout.CENTER ) );

      t1 =  new TextField( "Center " );
      t1.setEditable( false );
      add( t1 );

      t2 = new TextField( "Center " );
      t2.setEditable( false );
      add( t2 );

      t3 =  new TextField( "Center " );
      t3.setEditable( false );
      add( t3 );

      t4 = new TextField( "Center " );
      t4.setEditable( false );
      add( t4 );
   }
}
