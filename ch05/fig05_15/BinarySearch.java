// Fig. 5.15: BinarySearch.java
// Binary search of an array
import java.awt.*;
import java.applet.Applet;

public class BinarySearch extends Applet {
   int a[];
   int element;
   String searchKey;
   int xPosition;  // applet horizontal drawing position
   int yPosition;  // applet vertical drawing position
   Label enterLabel;
   TextField enter;
   Label resultLabel;
   TextField result;
   boolean timeToSearch = false;
   
   public void init()
   {
      a = new int[ 15 ];

      for ( int i = 0; i < a.length; i++ ) // create data
         a[ i ] = 2 * i;

      enterLabel = new Label( "Enter key" );
      enter = new TextField( 5 );
      resultLabel = new Label( "Result" );
      result = new TextField( 22 );
      result.setEditable( false );
      add( enterLabel );
      add( enter );
      add( resultLabel );
      add( result );
   }

   public void paint( Graphics g )
   {
      if ( timeToSearch ) { // prevents search 1st time called
         element = binarySearch(
            Integer.parseInt( searchKey ), g );

         if ( element != -1 )
            result.setText(
               "Found value in element " + element );
         else
            result.setText( "Value not found" );
      }
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == enter ) {
         timeToSearch = true;  
         xPosition = 25;
         yPosition = 75;
         searchKey = event.arg.toString();
         repaint();  // call paint to start search and output
      }

      return true;
   }

   // Binary search
   public int binarySearch( int key, Graphics gg ) 
   {   
      gg.drawString( "Portions of array searched",
                     xPosition, yPosition );
      yPosition += 15;

      int low = 0;              // low subscript
      int high = a.length - 1;  // high subscript
      int middle;               // middle subscript

      while ( low <= high ) {
         middle = ( low + high ) / 2;

         printRow( low, middle, high, gg );

         if ( key == a[ middle ] )  // match
            return middle;
         else if ( key < a[ middle ] )
            high = middle - 1;  // search low end of array
         else
            low = middle + 1;   // search high end of array
      }

      return -1;   // searchKey not found
   }

   // Print one row of output showing the current
   // part of the array being processed.
   void printRow( int low, int mid, int high, Graphics gg )
   {
      xPosition = 25;

      for ( int i = 0; i < a.length; i++ ) {
         if ( i < low || i > high )
            gg.drawString( "", xPosition, yPosition );
         else if ( i == mid )   // mark middle value
            gg.drawString( String.valueOf( a[ i ] ) + "*", 
                           xPosition, yPosition );
         else
            gg.drawString( String.valueOf( a[ i ] ), 
                           xPosition, yPosition );

         xPosition += 20;
      }

      yPosition += 15;
   }
}
