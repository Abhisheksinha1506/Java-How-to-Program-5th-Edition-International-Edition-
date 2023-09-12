// Fig. 18.15: BitSetTest.java                                
// Using a BitSet to demonstrate the Sieve of Eratosthenes.
import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class BitSetTest extends Applet {
   BitSet sieve;
   Panel inputPanel;
   Label inputLabel;
   TextField input;
   TextArea primes;

   public void init()
   {
      sieve = new BitSet( 1024 );

      setLayout( new BorderLayout() );
      inputLabel = new Label( "Enter a value from 1 to 1023" );
      input = new TextField( 10 );                           
      inputPanel = new Panel();
      inputPanel.add( inputLabel );
      inputPanel.add( input );
      add( "North", inputPanel );

      primes = new TextArea();
      add( "Center", primes );

      // set all bits from 1 to 1023
      int size = sieve.size();

      for ( int i = 1; i < size; i++ )
         sieve.set( i );

      // perform Sieve of Eratosthenes
      int finalBit = (int) Math.sqrt( sieve.size() );

      for ( int i = 2; i < finalBit; i++ ) 
         if ( sieve.get( i ) ) 
            for ( int j = 2 * i; j < size; j += i ) 
               sieve.clear( j );

      int counter = 0;

      for ( int i = 1; i < size; i++ )
         if ( sieve.get( i ) ) {
            primes.appendText( String.valueOf( i ) );
            primes.appendText(
               ++counter % 7 == 0 ? "\n" : "\t" );
         }
            
   }

   public boolean action( Event e, Object o )
   {
      int val = Integer.parseInt( input.getText() );

      if ( sieve.get( val ) )
         showStatus( val + " is a prime number" );
      else
         showStatus( val + " is not a prime number" );

      return true;
   }
}
