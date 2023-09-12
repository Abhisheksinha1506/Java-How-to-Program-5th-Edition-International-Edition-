// Fig. 5.18: DoubleArray.java
// Double-subscripted array example
import java.awt.Graphics;
import java.applet.Applet;

public class DoubleArray extends Applet {
   int grades[][] = { { 77, 68, 86, 73 }, 
                      { 96, 87, 89, 81 },
                      { 70, 90, 86, 81 } };
   int students, exams;
   int xPosition, yPosition;  

   // initialize instance variables
   public void init()
   {
      students = grades.length;
      exams = grades[ 0 ].length;
   }

   // paint the applet
   public void paint( Graphics g )
   { 
      xPosition = 25;
      yPosition = 25;

      g.drawString( "The array is:", xPosition, yPosition );
      yPosition += 15;
      printArray( g );
      xPosition = 25;
      yPosition += 30;      
      g.drawString( "Lowest grade:", xPosition, yPosition );
      int min = minimum();
      g.drawString( String.valueOf( min ),
                    xPosition + 85, yPosition );
      yPosition += 15;
      g.drawString( "Highest grade:", xPosition, yPosition );
      int max = maximum();
      g.drawString( String.valueOf( max ),
                    xPosition + 85, yPosition );
      yPosition += 15;

      for ( int i = 0; i < students; i++ ) {
         g.drawString( "Average for student " + i + " is ",
                       25, yPosition );
         double ave = average( grades[ i ] );
         g.drawString( String.valueOf( ave ), 165, yPosition );
         yPosition += 15;
      }
   }

   // find the minimum grade
   public int minimum()
   { 
      int lowGrade = 100;

      for ( int i = 0; i < students; i++ ) 
         for ( int j = 0; j < exams; j++ ) 
            if ( grades[ i ][ j ] < lowGrade )
               lowGrade = grades[ i ][ j ];

      return lowGrade;
   }

   // find the maximum grade
   public int maximum()
   { 
      int highGrade = 0;

      for ( int i = 0; i < students; i++ ) 
         for ( int j = 0; j < exams; j++ ) 
            if ( grades[ i ][ j ] > highGrade )
               highGrade = grades[ i ][ j ];

      return highGrade;
   }

   // determine the average grade for a particular
   // student (or set of grades)
   public double average( int setOfGrades[] )
   {
      int total = 0;
 
      for ( int i = 0; i < setOfGrades.length; i++ )
         total += setOfGrades[ i ];

      return (double) total / setOfGrades.length;
   }

   // print the array
   public void printArray( Graphics g )
   {
      xPosition = 80;

      for ( int i = 0; i < exams; i++ ) {
         g.drawString( "[" + i + "]", xPosition, yPosition );
         xPosition += 30;
      }

      for ( int i = 0; i < students; i++ ) {
         xPosition = 25;
         yPosition += 15;
         g.drawString( "grades[" + i + "]",
                       xPosition, yPosition );
         xPosition = 80;

         for ( int j = 0; j < exams; j++ )  {
            g.drawString( String.valueOf( grades[ i ][ j ] ),
                          xPosition, yPosition );
            xPosition += 30;
         }
      }
   }
}
