// Exercise 2.26 Solution
// Stars.java
// Program prints a checkerboard pattern

public class Stars {

   public static void main( String args[] )
   {
      int row = 0;

      while ( ++row <= 8 ) {
         int col = 0;

         if ( row % 2 == 0 )
            System.out.print( " " );

         while ( ++col <= 8 ) 
            System.out.print( "* " );

         System.out.println();
      }
   }
}
