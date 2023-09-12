// Exercise 17.20 Solution
// ListTest.java
// Program recursively prints a list backwards

public class ListTest {
   public static void main( String args[] )
   {
      List x = new List();             
      Integer y = null;

      // Create objects to store in the List
      for ( int k = 1; k <= 25; k++ ) {
         y = new Integer( ( int ) ( Math.random() * 101 ) );
         x.insert( y );
      }
      
      x.print();

      System.out.println( "\nReverse ordered list:" );
      x.printListBackwards();
   }
}




