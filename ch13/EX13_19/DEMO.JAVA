// Exercise 13.19 Solution
// Demo.java
// Program demonstrates high priority threads

import java.applet.Applet;
import java.awt.*;

public class Demo extends Applet {
   private HighThread high;
   private LowThread low;
   private TextArea output;

   public void init()
   {
      output = new TextArea( 10, 20 );
      add( output );
   }

   public void start()
   {
      if ( high == null ) {
         high = new HighThread( output );
         high.start();
      }

      if ( low == null ) {
         low = new LowThread( output );
         low.start();
      }
   }

   public void stop()
   {
      if ( high != null ) {
         high.stop();
         high = null;
      }

      if ( low == null ) {
         low.stop();
         low = null;
      }
   }
}

class HighThread extends Thread {
   private TextArea display;

   public HighThread( TextArea a )
   {
      display = a;
      setPriority( Thread.MAX_PRIORITY );
   }

   public void run()
   {
      for ( int x = 1; x <= 5; x++ )
         display.appendText( "High Priority Thread!!!\n" );
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


