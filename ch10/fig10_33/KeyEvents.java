// Fig. 10.33: KeyEvents.java
// Demonstrating keyboard Event constants.
import java.applet.Applet;
import java.awt.*;

public class KeyEvents extends Applet {
   private TextField t;

   public void init()
   {
      t = new TextField( 25 );
      t.setEditable( false );
      add( t );
   }

   public boolean handleEvent( Event e )
   {
      // determine which key event occured
      switch ( e.key ) {
         case Event.PGUP:
            t.setText( "PageUp key" );
            return true;

         case Event.PGDN:
            t.setText( "PageDown key" );
            return true;

         case Event.END:
            t.setText( "End key" );
            return true;

         case Event.RIGHT:
            t.setText( "Right arrow key");
            return true;

         case Event.LEFT:
            t.setText( "Left arrow key");
            return true;

         case Event.UP:
            t.setText( "Up arrow key" );
            return true;

         case Event.DOWN:
            t.setText( "Down arrow key" );
            return true;

         case Event.HOME:
            t.setText( "Home key" );
            return true;

         case Event.F1: case Event.F2: case Event.F3:
         case Event.F4: case Event.F5: case Event.F6:
         case Event.F7: case Event.F8: case Event.F9:
         case Event.F10: case Event.F11: case Event.F12:
            t.setText( "A function key ( F1 - F12 )" );
            return true;
      }

      // not one of our key events
      t.setText( "Not a special key!" );
      return true;  // done processing
   }
}
