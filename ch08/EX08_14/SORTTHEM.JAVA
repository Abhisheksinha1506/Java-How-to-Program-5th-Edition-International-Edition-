// Exercise 8.14 Solution
// SortThem.java
// Program sorts strings

import java.applet.Applet;
import java.util.*;
import java.awt.*;

public class SortThem extends Applet {
   private TextField input;
   private Label prompt;
   private TextArea output;

   public void init()
   {
      input = new TextField( 10 );
      output = new TextArea( 10, 10 );
      prompt = new Label( "Enter a String:" );

      add( prompt );
      add( input );
      add( output );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input ) {
         String newString = input.getText();
         String oldString = output.getText();         
         StringTokenizer t = new StringTokenizer( oldString );
         int number = t.countTokens(), c = 0;
         String tokens[] = new String[ number + 1 ];

         input.setText( "" );
         output.setText( "" );

         while ( t.hasMoreTokens() && c < number )
            tokens[ c++ ] = t.nextToken();

         tokens[ c ] = newString;
         bubbleSort( tokens );
            
         for ( int k = 0; k < tokens.length; k++ )
            output.appendText( tokens[ k ] + "\n" );
      }

      return true;
   }

   private void bubbleSort( String s[] )
   {
      for ( int pass = 1; pass < s.length; pass++ )
         for ( int c = 0; c < s.length - pass; c++ )
            if ( s[ c ].compareTo( s[ c + 1 ] ) > 0 ) {
               String temp = s[ c ];
               s[ c ] = s[ c + 1 ];
               s[ c + 1 ] = temp;
            }               
   }
}
