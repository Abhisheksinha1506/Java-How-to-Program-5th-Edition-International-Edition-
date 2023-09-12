// Fig. 2.9: Average.java
// Class average program with
// sentinel-controlled repetition.
import java.io.*;

public class Average {
   public static void main( String args[] ) throws IOException
   {
      double average;  // number with decimal point
      int counter, grade, total;
   
      // initialization phase
      total = 0;
      counter = 0;
   
      // processing phase
      System.out.print( "Enter letter grade, Z to end: " );
      System.out.flush();
      grade = System.in.read();

      while ( grade != 'Z' ) {
         if ( grade == 'A' ) 
            total = total + 4;
         else if ( grade == 'B' ) 
            total = total + 3;
         else if ( grade == 'C' ) 
            total = total + 2;
         else if ( grade == 'D' ) 
            total = total + 1;
         else if ( grade == 'F' ) 
            total = total + 0;

         System.in.skip( 1 );
         counter = counter + 1;
         System.out.print( "Enter letter grade, Z to end: " );
         System.out.flush();
         grade = System.in.read();
      }
   
      // termination phase
      if ( counter != 0 ) {
         average = (double) total / counter;
         System.out.println( "Class average is " + average );
      }
      else
         System.out.println( "No grades were entered" );
   }
}

