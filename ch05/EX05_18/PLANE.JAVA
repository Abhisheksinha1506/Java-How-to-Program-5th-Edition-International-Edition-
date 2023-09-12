// Exercise 5.18 Solution
// Plane.java
// Airline Reservation System program

import java.applet.Applet;
import java.awt.*;

public class Plane extends Applet {
   TextField input;
   Label prompt1, prompt2;
   Button yesButton, noButton;
   int section, seats[], smoking;
   int nonsmoking, people;

   public void init()
   {
      input = new TextField( 4 );
      prompt1 = new Label( "Please type 1 for smoking" );
      prompt2 = new Label( "Please type 2 for nonsmoking" );
      yesButton = new Button( "Yes" );
      noButton = new Button( "No" );

      // The enabled method has not been introduced up
      // to this point in the book. It is used here to
      // disable the buttons by "graying" them.
      yesButton.enable( false );
      noButton.enable( false );

      seats = new int[ 11 ];
      smoking = 6;
      people = 0;
      nonsmoking = 1;
      add( prompt1 );
      add( prompt2 );
      add( input );
      add( yesButton );
      add( noButton );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == input && people <= 10 ) {
         section = Integer.parseInt( input.getText() );
         String s = "";

         if ( section == 1 ) {

            if ( smoking <= 10 && seats[ smoking ] == 0 ) {
               s = "Smoking. Seat #" + String.valueOf( smoking );
               seats[ smoking++ ] = 1;
               people++;
            }
            else if ( smoking > 10 && nonsmoking <= 5 ) {

               // enable buttons
               yesButton.enable( true );
               noButton.enable( true );

               s = "Smoking is full. Non-smoking?";
            }
            else
               s = "Next flight leaves in 3 hours.";
         }
         else if ( section == 2 ) {

            if ( seats[ nonsmoking ] == 0 && nonsmoking <= 5 ) {
               s = "Nonsmoking. Seat #" + String.valueOf( nonsmoking );
               seats[ nonsmoking++ ] = 1;
               people++;
            }
            else if ( nonsmoking > 5 && smoking <= 10 ) {

               // enable buttons
               yesButton.enable( true );
               noButton.enable( true );

               s = "Nonsmoking is full. Smoking?";
            }
            else
               s = "Next flight leaves in 3 hours.";
         }
         else
            s = "Invalid input.";

         showStatus( s );         
      }
      else if ( e.target == yesButton ) {

         if ( section == 1 ) {
            showStatus( "Your seat assignment is " + nonsmoking );
            seats[ nonsmoking++ ] = 1;         
         }
         else {  // section is 2
            showStatus( "Your seat assignment is " + smoking );
            seats[ smoking++ ] = 1;     
         }

         ++people;
         noButton.enable( false );
         yesButton.enable( false );
      }
      else if ( e.target == noButton ) {
         showStatus( "Next flight leaves in 3 hours." );
         noButton.enable( false );
         yesButton.enable( false );
      }

      return true;
   }
}
