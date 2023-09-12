// Exercise 8.18 Solution
// FirstB.java
// Program outputs strings that begin with "b"

import java.applet.Applet;
import java.awt.*;

public class FirstB extends Applet {
   private TextField input;
   private Label prompt;
   private TextArea display;

   public void init()
   {
      input = new TextField( 20 );
      prompt = new Label( "Enter a sentence:" );
      display = new TextArea( 4, 20 );
      add( prompt );
      add( input );
      add( display );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         String s = o.toString();

         if ( s.startsWith( "b" ) ) 
            display.appendText( s + "\n" );         
      }

      return true;
   }
}

