// Fig. 10.45: Border2.java
// Demonstrating BorderLayout with four components.
import java.applet.Applet;
import java.awt.*;

public class Border2 extends Applet {
   private Button centerButton, northButton,
                  westButton, southButton;

   public void init()
   {
      // instantiate button objects
      centerButton =  new Button( "center Button" );
      westButton = new Button( "west Button" );
      southButton = new Button( "south Button" );
      northButton = new Button( "north Button");

      // set layout to border layout
      setLayout( new BorderLayout() );

      // order not important
      add( "South", southButton );    // South position
      add( "North", northButton );    // North position
      add( "Center", centerButton );  // Center position
      add( "West", westButton );      // West position
   }
}
