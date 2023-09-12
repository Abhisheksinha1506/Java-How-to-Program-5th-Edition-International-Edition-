// Fig. 10.26: MouseEnterExit.java
// Demonstrating methods mouseEnter and mouseExit.
import java.applet.Applet;
import java.awt.*;

public class MouseEnterExit extends Applet {
   private Label l;
   private List t;

   public void init()
   {
      t = new List( 3, false );
      l = new Label( "Measure in: " );

      t.addItem( "Metric system" );
      t.addItem( "Marak system" );
      t.addItem( "English system" );

      add( l );
      add( t );
   }

   public boolean mouseEnter( Event e, int x, int y )
   {
      showStatus( "Entered area of applet" );
      return true;   // event has been handled
   }

   public boolean mouseExit( Event e, int x, int y )
   {
      showStatus( "Exited area of applet" );
      return true;   // event has been handled
   }
}
