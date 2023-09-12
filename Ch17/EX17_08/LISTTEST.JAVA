// Exercise 17.8 Solution
// ListTest.java
// Program inserts and sorts numbers in a list,
// prints the sum, and displays the average

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

      int s = x.add();
      System.out.println( "Sum is: " + s + "\nAverage: " +
                          ( ( float ) s / 25.0f ) );
   }
}




