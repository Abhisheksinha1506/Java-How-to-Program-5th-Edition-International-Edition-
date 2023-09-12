// Fig. 8.21: DeckOfCards.java
// Card shuffling and dealing program
import java.awt.*;
import java.applet.Applet;

public class DeckOfCards extends Applet {
   private Card deck[];
   private int currentCard;

   // GUI components
   private Button dealButton, shuffleButton;
   private TextField displayCard;

   public void init()
   {
      String faces[] = { "Ace", "Deuce", "Three", "Four", 
                         "Five", "Six", "Seven", "Eight", 
                         "Nine", "Ten", "Jack", "Queen",
                         "King" };
      String suits[] = { "Hearts", "Diamonds",
                         "Clubs", "Spades" };

      deck = new Card[ 52 ];
      currentCard = -1;
      
      for ( int i = 0; i < deck.length; i++ ) 
         deck[ i ] = new Card( faces[ i % 13 ],
                               suits[ i / 13 ] );

      dealButton = new Button( "Deal card" );
      shuffleButton = new Button( "Shuffle cards" );
      displayCard = new TextField( 20 );
      displayCard.setEditable( false );
      add( dealButton );
      add( shuffleButton);
      add( displayCard );
   }

   public boolean action( Event event, Object obj )
   {
      if ( event.target == dealButton ) {
         Card dealt = dealCard();

         if ( dealt != null ) {
            displayCard.setText( dealt.toString() );
            showStatus( "Card #: " + currentCard );
         }
         else {
            displayCard.setText( "NO MORE CARDS TO DEAL" );
            showStatus( "Shuffle cards to continue" );
         }
      }
      else if ( event.target == shuffleButton ) {  
         displayCard.setText( "SHUFFLING ..." );
         showStatus( "" );
         shuffle();
         displayCard.setText( "DECK IS SHUFFLED" );
      }

      return true;
   }

   public void shuffle()
   {
      currentCard = -1;

      for ( int i = 0; i < deck.length; i++ ) {
         int j =  (int) ( Math.random() * 52 );
         Card temp = deck[ i ];
         deck[ i ] = deck[ j ];
         deck[ j ] = temp;
      }

      dealButton.enable();
   }

   public Card dealCard()
   {
      if ( ++currentCard < deck.length )
         return deck[ currentCard ];
      else {        
         dealButton.disable();
         return null;
      }
   }
}

class Card {
   private String face;
   private String suit;

   public Card( String f, String s )
   {
      face = f;
      suit = s;
   }

   public String toString() { return face + " of " + suit; }
}
