// Exercise 10.24 Solution
// GuessGame.java
// Guess the number

import java.applet.Applet;
import java.awt.*;

public class GuessGame extends Applet {
   private int number;
   private int guess;
   private int highest;
   private int lowest;
   private TextField guessInput;
   private TextField message;
   private Label text1;
   private Label text2;
   private Button newGame;

   public void init()
   {
      text1 = new Label( "I have a number between 1 and 1000." );
      text2 = new Label( "Can you guess my" +
                         " number? Enter your Guess:" );

      highest = 0;
      lowest = 1000;
      guessInput = new TextField( 5 );
      message = new TextField( "<------------------", 15 );
      message.setEditable( false );
      newGame = new Button( "New Game" );

      add( text1 );
      add( text2 );
      add( guessInput );
      add( message );      
      add( newGame );
      theGame();
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == guessInput ) {
         guess = Integer.parseInt( guessInput.getText() );

         if ( guess > number ) {
            message.setText( "Too High" );

            if ( guess < lowest ) {
               lowest = guess;
               setBackground( Color.red );   // warmer
            }
            else
               setBackground( Color.blue );  // colder
         }
         else if ( guess < number ) {
            message.setText( "Too Low" );

            if ( guess > highest ) {
               highest = guess;
               setBackground( Color.red );   // warmer
            }
            else
               setBackground( Color.blue );  // colder
         }
         else {
            message.setText( "Correct!" );
            setBackground( Color.white );
            guessInput.setEditable( false );
            lowest = 1000;
            highest = 0;
         }

         repaint();
      }
      else if ( e.target == newGame ) {
         message.setText( "" );
         guessInput.setText( "" );
         guessInput.setEditable( true );
         theGame();
      }

      return true;
   }

   public void theGame()
   {  number = ( int ) ( Math.random() * 1000 + 1 );  }
}
