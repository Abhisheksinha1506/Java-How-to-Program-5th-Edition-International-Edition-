// Fig. 8.17: StaticCharMethods.java
// Demonstrates the static character testing methods
// and case conversion methods of class Character
// from the java.lang package.
import java.awt.*;
import java.applet.Applet;

public class StaticCharMethods extends Applet {
   char c;
   Label prompt;
   TextField input;

   public void init()
   {
      c = 'A';

      prompt = new Label( "Enter a character and press Enter" );
      input = new TextField( "A", 5 );
      add( prompt );
      add( input );
   }

   public void paint( Graphics g )
   {
      g.drawString( "is defined: " +
         Character.isDefined( c ), 25, 40 );
      g.drawString( "is digit: " +
         Character.isDigit( c ), 25, 55 );
      g.drawString( "is Java letter: " +
         Character.isJavaLetter( c ), 25, 70 );
      g.drawString( "is Java letter or digit: " +
         Character.isJavaLetterOrDigit( c ), 25, 85 );
      g.drawString( "is letter: " +
         Character.isLetter( c ), 25, 100 );
      g.drawString( "is letter or digit: " +
         Character.isLetterOrDigit( c ), 25, 115 );
      g.drawString( "is lower case: " +
         Character.isLowerCase( c ), 25, 130 );
      g.drawString( "is upper case: " +
         Character.isUpperCase( c ), 25, 145 );
      g.drawString( "to upper case: " +
         Character.toUpperCase( c ), 25, 160 );
      g.drawString( "to lower case: " +
         Character.toLowerCase( c ), 25, 175 );
   }

   public boolean action( Event e, Object o )
   {  
      String s = o.toString();
      c = s.charAt( 0 );
      repaint();
      return true;
   }
}
