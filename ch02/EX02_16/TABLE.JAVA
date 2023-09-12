// Exercise 2.16 Solution
// Table.java
// Program prints a table of values

public class Table {

   public static void main( String args[] )
   {
      int n = 0;

      System.out.println( "N\t10*N\t100*N\t1000*N" );

      while ( ++n <= 5 ) 
         System.out.println( n + "\t" + ( 10 * n ) +
                             "\t" + ( 100 * n ) + "\t"
                             + ( 1000 * n ) );
   }
}
