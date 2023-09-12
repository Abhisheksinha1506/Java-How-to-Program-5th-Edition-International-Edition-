// Fig. 13.4: SharedCell.java
// Show multiple threads modifying shared object.

public class SharedCell {
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
         System.out.println( "Producer set sharedInt to " +
                             count );

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
   private int sharedInt;

   public void setSharedInt( int val ) { sharedInt = val; }

   public int getSharedInt() { return sharedInt; }
}
