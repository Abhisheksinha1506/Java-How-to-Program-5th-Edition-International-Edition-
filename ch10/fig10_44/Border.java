// Fig. 10.44: Border.java
// Demonstrating BorderLayout.
import java.applet.Applet;
import java.awt.*;

public class Border extends Applet {
   private Button centerButton, eastButton, northButton,
                  westButton, southButton;

   public void init()
   {
      // instantiate button objects
      centerButton =  new Button( "center Button" );
      westButton = new Button( "west Button" );
      eastButton = new Button( "east Button" );
      southButton = new Button( "south Button" );
      northButton = new Button( "north Button");

      // set layout to border layout
      setLayout( new BorderLayout() );

      // order not important
      add( "South", southButton );    // South position
      add( "North", northButton );    // North position
      add( "East", eastButton );      // East position
      add( "Center", centerButton );  // Center position
      add( "West", westButton );      // West position
   }
}
