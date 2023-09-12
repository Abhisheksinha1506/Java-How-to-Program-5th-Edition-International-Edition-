// Fig. 4.13: FibonacciTest.java
// Recursive fibonacci method
import java.awt.*;
import java.applet.Applet;

public class FibonacciTest extends Applet {
   Label numLabel, resultLabel;
   TextField num, result;

   public void init()
   {
      numLabel = new Label( "Enter an integer and press return" );
      num = new TextField( 10 );
      resultLabel = new Label( "Fibonacci value is" );
      result = new TextField( 15 );
      result.setEditable( false );

      add( numLabel );
      add( num );
      add( resultLabel );
      add( result );
   }

   public boolean action( Event e, Object o )
   {  
      long number, fibonacciVal;

      number = Long.parseLong( num.getText() );
      showStatus( "Calculating ..." ); 
      fibonacciVal = fibonacci( number );
      showStatus( "Done." );   
      result.setText( Long.toString( fibonacciVal ) );
      return true;
   }
  
   // Recursive definition of method fibonacci
   long fibonacci( long n )
   {
      if ( n == 0 || n == 1 )  // base case
         return n;
      else
         return fibonacci( n - 1 ) + fibonacci( n - 2 );
   }
}
