// Fig. 10.11: MyTextfield.java
// Demonstrating the TextField class constructors.
import java.applet.Applet;
import java.awt.*;

public class MyTextfield extends Applet {
   private TextField text1, text2, text3, text4;

   public void init()
   {
      // construct textfield with default sizing
      text1 = new TextField();

      // construct textfield with default text
      text2 = new TextField( "Some text " );

      // construct textfield with 25 elements visible
      text3 = new TextField( 25 );

      // construct textfield with default text and
      // 40 visible elements
      text4 = new TextField( "Yet some more text", 40 );

      // add textfields to applet
      add( text1 );
      add( text2 );
      add( text3 );
      add( text4 );
   }
}
