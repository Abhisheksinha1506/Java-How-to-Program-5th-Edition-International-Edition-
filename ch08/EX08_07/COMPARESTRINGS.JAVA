// Exercise 8.7 Solution
// CompareStrings.java
// Program compares two strings

import java.applet.Applet;
import java.awt.*;

public class CompareStrings extends Applet {
   private Label prompt1, prompt2;
   private TextField input1, input2;

   public void init()
   {
      prompt1 = new Label( "Enter first string:" );
      prompt2 = new Label( "Enter second string:" );
      input1 = new TextField( 20 );
      input2 = new TextField( 20 );

      add( prompt1 );
      add( input1 );
      add( prompt2 );
      add( input2 );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input2 ) {
         String first = input1.getText();
         String second = input2.getText();

         int value = first.compareTo( second );

         if ( value == 0 ) 
            showStatus( first + " == " + second );
         else if ( value > 0 )
            showStatus( first + " > " + second );
         else
            showStatus( first + " < " + second );
      }

      return true;
   }
}
