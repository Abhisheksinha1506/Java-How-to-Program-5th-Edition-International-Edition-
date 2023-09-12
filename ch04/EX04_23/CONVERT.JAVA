// Exercise 4.23 Solution
// Convert.java
// Program converts Fahrenheit to Celcius
// and vice versa.

import java.applet.Applet;
import java.awt.*;

public class Convert extends Applet {
   TextField cInput, fInput;
   Label cLabel, fLabel;

   public void init()
   {
      cInput = new TextField( 4 );
      fInput = new TextField( 4 );
      cLabel = new Label( "Celcius:" );
      fLabel = new Label( "Fahrenheit:" );
      add( cLabel );
      add( cInput );
      add( fLabel );
      add( fInput );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == cInput ) {
         int c = Integer.parseInt( cInput.getText() );
         fInput.setText( String.valueOf( celcius( c ) ) );
         showStatus( "Celcius to Fahrenheit" );
      }
      else if ( e.target == fInput ) {
         int f = Integer.parseInt( fInput.getText() );
         cInput.setText( String.valueOf( fahrenheit( f ) ) );
         showStatus( "Fahrenheit to Celcius" );
      }

      return true;
   }

   public int celcius( int cTemp )
   {
      return ( ( int ) ( 9.0 / 5.0 * cTemp + 32 ) );
   }

   public int fahrenheit( int fTemp )
   {
      return ( ( int ) ( 5.0 / 9.0 * ( fTemp - 32 ) ) );       
   }
}
