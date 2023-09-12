// Fig. 10.40: FlowRight.java
// Demonstrating FlowLayout right alignment.
import java.applet.Applet;
import java.awt.*;

public class FlowRight extends Applet {
   private TextField t1, t2, t3, t4;
   
   public void init()
   {
      // set layout 
      setLayout( new FlowLayout( FlowLayout.RIGHT ) );

      t1 =  new TextField( "Right " );
      t1.setEditable( false );
      add( t1 );

      t2 = new TextField( "Right " );
      t2.setEditable( false );
      add( t2 );

      t3 =  new TextField( "Right " );
      t3.setEditable( false );
      add( t3 );

      t4 = new TextField( "Right " );
      t4.setEditable( false );
      add( t4 );
   }
}
