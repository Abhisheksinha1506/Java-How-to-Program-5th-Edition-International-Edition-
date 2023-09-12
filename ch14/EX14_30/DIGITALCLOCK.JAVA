// Exercise 14.30 Solution
// DigitalClock.java
// Program creates a digital clock.

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class DigitalClock extends Applet implements Runnable {
   private Thread spool;
   private String theTime;

   public void init() { theTime = ""; }

   public void paint( Graphics g ) { g.drawString( theTime, 20, 50 ); }

   public void start()
   {
      if ( spool == null ) {
         spool = new Thread( this );
         spool.start();
      }
   }

   public void stop()
   {
      if ( spool != null ) {
         spool.stop();
         spool = null;
      }
   }

   public void run()
   {
      while ( true ) {
         Date d = new Date();

         theTime = d.toString();

         try {
            Thread.sleep( 1000 );
         } catch( Exception e ) {
            System.err.println( "Exception: " + e.toString() );
         }

         repaint();
      }
   }
}
