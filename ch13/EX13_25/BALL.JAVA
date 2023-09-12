// Exercise 13.25 Solution
// Ball.java
// Program bounces a ball around the applet

// Note: The 20 to 60 degrees was not implemented
// in this solution.

import java.applet.Applet;
import java.awt.*;

public class Ball extends Applet implements Runnable {
   private Thread blueBall;
   private boolean xUp, yUp;
   private int x, y, xDx, yDy;

   public void init()
   {
      xUp = false;
      yUp = false;
      xDx = 1;
      yDy = 1;
   }

   public boolean mouseDown( Event e, int x1, int y1 )
   {
      if ( blueBall == null ) {
         x = x1;
         y = y1;
         blueBall = new Thread( this );
         blueBall.start();
      }

      return true;
   }

   public void stop()
   {
      if ( blueBall != null ) {
         blueBall.stop();
         blueBall = null;
      }
   }

   public void paint( Graphics g )
   {
      g.setColor( Color.blue );
      g.fillOval( x, y, 10, 10 );
   }

   public void run()
   {
      while ( true ) {

         try {
            blueBall.sleep( 100 );
         } catch ( Exception e ) {
            System.err.println( "Exception: " + e.toString() );
         }

         if ( xUp == true )
            x += xDx;
         else
            x -= xDx;

         if ( yUp == true )
            y += yDy;
         else
            y -= yDy;

         if ( y <= 0 ) {
            yUp = true;            
            yDy = ( int ) ( Math.random() * 5 + 2 );
         }
         else if ( y >= 190 ) {
            yDy = ( int ) ( Math.random() * 5 + 2 );
            yUp = false;
         }

         if ( x <= 0 ) {
            xUp = true;
            xDx = ( int ) ( Math.random() * 5 + 2 );
         }
         else if ( x >= 190 ) {
            xUp = false;
            xDx = ( int ) ( Math.random() * 5 + 2 );
         }

         repaint();
      }
   }
}
