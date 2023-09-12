// Exercise 2.23 Solution
// Hollow.java
// Program prints a hollow square

import java.applet.Applet;
import java.awt.*;

public class Hollow extends Applet {
   TextField starInput;
   Label instruction;
   int stars;

   public void init()
   {
      stars = 0;
      instruction = new Label( "Enter a number between 1 and 20: " );
      starInput = new TextField( 5 );
      add( instruction );
      add( starInput );
   }
   
   public boolean action( Event e, Object o )
   {
      if ( e.target == starInput ) {
         stars = Integer.parseInt( starInput.getText() );

         if ( stars < 1 ) {
            stars = 1;
            showStatus( "Using default value 1" );
         }
         else if ( stars > 20 ) {
            stars = 20;
            showStatus( "Using default value 20" );
         }

         repaint();
      }

      return true;
   }

   public void paint( Graphics g )
   {
      int x = 5, y = 70;

      for ( int i = 1; i <= stars; i++ ) {

         for ( int j = 1; j <= stars; j++ ) {
            if ( i == 1 )
              g.drawString( "*", x += 5, y );
            else if ( i == stars )
              g.drawString( "*", x += 5, y );
            else if ( j == 1 )
               g.drawString( "*", x += 5, y );
            else if ( j == stars )
                g.drawString( "*", x += 5, y );
            else
               g.drawString( " ", x += 5, y );
         }
            
         y += 5;
         x = 5;           
      }      
   }
}
