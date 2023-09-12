// Fig. 18.10: MiscBitOps.java
// Using the bitwise AND, bitwise inclusive OR, bitwise
// exclusive OR, and bitwise complement operators.
import java.awt.*;
import java.applet.Applet;

public class MiscBitOps extends Applet {
   Label prompt1, prompt2, in1, in2, res, bitsLabel;
   TextField input1, input2, result, bits1, bits2, bits3;
   Button and, inclusiveOr, exclusiveOr, complement;
   Panel inputPanel, bitsPanel, buttonPanel;

   public void init()
   {
      setLayout( new BorderLayout() );
      inputPanel = new Panel();
      inputPanel.setLayout( new GridLayout( 4, 2 ) );
      prompt1 = new Label( "Enter 2 ints" );
      prompt2 = new Label( "" );
      in1 = new Label( "Value 1" );
      input1 = new TextField( 8 );
      in2 = new Label( "Value 2" );
      input2 = new TextField( 8 );
      res = new Label( "Result" );
      result = new TextField( 8 );
      result.setEditable( false );
      inputPanel.add( prompt1 );
      inputPanel.add( prompt2 );
      inputPanel.add( in1 );
      inputPanel.add( input1 );
      inputPanel.add( in2 );
      inputPanel.add( input2 );
      inputPanel.add( res );
      inputPanel.add( result );      
      bitsPanel = new Panel();
      bitsPanel.setLayout( new GridLayout( 4, 1 ) );
      bitsLabel = new Label( "Bit representations" );
      bits1 = new TextField( 30 );
      bits1.setEditable( false );
      bits2 = new TextField( 30 );
      bits2.setEditable( false );
      bits3 = new TextField( 30 );
      bits3.setEditable( false );
      bitsPanel.add( bitsLabel );
      bitsPanel.add( bits1 );
      bitsPanel.add( bits2 );
      bitsPanel.add( bits3 );
      buttonPanel = new Panel();
      and = new Button( "AND" );
      inclusiveOr = new Button( "Inclusive OR" );
      exclusiveOr = new Button( "Exclusive OR" );
      complement = new Button( "Complement" );
      buttonPanel.add( and );
      buttonPanel.add( inclusiveOr );
      buttonPanel.add( exclusiveOr );
      buttonPanel.add( complement );
      add( "West", inputPanel );
      add( "East", bitsPanel );
      add( "South", buttonPanel );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == complement ) {
         input2.setText( "" );
         bits2.setText( "" );
         int val = Integer.parseInt( input1.getText() );
         result.setText( Integer.toString( ~val ) );
         bits1.setText( getBits( val ) );
         bits3.setText( getBits( ~val ) );
      }
      else {
         int val1 = Integer.parseInt( input1.getText() );
         int val2 = Integer.parseInt( input2.getText() );

         bits1.setText( getBits( val1 ) );
         bits2.setText( getBits( val2 ) );

         if ( e.target == and ) {
            result.setText( Integer.toString( val1 & val2 ) );
            bits3.setText( getBits( val1 & val2 ) );
         }
         else if ( e.target == inclusiveOr ) {
            result.setText( Integer.toString( val1 | val2 ) );
            bits3.setText( getBits( val1 | val2 ) );
         }
         else if ( e.target == exclusiveOr ) {
            result.setText( Integer.toString( val1 ^ val2 ) );
            bits3.setText( getBits( val1 ^ val2 ) );
         }
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

