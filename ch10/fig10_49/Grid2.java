// Fig. 10.49: Grid2.java
// Demonstrating GridLayout component spacing.
import java.applet.Applet;
import java.awt.*;

public class Grid2 extends Applet {
   private Button button1, button2, button3,
                  button4, button5, button6;

   public void init()
   {
      // instantiate button objects
      button1 = new Button( "one" );
      button2 = new Button( "two" );
      button3 = new Button( "three" );
      button4 = new Button( "four" );
      button5 = new Button( "five");
      button6 = new Button( "six" );

      // set layout to grid layout
      setLayout( new GridLayout( 2, 3, 20, 25 ) );

      // order is important
      add( button1 );    // row 1 column 1
      add( button2 );    // row 1 column 2
      add( button3 );    // row 1 column 3
      add( button4 );    // row 2 column 1
      add( button5 );    // row 2 column 2
      add( button6 );    // row 2 column 3
   }
}
