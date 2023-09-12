// Exercise 17.10 Solution
// StackInheritanceTest.java
// Program prints the words of a line in reverse

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class StackInheritanceTest extends Applet {
   private StackInheritance objStack;
   private Label prompt;
   private TextField input, output;
   private Panel p;

   public void init()
   {      
      objStack = new StackInheritance();
      prompt = new Label( "Enter String:" );
      input = new TextField( 20 );
      output = new TextField( 15 );
      output.setEditable( false );

      p = new Panel();
      p.add( prompt );
      p.add( input );
      setLayout( new BorderLayout() );
      add( "North", p );
      add( "South", output );
   }

   public boolean action( Event e, Object o ) {

      if ( e.target == input ) {
         String text = input.getText();
         StringTokenizer s = new StringTokenizer( text );
         StringBuffer buffer = new StringBuffer( text.length() );

         while ( s.hasMoreTokens() )
            objStack.push( s.nextToken() );

         // build reverse string
         Object removedObj = null;

         try {
            while ( !objStack.isEmpty() ) {
               removedObj = objStack.pop();
               buffer.append( removedObj.toString() + " " );
            }
         }
         catch ( EmptyListException ex ) {
            System.err.println( "\n" + ex.toString() );
         }

         output.setText( buffer.toString() );         
      }

      return true;
   }
}

