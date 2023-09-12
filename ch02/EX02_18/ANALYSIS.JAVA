// Exercise 2.18 Solution
// Analysis.java
// Analysis of examination results

import java.io.*;

public class Analysis {

   public static void main( String args[] ) throws IOException
   {
      // initializing variables in declarations
      int passes = 0, failures = 0, student = 1, result;
   
      // process 10 students; counter-controlled loop
      while ( student <= 10 ) {
         System.out.print( "Enter result (1=pass,2=fail): " );
         System.out.flush();
         result = System.in.read();         
   
         if ( result == '1' ) {     // if/else nested in while
            passes = passes + 1;
            student = student + 1;
         }
         else if ( result == '2' ) {
            failures = failures + 1;
            student = student + 1;
         }
         else
            System.out.println( "Invalid input." );

         System.in.skip( 1 );
      }
   
      System.out.println( "Passed " + passes );
      System.out.println( "Failed " + failures );
   
      if ( passes > 8 )
         System.out.println( "Raise tuition " );
   }
}
