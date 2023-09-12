// Fig. 18.13: BitShift.java
// Using the bitwise shift operators.
import java.awt.*;
import java.applet.Applet;

public class BitShift extends Applet {
   Label prompt;
   TextField value, bits;
   Button left, rightSign, rightZero;

   public void init()
   {
      prompt = new Label( "Integer to shift " );
      value = new TextField( 8 );
      bits = new TextField( 30 );
      bits.setEditable( false );
      left = new Button( "<<" );
      rightSign = new Button( ">>" );
      rightZero = new Button( ">>>" );
      add( prompt );      
      add( value );      
      add( bits );      
      add( left );      
      add( rightSign );      
      add( rightZero );      
   }

   public boolean action( Event e, Object o )
   {
      int val = Integer.parseInt( value.getText() );

      if ( e.target instanceof Button ) {
         if ( e.target == left )
            val <<= 1;
         else if ( e.target == rightSign ) 
            val >>= 1;
         else if ( e.target == rightZero )
            val >>>= 1;

         value.setText( Integer.toString( val ) );
      }

      bits.setText( getBits( val ) );
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

