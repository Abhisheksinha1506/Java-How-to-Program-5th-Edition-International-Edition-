// Fig. 8.20: TokenTest.java
// Testing the StringTokenizer class of the java.util package
import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class TokenTest extends Applet {
   // GUI components
   Label prompt;
   TextField input;
   TextArea output;

   public void init()
   {
      prompt = new Label( "Enter a sentence and press Enter" );
      input = new TextField( 50 );
      output = new TextArea( 10, 30 );
      output.setEditable( false );
      add( prompt );
      add( input );
      add( output );
   }

   public boolean action( Event e, Object o )
   {      
      String stringToTokenize = o.toString();
      StringTokenizer tokens =
         new StringTokenizer( stringToTokenize );

      output.setText( "" );

      output.appendText( "Number of elements: " +
         tokens.countTokens() + "\nThe tokens are:\n" );

      while ( tokens.hasMoreTokens() )
         output.appendText( tokens.nextToken() + "\n" );

      return true;
   }
}

