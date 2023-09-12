// Fig. 13.6: SharedCell.java
// Show multiple threads modifying shared object.
// Use synchronization to ensure that both threads 
// access the shared cell properly.
import java.awt.*;
import java.applet.Applet;

public class SharedCell extends Applet {
   private TextArea output;

   public void init()
   {
      output = new TextArea( 28, 48 );
      add( output );
   }

   public void start()
   {
      HoldInteger h = new HoldInteger( output );
      ProduceInteger p = new ProduceInteger( h );
      ConsumeInteger c = new ConsumeInteger( h );

      p.start();
      c.start();
   }
}

class ProduceInteger extends Thread {
   private HoldInteger pHold;
   private TextArea output;

   public ProduceInteger( HoldInteger h )
   {
      pHold = h;
   }

   public void run()
   {
      for ( int count = 0; count < 10; count++ ) {
         pHold.setSharedInt( count );

         // sleep for a random interval
         try {
            sleep( (int) ( Math.random() * 500 ) );
         }
         catch( InterruptedException e ) {
            System.err.println( "Exception " + e.toString() );
         }
      }
   }
}

class ConsumeInteger extends Thread {
   private HoldInteger cHold;

   public ConsumeInteger( HoldInteger h )
   {
      cHold = h;
   }

   public void run()
   {
      int val;

      val = cHold.getSharedInt();

      while ( val != 9 ) {
         // sleep for a random interval
         try {
            sleep( (int) ( Math.random() * 3000 ) );
         }
         catch( InterruptedException e ) {
            System.err.println( "Exception " + e.toString() );
         }

         val = cHold.getSharedInt();
      }
   }
}

class HoldInteger {
   private int sharedInt[] = { 9, 9, 9, 9, 9 };
   private boolean writeable = true;
   private boolean readable = false;
   private int readLoc = 0, writeLoc = 0;
   private TextArea output;

   public HoldInteger( TextArea out )
   {
      output = out;
   }

   public synchronized void setSharedInt( int val )
   {
      while ( !writeable ) {
         try {
            output.appendText( " WAITING TO PRODUCE " + val );
            wait();
         }
         catch ( InterruptedException e ) {
            System.err.println( "Exception: " + e.toString() );
         }
      }

      sharedInt[ writeLoc ] = val;
      readable = true;

      output.appendText( "\nProduced " + val +
                         " into cell " + writeLoc );

      writeLoc = ++writeLoc % 5;

      output.appendText( "\twrite " + writeLoc +
                         "\tread " + readLoc );
      printBuffer( output, sharedInt );

      if ( writeLoc == readLoc ) {
         writeable = false;
         output.appendText( "\nBUFFER FULL" );
      }

      notify();
   }

   public synchronized int getSharedInt()
   {
      int val;

      while ( !readable ) {
         try {
            output.appendText( " WAITING TO CONSUME" );
            wait();
         }
         catch ( InterruptedException e ) {
            System.err.println( "Exception: " + e.toString() );
         }
      }

      writeable = true;
      val = sharedInt[ readLoc ];

      output.appendText( "\nConsumed " + val +
                         " from cell " + readLoc );

      readLoc = ++readLoc % 5;

      output.appendText( "\twrite " + writeLoc +
                         "\tread " + readLoc );
      printBuffer( output, sharedInt );

      if ( readLoc == writeLoc ) {
         readable = false;
         output.appendText( "\nBUFFER EMPTY" );
      }

      notify();
      return val;
   }

   public void printBuffer( TextArea out, int buf[] )
   {
      output.appendText( "\tbuffer: " );

      for ( int i = 0; i < buf.length; i++ )
         out.appendText( " " + buf[ i ] );
   }
}
