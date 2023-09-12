// Fig. 10.48: Grid.java
// Demonstrating GridLayout.
import java.applet.Applet;
import java.awt.*;

public class Grid extends Applet {
   private Button button1, button2, button3,
                  button4, button5;

   public void init()
   {
      // instantiate button objects
      button1 =  new Button( "one" );
      button2 = new Button( "two" );
      button3 = new Button( "three" );
      button4 = new Button( "four" );
      button5 = new Button( "five");

      // set layout to grid layout
      setLayout( new GridLayout( 2, 3 ) );

      // order is important
      add( button1 );    // row 1 column 1
      add( button2 );    // row 1 column 2
      add( button3 );    // row 1 column 3
      add( button4 );    // row 2 column 1
      add( button5 );    // row 2 column 2
   }
}
