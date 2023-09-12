// Fig. 11.22: CardDeck.java
// Demonstrating CardLayout.
import java.applet.Applet;
import java.awt.*;

public class CardDeck extends Applet {
   private Canvas c;
   private CardLayout cardManager;
   private Panel deck, p1, p2, p3, p4;
   private Button b1, b2, b3,
                  prevButton, nextButton,
                  lastButton, firstButton;

   public void init()
   {
      setLayout( new BorderLayout() );   // applet

      b1 = new Button( "card one  " );
      b2 = new Button( "card two  " );
      b3 = new Button( "card three" );

      // create and customize a canvas
      c = new Canvas();
      c.setBackground( Color.green );
      c.resize( 80, 80 );

      deck = new Panel();
      cardManager = new CardLayout();  // instantiate object
      deck.setLayout( cardManager );   // set cardLayout
      add( "East", deck );

      // use the default layout for p1
      p1 = new Panel();
      p1.add( b1 );       // add a button
      deck.add( b1.getLabel(), p1 );  // add card to deck
      
      // set up second card
      p2 = new Panel();
      p2.add( b2 );       // add a button
      p2.add( c );        // add a canvas
      deck.add( b2.getLabel(), p2 );  // add card to deck

      // set up last card
      p3 = new Panel();
      p3.setLayout( new BorderLayout() );   // set layout
      p3.add( "North", new Button( "North Pole" ) );
      p3.add( "West", new Button( "The West" ) );
      p3.add( "East", new Button( "Far East" ) );
      p3.add( "South", new Button( "South Pole" ) );
      p3.add( "Center", b3 );
      deck.add( b3.getLabel(), p3 );  // add card to deck

      // create and layout panel that will control deck
      p4 = new Panel();
      p4.setLayout ( new GridLayout( 2, 2 ) );
      p4.add( firstButton = new Button( "First" ) );
      p4.add( nextButton = new Button( "Next" ) );
      p4.add( prevButton = new Button( "Previous" ) );
      p4.add( lastButton = new Button( "Last" ) );
      add( "West", p4 );
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == firstButton )    
         cardManager.first( deck );    // show first card
      else if ( e.target == prevButton )    
         cardManager.previous( deck ); // show previous card
      else if ( e.target == nextButton )
         cardManager.next( deck );     // show next card
      else if ( e.target == lastButton )
         cardManager.last( deck );     // show last card
            
      return true;
   }
}
