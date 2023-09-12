// Fig. 5.9: StudentPoll.java
// Student poll program
import java.awt.Graphics;
import java.applet.Applet;

public class StudentPoll extends Applet {
   int responses[] = { 1, 2, 6, 4, 8, 5, 9, 7, 8, 10,
                       1, 6, 3, 8, 6, 10, 3, 8, 2, 7,
                       6, 5, 7, 6, 8, 6, 7, 5, 6, 6,
                       5, 6, 7, 5, 6, 4, 8, 6, 8, 10 };
   int frequency[];
   
   // initialize instance variables
   public void init()
   {
      frequency = new int[ 11 ];

      for ( int answer = 0; answer < responses.length; answer++ )
         ++frequency[ responses[ answer ] ];
   }

   // paint the applet
   public void paint( Graphics g )
   {
      int yPosition = 25;   // starting y position on applet

      g.drawString( "Rating", 25, yPosition );
      g.drawString( "Frequency", 100, yPosition );
   
      for ( int rating = 1;
            rating < frequency.length; rating++ ) {
         yPosition += 15;
         g.drawString( String.valueOf( rating ),
                       25, yPosition );
         g.drawString( String.valueOf( frequency[ rating ] ),
                       100, yPosition );
      }
   }
}
