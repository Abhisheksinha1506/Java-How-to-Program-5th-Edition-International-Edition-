// Exercise 13.21 Solution
// Demo3.java
// Program demonstrates high priority threads
// using sleep

import java.applet.Applet;
import java.awt.*;

public class Demo3 extends Applet {
   private HighThread high1, high2, high3;
   private LowThread low;
   private TextArea output;

   public void init()
   {
      output = new TextArea( 10, 20 );
      add( output );
   }

   public void start()
   {
      if ( high1 == null ) {
         high1 = new HighThread( output, 1 );
         high1.start();
      }

      if ( high2 == null ) {
         high2 = new HighThread( output, 2 );
         high2.start();
      }

      if ( high3 == null ) {
         high3 = new HighThread( output, 3 );
         high3.start();
      }

      if ( low == null ) {
         low = new LowThread( output );
         low.start();
      }
   }

   public void stop()
   {
      if ( high1 != null ) {
         high1.stop();
         high1 = null;
      }

      if ( high2 != null ) {
         high2.stop();
         high2 = null;
      }

      if ( high3 != null ) {
         high3.stop();
         high3 = null;
      }

      if ( low == null ) {
         low.stop();
         low = null;
      }
   }
}

class HighThread extends Thread {
   private TextArea display;
   private int id;

   public HighThread( TextArea a, int n )
   {
      display = a;
      id = n;
      setPriority( Thread.MAX_PRIORITY );
   }

   public void run()
   {
      for ( int x = 1; x <= 5; x++ ) {

         try {
            sleep( ( int ) ( Math.random() * 200 ) );
         } catch ( Exception e ) {
            System.err.println( "Exception: " + e.toString() );
         }
         
         display.appendText( "High Priority Thread " + id + "\n" );
      }
   }
}

class LowThread extends Thread {
   private TextArea display;

   public LowThread( TextArea a )
   {
      display = a;
      setPriority( Thread.MIN_PRIORITY );
   }

   public void run()
   {
      for ( int y = 1; y <= 5; y++ )
         display.appendText( "Low Priority Thread!!!\n" );
   }
}


