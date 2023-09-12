// Exercise 18.18 Solution
// BitShift2.java
// Using the bitwise shift operators

import java.applet.Applet;
import java.awt.*;

public class BitShift2 extends Applet {
   Label prompt;
   TextField value, bits;
   Button multiply, divide;

   public void init()
   {
      prompt = new Label( "Integer to shift " );
      value = new TextField( 8 );
      bits = new TextField( 30 );
      bits.setEditable( false );
      multiply = new Button( "*" );
      divide = new Button( "/" );
      add( prompt );      
      add( value );      
      add( bits );          
      add( multiply );      
      add( divide );      
   }

   public boolean action( Event e, Object o )
   {
      int val = Integer.parseInt( value.getText() );
     
      if ( e.target instanceof Button ) {
         showStatus( "Bits before shift: " + getBits( val ) );

         if ( e.target == multiply ) 
            val <<= 1;
         else   // divide 
            val >>= 2;

         value.setText( Integer.toString( val ) );
         bits.setText( getBits( val ) );
      }

      return true;
   }

   public String getBits( int value )
   {
      int displayMask = 1 << 31;
      StringBuffer buf = new StringBuffer( 35 );

      for ( int c = 1; c <= 32; c++ ) {
         buf.append( ( value & displayMask ) == 0 ? '0' : '1' );
         value <<= 1;

         if ( c % 8 == 0 )
            buf.append( ' ' );
      }

      return buf.toString();
   }
}

