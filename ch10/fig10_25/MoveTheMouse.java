// Fig. 10.25: MoveTheMouse.java
// Demonstrating method mouseMove.
import java.applet.Applet;
import java.awt.*;

public class MoveTheMouse extends Applet {

   public boolean mouseMove( Event e, int x, int y )
   {
      showStatus( "mouse at (" + x + ", " + y + ")" );
      return true;   // event has been handled
   }
}
