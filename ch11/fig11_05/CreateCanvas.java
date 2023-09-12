// Fig. 11.5: CreateCanvas.java
// Creating a Canvas.
import java.applet.Applet;
import java.awt.*;

public class CreateCanvas extends Applet {
   private Canvas c;

   public void init()
   {
      c = new Canvas();  // instantiate object
      c.setBackground( Color.green );
      c.resize( 250, 60 );

      add( c ); 
   }
}
