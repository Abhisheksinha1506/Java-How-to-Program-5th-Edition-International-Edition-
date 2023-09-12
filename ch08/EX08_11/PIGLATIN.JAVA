// Exercise 8.11 Solution
// PigLatin.java
// Program translates English to pig Latin

import java.applet.Applet;
import java.util.*;
import java.awt.*;

public class PigLatin extends Applet {
   private Label prompt;
   private TextField input;
   private TextArea output;
   private int count;

   public void init()
   {
      prompt = new Label( "Enter English phrase:" );
      input = new TextField( 50 );
      output = new TextArea( 10, 30 );
      output.setEditable( false );
      add( prompt );
      add( input );
      add( output );
   }

   public boolean action( Event e, Object o )
   {      
      String s = o.toString();
      StringTokenizer tokens = new StringTokenizer( s );

      count = tokens.countTokens();

      while ( tokens.hasMoreTokens() ) {
         count--;
         printLatinWord( tokens.nextToken() );
      }

      return true;
   }

   private void printLatinWord( String token )
   {
       char letters[] = token.toCharArray();      
       StringBuffer schweinLatein = new StringBuffer();

       schweinLatein.append( letters, 1, letters.length - 1 ) ;
       schweinLatein.append( Character.toLowerCase( letters[ 0 ] ) );
       schweinLatein.append( "ay" );

       output.appendText( schweinLatein.toString() + " " );

       if ( count == 0 )
          output.appendText( "\n" );
   }
}

