// Fig. 11.4: MyTextArea2.java
// Copying selected text from one text area to another.
import java.applet.Applet;
import java.awt.*;

public class MyTextArea2 extends Applet {
   private TextArea t1, t2;
   private Button b;

   public void init() 
   {
      String s = "The big bad boy stepped up\n" +
                 "to the microphone. The crowd\n" +
                 "sat on the edge of their seats\n" +
                 "and waited...";

      t1 = new TextArea( 5, 20 );
      t1.setText( s );    // add text to t1

      t2 = new TextArea( 5, 20 );
      b = new Button( "Copy >>>" );

      // set layout
      setLayout( new FlowLayout( FlowLayout.LEFT, 5, 5 ) );

      add( t1 );
      add( b );
      add( t2 );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == b ) {
         t2.setText( t1.getSelectedText() );
         return true;
      }

      return false;
   }
}
