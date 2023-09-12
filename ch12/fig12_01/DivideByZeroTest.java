// Fig. 12.1: DivideByZeroTest.java
// A simple exception handling example.
// Checking for a divide-by-zero-error.
import java.awt.*;
import java.applet.Applet;

public class DivideByZeroTest extends Applet {
   Label prompt1, prompt2;
   TextField input1, input2;
   int number1, number2;
   double result;

   // Initialization
   public void init()
   {
      prompt1 = new Label( "Enter numerator" );
      input1 = new TextField( 10 );
      prompt2 = new Label( "Enter denominator and " +
                           "press Enter" );
      input2 = new TextField( 10 );
      add( prompt1 );
      add( input1 );
      add( prompt2 );
      add( input2 );
   }

   // Process GUI events
   public boolean action( Event event, Object object )
   {
      if ( event.target == input2 ) {
         number1 = Integer.parseInt( input1.getText() );
         input1.setText( "" );
         number2 = Integer.parseInt( input2.getText() );
         input2.setText( "" );

         try {
            result = quotient( number1, number2 );
            showStatus( number1 + " / " + number2 + " = " +
                        Double.toString( result ) );
         }
         catch ( DivideByZeroException exception ) {
            showStatus( exception.toString() );
         }
      }

      return true;
   }

   // Definition of method quotient. Used to demonstrate
   // throwing an exception when a divide-by-zero error
   // is encountered.
   public double quotient( int numerator, int denominator )
      throws DivideByZeroException
   {
      if ( denominator == 0 )
         throw new DivideByZeroException();

      return ( double ) numerator / denominator;
   }
}


