// Fig. 10.38: FlowDefault.java
// Demonstrating FlowLayout default alignment.
import java.applet.Applet;
import java.awt.*;

public class FlowDefault extends Applet {
   private TextField t1, t2, t3, t4;
   
   public void init()
   {
      // use the default layout manager
      // for the applet which is FlowLayout

      t1 =  new TextField( "Default " );
      t1.setEditable( false );
      add( t1 );

      t2 = new TextField( "Default " );
      t2.setEditable( false );
      add( t2 );

      t3 =  new TextField( "Default " );
      t3.setEditable( false );
      add( t3 );

      t4 = new TextField( "Default " );
      t4.setEditable( false );
      add( t4 );
   }
}
