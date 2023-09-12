// Fig. 18.8: PrintBits.java
// Printing an unsigned integer in bits 
import java.awt.*;
import java.applet.Applet;

public class PrintBits extends Applet {
   Label prompt, result;
   TextField input, output;

   public void init()
   {
      prompt = new Label( "Enter an integer " );
      input = new TextField( 10 );
      result = new Label( "The integer in bits is" );
      output = new TextField( 32 );
      output.setEditable( false );
      add( prompt );
      add( input );
      add( result );
      add( output );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         int val = Integer.parseInt( o.toString() );
         output.setText( getBits( val ) );
      }
      
      return true;
   }

   public String getBits( int value )
   {
      int displayMask = 1 << 31;
      StringBuffer buf = new StringBuffer( 35 );

      for ( int c = 1; c <= 32; c++ ) {
         buf.append(
            ( value & displayMask ) == 0 ? '0' : '1' );
         value <<= 1;

         if ( c % 8 == 0 )
            buf.append( ' ' );
      }

      return buf.toString();
   }
}


