// Exercise 10.11 solution
// ColorSelect.java
// This program creates a simple GUI
import java.applet.Applet;
import java.awt.*;

public class ColorSelect extends Applet {
   private Button ok, cancel; 
   private Checkbox b, f;
   private Choice colorList;
   private Panel p, p1;

   public void init()
   {
      // applet
      setLayout( new BorderLayout() );

      // north
      colorList = new Choice();
      colorList.addItem( "RED" );
      add( "North", colorList );

      // center
      p = new Panel();
      b = new Checkbox( "background" );
      f = new Checkbox( "foreground" );
      p.add( b );
      p.add( f );
      add( "Center", p );

      // south
      ok = new Button( "Ok" );
      cancel = new Button( "Cancel" );
      p1 = new Panel();
      p1.add( ok );
      p1.add( cancel );
      add( "South", p1 );
   }
}
