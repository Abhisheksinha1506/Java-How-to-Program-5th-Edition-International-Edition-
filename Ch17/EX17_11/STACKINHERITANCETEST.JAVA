// Exercise 17.11 Solution
// StackInheritanceText.java
// Program tests for a palindrome

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class StackInheritanceTest extends Applet {
   private StackInheritance objStack;
   private Label prompt;
   private TextField input;

   public void init()
   {      
      objStack = new StackInheritance();
      prompt = new Label( "Enter String:" );
      input = new TextField( 20 );       

      setLayout( new BorderLayout() );
      add( "North", prompt );
      add( "South", input );
   }

   public boolean action( Event e, Object o ) {

      if ( e.target == input ) {
         String text = input.getText();
         char m = '\0';

         for ( int i = 0; i < text.length(); i++ ) {
            m = text.charAt( i );

            if ( Character.isLetter( m ) )
               objStack.push( new Character( m ) );
         }
         
         Object removedObj = null;
         boolean flag = false;
         char letter = '\0';

         try {
            for ( int c = 0; c < text.length() && !objStack.isEmpty(); c++ ) {
               letter = text.charAt( c );

               if ( !Character.isLetter( letter ) )
                  continue;               

               removedObj = objStack.pop();

               if ( letter != ( ( Character ) removedObj ).charValue() ) {
                  flag = true;                  
                  break;
               }
            }

            if ( flag == false )
               showStatus( "Palindrome" );
            else
               showStatus( "Not a Palindrome" );
         }
         catch ( EmptyListException ex ) {
            System.err.println( "\n" + ex.toString() );
         }
      }

      return true;
   }
}

