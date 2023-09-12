// Fig. 11.3: MyTextArea.java
// Creating TextArea objects.
import java.applet.Applet;
import java.awt.*;

public class MyTextArea extends Applet {
   private TextArea t1, t2;
 
   public void init() 
   {      
      t1 = new TextArea( "This text is read-only!",
                         10, 20 );   // 10 x 20
      t2 = new TextArea( 10, 20 );

      t1.setEditable( false );      // read-only

      // set layout
      setLayout( new FlowLayout( FlowLayout.LEFT ) );

      add( t1 );
      add( t2 );
   }
}
