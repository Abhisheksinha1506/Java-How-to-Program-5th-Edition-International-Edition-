// Fig. 18.2: StackTest.java
// Testing the Stack class of the java.util package
import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class StackTest extends Applet {
   Stack s;

   // GUI components
   Label prompt;
   TextField input;
   Button pushBtn, popBtn, peekBtn,
          emptyBtn, searchBtn, displayBtn;

   public void init()
   {
      s = new Stack();

      prompt = new Label( "Enter a string" );
      input = new TextField( 10 );
      pushBtn = new Button( "Push" );
      popBtn = new Button( "Pop" );
      peekBtn = new Button( "Peek" );
      emptyBtn = new Button( "Is Empty?" );
      searchBtn = new Button( "Search" );
      displayBtn = new Button( "Display" );

      add( prompt );
      add( input );      // value to push or search for
      add( pushBtn );    // push the input value
      add( popBtn );     // pop a value
      add( peekBtn );    // peek at the top 
      add( emptyBtn );   // check if stack is empty
      add( searchBtn );  // search for input value
      add( displayBtn ); // display the stack contents
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == pushBtn ) {
         showStatus( "Pushed: " + s.push( input.getText() ) );
      }
      else if ( e.target == popBtn ) {
         try {
            showStatus( "Popped: " + s.pop() );
         }
         catch ( EmptyStackException exception ) {
            showStatus( exception.toString() );
         }
      }
      else if ( e.target == peekBtn ) {
         try {
            showStatus( "Top: " + s.peek() );
         }
         catch ( EmptyStackException exception ) {
            showStatus( exception.toString() );
         }
      }
      else if ( e.target == emptyBtn ) {
         showStatus( s.empty() ? "Stack is empty" :
                                 "Stack is not empty" );
      }
      else if ( e.target == searchBtn ) {
         String searchKey = input.getText();
         int result = s.search( searchKey );

         if ( result == -1 ) 
            showStatus( searchKey + " not found" );
         else
            showStatus( searchKey + " found at element " +
                        result );
      }
      else if ( e.target == displayBtn ) {
         Enumeration enum = s.elements();
         StringBuffer buf = new StringBuffer();
        
         while ( enum.hasMoreElements() )
            buf.append( enum.nextElement() ).append( " " );
       
         showStatus( buf.toString() );
      }

      return true;
   }
}
