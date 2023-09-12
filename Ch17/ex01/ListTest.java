// Class ListTest
public class ListTest {
   public static void main( String args[] )
   {
      List objList = new List();  // create the List container

      // Create objects to store in the List
      Boolean b = new Boolean( true );
      Character c = new Character( '$' );
      Integer i = new Integer( 34567 );
      String s = new String( "hello" );

      // Use the List insert methods
      objList.insertAtFront( b );
      objList.print();
      objList.insertAtFront( c );
      objList.print();
      objList.insertAtBack( i );
      objList.print();
      objList.insertAtBack( s );
      objList.print();

      // Use the List remove methods
      Object removedObj;

      try {
         removedObj = objList.removeFromFront();
         System.out.println( removedObj.toString() + " removed" );
         objList.print();
         removedObj = objList.removeFromFront();
         System.out.println( removedObj.toString() + " removed" );
         objList.print();
         removedObj = objList.removeFromBack();
         System.out.println( removedObj.toString() + " removed" );
         objList.print();
         removedObj = objList.removeFromBack();
         System.out.println( removedObj.toString() + " removed" );
         objList.print();
      }
      catch ( EmptyListException e ) {
         System.err.println( "\n" + e.toString() );
      }
   }
}

