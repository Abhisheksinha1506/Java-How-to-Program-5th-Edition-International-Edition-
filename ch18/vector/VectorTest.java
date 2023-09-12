// Fig. 18.1: VectorTest.java
// Testing the Vector class of the java.util package
import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class VectorTest extends Applet {
   Vector v;

   // GUI components
   Label prompt;
   TextField input;
   Button addBtn, removeBtn, firstBtn, lastBtn,
          emptyBtn, containsBtn, locationBtn,
          trimBtn, statsBtn, displayBtn;

   public void init()
   {
      v = new Vector( 1 );

      prompt = new Label( "Enter a string" );
      input = new TextField( 10 );
      addBtn = new Button( "Add" );
      removeBtn = new Button( "Remove" );
      firstBtn = new Button( "First" );
      lastBtn = new Button( "Last" );
      emptyBtn = new Button( "Is Empty?" );
      containsBtn = new Button( "Contains" );
      locationBtn = new Button( "Location" );
      trimBtn = new Button( "Trim" );
      statsBtn = new Button( "Statistics" );
      displayBtn = new Button( "Display" );

      add( prompt );
      add( input );       // value to add, remove or locate
      add( addBtn );      // add the input value
      add( removeBtn );   // remove the input value
      add( firstBtn );    // look at the first element
      add( lastBtn );     // look at the last element
      add( emptyBtn );    // check if stack is empty
      add( containsBtn ); // does vector contain input value?
      add( locationBtn ); // location of input value
      add( trimBtn );     // trim vector to number of elements
      add( statsBtn );    // display statistics
      add( displayBtn );  // display the stack contents
   }

   public boolean action( Event e, Object o )
   {
      if ( e.target == addBtn ) {
         v.addElement( input.getText() );
         showStatus( "Added to end: " + input.getText() );
      }
      else if ( e.target == removeBtn ) {
         if ( v.removeElement( input.getText() ) )
            showStatus( "Removed: " + input.getText() );
         else
            showStatus( input.getText() + " not in vector" );
      }
      else if ( e.target == firstBtn ) {
         try {
            showStatus( "First element: " + v.firstElement() );
         }
         catch ( NoSuchElementException exception ) {
            showStatus( exception.toString() );
         }
      }
      else if ( e.target == lastBtn ) {
         try {
            showStatus( "Last element: " + v.lastElement() );
         }
         catch ( NoSuchElementException exception ) {
            showStatus( exception.toString() );
         }
      }
      else if ( e.target == emptyBtn ) {
         showStatus( v.isEmpty() ? "Vector is empty" :
                                 "Vector is not empty" );
      }
      else if ( e.target == containsBtn ) {
         String searchKey = input.getText();

         if ( v.contains( searchKey ) ) 
            showStatus( "Vector contains " + searchKey );
         else
            showStatus( "Vector does not contain " + searchKey );
      }
      else if ( e.target == locationBtn ) {
         showStatus( "Element is at location " + 
                     v.indexOf( input.getText() ) );
      }
      else if ( e.target == trimBtn ) {
         v.trimToSize();
         showStatus( "Vector trimmed to size" );
      }
      else if ( e.target == statsBtn ) {
         showStatus( "Size = " + v.size() + 
                     "; capacity = " + v.capacity() );
      }
      else if ( e.target == displayBtn ) {
         Enumeration enum = v.elements();
         StringBuffer buf = new StringBuffer();
        
         while ( enum.hasMoreElements() )
            buf.append( enum.nextElement() ).append( " " );
       
         showStatus( buf.toString() );
      }

      input.setText( "" );
      return true;
   }
}
