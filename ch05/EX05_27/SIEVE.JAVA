// Exercise 5.27 Solution
// Sieve.java
// Sieve of Eratosthenes

import java.applet.Applet;
import java.awt.*;

public class Sieve extends Applet {

   public void paint( Graphics g )
   {
      int count = 0;
      int a[] = new int[ 1000 ];

      for ( int z = 0; z < a.length; z++ )
         a[ z ] = 1;

      for ( int i = 1; i < a.length; i++ )
         if ( a[ i ] == 1 && i != 1 )
            for ( int j = i; j < a.length; j++ )
               if ( j % i == 0 && j != i )
                  a[ j ] = 0;

      // range 2 - 197
      for ( int k = 2; k < a.length; k++ )
         if ( a[ k ] == 1 ) {
            System.out.println( k + " is prime." );
            ++count;
         }

      g.drawString( count + " primes found.", 30, 50 );
   }                                     
}
