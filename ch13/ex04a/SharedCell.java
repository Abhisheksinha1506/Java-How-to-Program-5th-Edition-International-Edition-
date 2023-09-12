// Fig. 13.4: SharedCell.java
// Show multiple threads modifying shared object.
// Use synchronization to ensure that both threads 
// access the shared cell properly.
import java.awt.*;
import java.applet.Applet;

public class SharedCell extends Applet {
   TextField produced, consumed, bufer[], head, tail;
   Label producedLabel, consumedLabel, headLabel, 
         tailLabel, bufferLabel;

   public void init()
   {
      producedLabel = new Label( "Produced" );
      produced = new TextField( 2 );
      consumedLabel = new Label( "Consumed" );
      consumed = new TextField( 2 );
      headLabel = new Label( "Head" );
      head = new TextField( 2 );
      tailLabel = new Label( "Tail );
      tail = new TextField( 2 );
      buffer = new TextField[ 5 ];

      add( );

      for ( int i = 0; i < buffer.length; i++ )
         buffer[ i ] = new TextField( 2 );
   }

   public static void main( String args[] )
   {
      HoldInteger h = new HoldInteger();
      ProduceInteger p = new ProduceInteger( h );
      ConsumeInteger c = new ConsumeInteger( h );

      p.start();
      c.start();
   }
}

class ProduceInteger extends Thread {
   private HoldInteger pHold;

   public ProduceInteger( HoldInteger h )
   {
      pHold = h;
   }

   public void run()
   {
      for ( int count = 0; count < 10; count++ ) {
         pHold.setSharedInt( count );
         System.out.println( "Producer set sharedInt to " + count );

         // sleep for a random interval
         try {
            sleep( (int) ( Math.random() * 3000 ) );
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
      System.out.println( "Consumer retrieved " + val );

      while ( val != 9 ) {
         // sleep for a random interval
         try {
            sleep( (int) ( Math.random() * 3000 ) );
         }
         catch( InterruptedException e ) {
            System.err.println( "Exception " + e.toString() );
         }

         val = cHold.getSharedInt();
         System.out.println( "Consumer retrieved " + val );
      }
   }
}

class HoldInteger {
   private int sharedInt[] = new int[ 5 ];
   private boolean writeable = true;
   private boolean readable = false;
   private int readLoc = 0, writeLoc = 0;

   public synchronized void setSharedInt( int val )
   {
      while ( !writeable ) {
         try {
            wait();
         }
         catch ( InterruptedException e ) {
            System.err.println( "Exception: " + e.toString() );
         }
      }

      sharedInt[ writeLoc ] = val;
      readable = true;
      writeLoc = ++writeLoc % 5;

      if ( writeLoc == readLoc )
         writeable = false;

      notify();
   }

   public synchronized int getSharedInt()
   {
      int val;

      while ( !readable ) {
         try {
            wait();
         }
         catch ( InterruptedException e ) {
            System.err.println( "Exception: " + e.toString() );
         }
      }

      writeable = true;
      val = sharedInt[ readLoc ];
      readLoc = ++readLoc % 5;

      if ( readLoc == writeLoc )
         readable = false;

      notify();
      return val;
   }
}
