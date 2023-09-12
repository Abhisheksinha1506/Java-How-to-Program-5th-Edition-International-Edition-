// Exercise 8.3 Solution
// Poker.java
// Program deals a Poker "hand"

import java.applet.Applet;
import java.awt.*;

public class Poker extends Applet {
   private Card deck[], hand[];
   private int currentCard;
   private Button dealButton, shuffleButton;
   private TextArea displayCard;
   private String faces[], suits[], output;
   private int numbers[];

   public void init()
   {
      String f[] = { "Ace", "Deuce", "Three", "Four", 
                     "Five", "Six", "Seven", "Eight", 
                     "Nine", "Ten", "Jack", "Queen",
                     "King" };
      String s[] = { "Hearts", "Diamonds",
                     "Clubs", "Spades" };

      numbers = new int [ 13 ];
      faces = f;
      suits = s;
      hand = new Card[ 5 ];
      deck = new Card[ 52 ];
      currentCard = -1;
      
      for ( int i = 0; i < deck.length; i++ ) 
         deck[ i ] = new Card( faces[ i % 13 ],
                               suits[ i / 13 ] );

      dealButton = new Button( "Deal hand" );
      shuffleButton = new Button( "Shuffle deck" );
      displayCard = new TextArea( 6, 20 );
      displayCard.setEditable( false );
      add( dealButton );
      add( shuffleButton);
      add( displayCard );
   }

   public boolean action( Event event, Object obj )
   {
      if ( event.target == dealButton ) {
         displayCard.setText( "" );    // clear text area
         showStatus( "" );             // clear status bar
         output = "";

         for ( int n = 0; n < hand.length; n++ ) {
            Card temp = dealCard();

            if ( temp != null ) {
               hand[ n ] = temp;
               displayCard.appendText( hand[ n ].toString() + "\n" );
            }
         }

         totalHand();    // calculates contents of the hand

         pair();
         threeOfAKind();
         fourOfAKind();         
         straight();
         flush();
      }
      else if ( event.target == shuffleButton ) {  
         shuffle();
         displayCard.setText( "DECK IS SHUFFLED\n" );
      }

      return true;
   }

   public void shuffle()
   {
      currentCard = -1;

      for ( int i = 0; i < deck.length; i++ ) {
         int j =  ( int ) ( Math.random() * 52 );

         Card temp = deck[ i ];
         deck[ i ] = deck[ j ];
         deck[ j ] = temp;
      }

      dealButton.enable();
   }

   public Card dealCard()
   {
      if ( currentCard > 50 ) {
         dealButton.disable();
         return null;
      }
      else if ( ++currentCard < deck.length ) 
         return deck[ currentCard ];
      
      return null;   // not functional only for compiler 
   }

   private void totalHand()
   {
      for ( int x = 0; x < faces.length; x++ )
         numbers[ x ] = 0;

      for ( int h = 0; h < hand.length; h++ )
         for ( int f = 0; f < faces.length; f++ )
            if ( hand[ h ].getFace().equals( faces[ f ] ) )
               ++numbers[ f ];
   }

   public void pair()
   {
      for ( int k = 0; k < faces.length; k++ )
         if ( numbers[ k ] == 2 )
            output += ( "Pair of " + faces[ k ] + "'s  " );

      showStatus( output );
   }

   public void threeOfAKind()
   {
      for ( int k = 0; k < faces.length; k++ )
         if ( numbers[ k ] == 3 ) {
            output += ( "Three " + faces[ k ] + "'s" );
            break;
         }

      showStatus( output );
   }

   public void fourOfAKind()
   {
      for ( int k = 0; k < faces.length; k++ )
         if ( numbers[ k ] == 4 )
            output += ( "Four " + faces[ k ] + "'s" );

      showStatus( output );
   }

   public void flush()
   {
      String theSuit = hand[ 0 ].getSuit();

      for ( int s = 1; s < hand.length; s++ ) 
         if ( hand[ s ].getSuit().compareTo( theSuit ) != 0 ) 
            return;   // not a flush

      output += ( "flush in " + theSuit );
      showStatus( output );
   }

   public void straight()
   {
      int locations[] = new int[ 5 ], z = 0;

      for ( int y = 0; y < numbers.length; y++ )
         if ( numbers[ y ] == 1 )
            locations[ z++ ] = y;
      
      bubbleSort( locations );

      int faceValue = locations[ 0 ];

      for ( int m = 1; m < locations.length; m++ ) {
         
         if ( faceValue != locations[ m ] - 1 )
            return;   // not a straight
         else
            faceValue = locations[ m ];
      }

      output += "straight ";
      showStatus( output );
   }

   private void bubbleSort( int values[] )
   {
      for ( int pass = 1; pass < values.length; pass++ )
         for ( int comp = 0; comp < values.length - 1; comp++ )
            if ( values[ comp ] > values[ comp + 1 ] ) {
               int temp = values[ comp ];
               values[ comp ] = values[ comp + 1 ];
               values[ comp + 1 ] = values[ comp ];
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

   public String getFace() { return face; }

   public String getSuit() { return suit; }

   public String toString() { return face + " of " + suit; }
}
