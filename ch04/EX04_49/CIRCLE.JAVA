// Exercise 4.49 Solution
// Circle.java
// Program calulates the area of a circle

import java.applet.Applet;
import java.awt.*;

public class Circle extends Applet {
   TextField input;
   Label instruction;

   public void init()
   {
      input = new TextField( 4 );
      instruction = new Label( "Enter the radius: " );
      add( instruction );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      showStatus( "" );

      if ( e.target == input ) {
         int r = Integer.parseInt( input.getText() );
         circleArea( r );
      }

      return true;
   }

   public void circleArea( int radius )
   {
      showStatus( "Area is " + radius * radius * Math.PI );
   }
}
