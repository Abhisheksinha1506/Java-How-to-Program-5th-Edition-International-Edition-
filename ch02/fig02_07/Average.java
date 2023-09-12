// Fig. 2.7: Average.java
// Class average program with
// counter-controlled repetition
import java.io.*;

public class Average {
   public static void main( String args[] ) throws IOException
   {
      int counter, grade, total, average;
   
      // initialization phase
      total = 0;
      counter = 1;
   
      // processing phase
      while ( counter <= 10 ) {
         System.out.print( "Enter letter grade: " );
         System.out.flush();
         grade = System.in.read();

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

         System.in.skip( 1 );    // skip the newline character
         counter = counter + 1;
      }
   
      // termination phase
      average = total / 10;      // integer division
      System.out.println( "Class average is " + average );
   }
}
