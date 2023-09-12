// Exercise 3.6 Solution
// Small.java
// Program finds the smallest of several numbers

import java.io.*;

public class Small {

   public static void main( String args[] ) throws IOException
   {
      int smallest = 'Z', temp, number;

      System.out.println( "Enter a digit followed by characters"  );

      // subtract unicode value of 48 (the value of
      // character '0') to get the actual numeric value
      number = System.in.read() - 48;    
      smallest = System.in.read();
        
      for ( int x = 2; x <= number; x++ ) {
         temp = System.in.read();
           
         if ( temp < smallest )
            smallest = temp;
      }
     
      char smallest2 = ( char ) smallest;
      System.out.println( "Smallest letter is " + smallest2 );
   }
}
