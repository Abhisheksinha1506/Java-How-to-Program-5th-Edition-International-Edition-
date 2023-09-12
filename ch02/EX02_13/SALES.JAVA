// Exercise 2.13 Solution
// Sales.java
// Program calculates sales

import java.io.IOException;

public class Sales {

   public static void main( String args[] ) throws IOException
   {
      double gross = 0.0, net;
      int product;

      System.out.println( "Enter the product sold ( A-D )."
                          + " X to quit" );

      product = System.in.read();

      while ( product != 'X' ) {

          if ( product == 'A' )
             gross = gross + 239.99;
          else if ( product == 'B' )
             gross = gross + 129.75;
          else if ( product == 'C' )
             gross = gross + 99.95;
          else if ( product == 'D' )
             gross = gross + 350.89;

          System.in.skip( 1 );  // ignore return character
          System.out.println( "Enter the product sold ( A-D )."
                              + " X to quit" );

          product = System.in.read();
      }

      net = 0.09 * gross + 200;
      System.out.println( "Earnings are $" + net );
   }
}
