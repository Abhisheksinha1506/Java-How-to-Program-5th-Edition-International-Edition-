// Fig. 13.3: PrintTest.java
// Show multiple threads printing at different intervals.

public class PrintTest {
   public static void main( String args[] )
   {
      PrintThread thread1, thread2, thread3, thread4;

      thread1 = new PrintThread( "1" );
      thread2 = new PrintThread( "2" );
      thread3 = new PrintThread( "3" );
      thread4 = new PrintThread( "4" );

      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();
   }
}

class PrintThread extends Thread {
   int sleepTime;

   // PrintThread constructor assigns name to thread 
   // by calling Thread constructor
   public PrintThread( String id )
   {
      super( id );

      // sleep between 0 and 5 seconds
      sleepTime = (int) ( Math.random() * 5000 );

      System.out.println( "Name: " + getName() +
                          ";  sleep: " + sleepTime );
   }

   // execute the thread
   public void run()
   {
      // put thread to sleep for a random interval
      try {
         sleep( sleepTime );
      }
      catch ( InterruptedException exception ) {
         System.err.println( "Exception: " +
                             exception.toString() );
      }

      // print thread name
      System.out.println( "Thread " + getName() );                             
   }
}
