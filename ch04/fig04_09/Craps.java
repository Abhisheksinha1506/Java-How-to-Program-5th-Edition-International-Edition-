// Fig. 4.9: Craps.java
// Craps
import java.awt.*;
import java.applet.Applet;

public class Craps extends Applet {
   // constant variables for status of game
   final int WON = 0, LOST = 1, CONTINUE = 2;  

   // other variables used in program
   boolean firstRoll = true;   // true if first roll
   int dieSum = 0;             // sum of the dice
   int myPoint = 0;   // point if no win/loss on first roll
   int gameStatus = CONTINUE;  // WON, LOST, CONTINUE

   // graphical user interface components 
   Label die1Label, die2Label, sumLabel, pointLabel;
   TextField firstDie, secondDie, sum, point;
   Button roll;

   // setup graphical user interface components
   public void init()
   {
      die1Label = new Label( "Die 1" );
      firstDie = new TextField( 10 );
      firstDie.setEditable( false );
      die2Label = new Label( "Die 2" );
      secondDie = new TextField( 10 );
      secondDie.setEditable( false );
      sumLabel = new Label( "Sum is" );
      sum = new TextField( 10 );
      sum.setEditable( false );
      roll = new Button( "Roll Dice" );
      pointLabel = new Label( "Point is" );
      point = new TextField( 10 );
      point.setEditable( false );

      add( die1Label );
      add( firstDie );
      add( die2Label );
      add( secondDie );
      add( sumLabel );
      add( sum );
      add( pointLabel );
      add( point );
      add( roll );
   }

   // process one roll of the dice
   public void play()
   {
      if ( firstRoll ) {             // first roll of the dice
         dieSum = rollDice();        
   
         switch( dieSum ) {
            case 7: case 11:         // win on first roll
               gameStatus = WON;
               point.setText( "" );  // clear point text field
               firstRoll = true;     // allow new game to start
               break;
            case 2: case 3: case 12: // lose on first roll
               gameStatus = LOST;
               point.setText( "" );  // clear point text field
               firstRoll = true;     // allow new game to start
               break;
            default:                 // remember point
               gameStatus = CONTINUE;
               myPoint = dieSum;
               point.setText( Integer.toString( myPoint ) );
               firstRoll = false;
               break;
         }
      }
      else {
         dieSum = rollDice();
      
         if ( dieSum == myPoint )    // win by making point
            gameStatus = WON;
         else
            if ( dieSum == 7 )       // lose by rolling 7
               gameStatus = LOST;
      }

      if ( gameStatus == CONTINUE )
         showStatus( "Roll again." );
      else {
         if ( gameStatus == WON )
            showStatus( "Player wins. " +
               "Click Roll Dice to play again." );
         else 
            showStatus( "Player loses. " + 
               "Click Roll Dice to play again." );
         
         firstRoll = true;
      }
   }

   // call method play when button is clicked
   public boolean action( Event e, Object o )
   {
      play();
      return true;
   }
   
   // roll the dice
   int rollDice()
   {
      int die1, die2, workSum;   

      die1 = 1 + (int) ( Math.random() * 6 );
      die2 = 1 + (int) ( Math.random() * 6 );
      workSum = die1 + die2;

      firstDie.setText( Integer.toString( die1 ) );
      secondDie.setText( Integer.toString( die2 ) );
      sum.setText( Integer.toString( workSum ) );

      return workSum;
   }
}
