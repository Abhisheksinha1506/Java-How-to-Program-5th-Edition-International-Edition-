// Execise 3.17 Solution
// Pi.java
// Program calculates Pi

public class Pi {

   public static void main( String args[] )
   {
      double piValue = 0, num = 4.0, denom = 1.0;
      int accuracy = 400000;

      System.out.println( "Accuracy: " + accuracy );
      System.out.println( "Term\t\tPi" );

      for ( int term = 1; term <= accuracy; term++ ) {

         if ( term % 2 != 0 )
            piValue += num / denom;
         else
            piValue -= num / denom;

         System.out.println( term + "\t\t" + piValue );
         denom += 2.0;
      }
   }
}
