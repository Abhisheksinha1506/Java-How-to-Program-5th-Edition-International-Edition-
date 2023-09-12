// Exercise 17.23 Solution
// TreeTest.java
// Program performs a binary tree search.

import java.util.*;

public class TreeTest {

   public static void main( String args[] )
   {
      Tree tree = new Tree();
      int intVal;

      System.out.println( "Inserting the following values: " );

      for ( int i = 1; i <= 10; i++ ) {
         intVal = ( int ) ( Math.random() * 100 );
         System.out.print( intVal + " " );
         tree.insertNode( intVal );
      }

      int num = ( int ) ( Math.random() * 100 );
      TreeNode myNode = tree.binarySearch( num );
      
      if ( myNode == null )
         System.out.println( "\n" + num + " is not in the tree." );
      else
         System.out.println( "\n" + num + " found in the tree." );
   }
}
