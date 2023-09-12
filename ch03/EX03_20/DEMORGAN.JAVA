// Exercise 3.20 Solution
// DeMorgan.java
// Program tests DeMorgan's laws

public class DeMorgan {

   public static void main( String args[] )
   {
      int x = 6, y = 0;

      // part a
      if ( !( x < 5 ) && !( y >= 7 ) )
         System.out.println( "!( x < 5 ) && !( y >= 7 )" );

      if ( !( ( x < 5 ) || ( y >= 7 ) ) )
         System.out.println( "!( ( x < 5 ) || ( y >= 7 )" );

      int a = 8, b = 22, g = 88;

      // part b
      if ( !( a == b ) || !( g != 5 ) )
         System.out.println( "!( a == b ) || !( g != 5 )" );

      if ( !( ( a == b ) && ( g != 5 ) ) )
         System.out.println( "!( ( a == b ) && ( g != 5 ) )" );

      x = 8;
      y = 2;

      // part c
      if ( !( ( x <= 8 ) && ( y > 4 ) ) )
         System.out.println( "!( ( x <= 8 ) && ( y > 4 ) )" );

      if ( !( x <= 8 ) || !( y > 4 ) )
         System.out.println( "!( x <= 8 ) || !( y > 4 )" );

      int i = 0, j = 7;

      // part d
      if ( !( ( i > 4 ) || ( j <= 6 ) ) )
         System.out.println( "!( ( i > 4 ) || ( j <= 6 ) )" );

      if ( !( i > 4 ) && !( j <= 6 ) )
         System.out.println( "!( i > 4 ) && !( j <= 6 )" );
   }
}
