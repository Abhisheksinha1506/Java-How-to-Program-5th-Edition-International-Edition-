// Exercise 17.6 Solution
// ListConcat.java
// Program concatenates two lists

public class ListConcat {
   public static void main( String args[] )
   {
      List list1 = new List();  
      List list2 = new List();
      
      // Create objects to store in list1
      Character a = new Character( '5' );
      Character b = new Character( '@' );
      Character c = new Character( 'V' );
      Character d = new Character( '+' );

      // Use the List insert methods
      System.out.println( "List 1:" );
      list1.insertAtFront( a );
      list1.print();
      list1.insertAtFront( b );
      list1.print();
      list1.insertAtBack( c );
      list1.print();
      list1.insertAtBack( d );
      list1.print();

      // Create objects to store in list2
      Character a2 = new Character( 'P' );
      Character b2 = new Character( 'c' );
      Character c2 = new Character( 'M' );
      Character d2 = new Character( '&' );

      // Use the List insert methods
      System.out.println( "List 2:" );
      list2.insertAtFront( a2 );
      list2.print();
      list2.insertAtFront( b2 );
      list2.print();
      list2.insertAtBack( c2 );
      list2.print();
      list2.insertAtBack( d2 );
      list2.print();

      concatenate( list1, list2 );
      System.out.println( "Concatenated list is:" );
      list1.print();
   }

   public static void concatenate( List one, List two )
   {
      ListNode temp = two.getFirstNode();

      while ( temp != null ) {
         one.insertAtBack( temp.getObject() );
         temp = temp.getNext();
      }      
   }
}

