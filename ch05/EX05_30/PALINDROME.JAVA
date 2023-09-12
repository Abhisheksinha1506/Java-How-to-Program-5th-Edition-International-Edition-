// Exercise 5.30 Solution
// Palindrome.java
// Program tests for a palindrome 

import java.io.*;

public class Palindrome {

   public static void main( String args[] ) throws IOException
   {
      int count = 0, counter = 0;
      char c, s[] = new char [ 80 ], copy[] = new char [ 80 ];

      while ( ( c = ( char ) System.in.read() ) != '\n' &&
                count < s.length )  

         s[ count++ ] = c;

      s[ count ] = '\0';

      for ( int i = 0; s[ i ] != '\0'; i++ )
         switch ( s[ i ] ) {
            case ' ': case '.': case ';': case ':':
            case ',': case '?': case '!': case '-':
               break;
            default:
               copy[ counter++ ] = s[ i ];
         }      

      if ( testPalindrome( copy, 0, counter - 1 ) == 1 )
         System.out.println( "Palindrome" );
      else
         System.out.println( "Not a palindrome" );
   }

   public static int testPalindrome( char b[], int left, int right )
   {  
      if ( left == right || left > right )
         return 1;
      else if ( b[ left ] != b[ right ] ) 
         return 0;
      else
         return testPalindrome( b, left + 1, right - 1 );
   }
}
