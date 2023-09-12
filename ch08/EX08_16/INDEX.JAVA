// Exercise 8.16 Solution
// Index.java
// Program outputs the number of times a
// search character was found

import java.applet.Applet;
import java.awt.*;

public class Index extends Applet {
   private TextField inputKey;
   private Label promptKey;
   private TextArea input;
   private int count;

   public void init()
   {     
      inputKey = new TextField( 4 );
      promptKey = new Label( "Enter a character:" );
      input = new TextArea( 4, 20 );
      add( promptKey );
      add( inputKey );
      add( input );
   }

   public boolean action( Event e, Object o )
   {
      count = 0;

      if ( e.target == inputKey ) {
         String key = o.toString();
         String s = input.getText();
         int last = -2, current = 0;

         for ( int j = -1; j < s.length();  ) {
            current = s.indexOf( key.charAt( 0 ), ++j );

            if (  current != -1 && current != last ) {
               last = current;
               count++;
            }
         }

         showStatus ( "Number of " + key.charAt( 0 ) +
                      "'s: " + count );
      }

      return true;
   }
}

