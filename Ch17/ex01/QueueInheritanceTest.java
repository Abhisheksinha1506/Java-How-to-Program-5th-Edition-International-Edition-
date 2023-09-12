// Class QueueInheritanceTest
public class QueueInheritanceTest {
   public static void main( String args[] )
   {
      QueueInheritance objQueue = new QueueInheritance();  

      // Create objects to store in the queue
      Boolean b = new Boolean( true );
      Character c = new Character( '$' );
      Integer i = new Integer( 34567 );
      String s = new String( "hello" );

      // Use the enqueue method
      objQueue.enqueue( b );
      objQueue.print();
      objQueue.enqueue( c );
      objQueue.print();
      objQueue.enqueue( i );
      objQueue.print();
      objQueue.enqueue( s );
      objQueue.print();

      // Use the dequeue method
      Object removedObj = null;

      try {
         while ( true ) {
            removedObj = objQueue.dequeue();
            System.out.println( removedObj.toString() +
                                " dequeued" );
            objQueue.print();
         }
      }
      catch ( EmptyListException e ) {
         System.err.println( "\n" + e.toString() );
      }
   }
}

