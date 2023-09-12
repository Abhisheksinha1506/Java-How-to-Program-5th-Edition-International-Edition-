// Fig. 8.18: StaticCharMethods2.java
// Demonstrates the static character conversion methods
// of class Character from the java.lang package.
import java.awt.*;
import java.applet.Applet;

public class StaticCharMethods2 extends Applet {
   char c;
   int digit, radix;
   boolean charToDigit;
   Label prompt1, prompt2;
   TextField input, radixField;
   Button toChar, toInt;

   public void init()
   {
      c = 'A';
      radix = 16;
      charToDigit = true;

      prompt1 = new Label( "Enter a digit or character " );
      input = new TextField( "A", 5 );
      prompt2 = new Label( "Enter a radix " );
      radixField = new TextField( "16", 5 );
      toChar = new Button( "Convert digit to character" );
      toInt = new Button( "Convert character to digit" );
      add( prompt1 );
      add( input );
      add( prompt2 );
      add( radixField );
      add( toChar );
      add( toInt );
   }

   public void paint( Graphics g )
   {
      if ( charToDigit ) 
         g.drawString( "Convert character to digit: " +
            Character.digit( c, radix ), 25, 125 );
      else 
         g.drawString( "Convert digit to character: " +
            Character.forDigit( digit, radix ), 25, 125 );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == toChar ) {
         charToDigit = false;
         digit = Integer.parseInt( input.getText() );
         radix = Integer.parseInt( radixField.getText() );
         repaint();
      }
      else if ( e.target == toInt ) {
         charToDigit = true;
         String s = input.getText();
         c = s.charAt( 0 );
         radix = Integer.parseInt( radixField.getText() );
         repaint();
      }

      return true;
   }
}
