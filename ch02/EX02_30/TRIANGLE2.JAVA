// Execise 2.30 Solution
// Triangle2.java
// Program takes three integers and
// determines if they form the sides
// of a right triangle

import java.applet.Applet;
import java.awt.*;

public class Triangle2 extends Applet {
   Label sideLabel1;
   Label sideLabel2;
   Label hyptLabel;
   TextField side1Input;
   TextField side2Input;
   TextField hyptInput;
   int side1, side2, hypotenuse;

   public void init()
   {
      sideLabel1 = new Label( "Enter side 1:" );
      sideLabel2 = new Label( "Enter side 2:" );
      hyptLabel = new Label( "Enter hypotenuse:" );

      side1Input = new TextField( 5 );
      side2Input = new TextField( 5 );
      hyptInput = new TextField( 5 );

      add( sideLabel1 );
      add( side1Input );
      add( sideLabel2 );
      add( side2Input );
      add( hyptLabel );
      add( hyptInput );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == hyptInput ) {
         side1 = Integer.parseInt( side1Input.getText() );
         side2 = Integer.parseInt( side2Input.getText() );
         hypotenuse = Integer.parseInt( hyptInput.getText() );

         if ( ( side1 * side1 + side2 * side2 ) ==
              ( hypotenuse * hypotenuse ) )

            showStatus( "These form a right triangle." );
         else
            showStatus( "These do not form a right triangle." );

      }

      return true;
   }
}
