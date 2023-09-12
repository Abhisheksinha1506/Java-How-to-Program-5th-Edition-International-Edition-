// Exercise 5.31 Solution
// LinearSearch.java
// Recursively linear search of an array

import java.applet.Applet;
import java.awt.*;

public class LinearSearch extends Applet {
   int a[];
   int element;
   String searchKey;
   Label enterLabel;
   TextField enter;
   Label resultLabel;
   TextField result;
   
   public void init()
   {
      a = new int[ 100 ];

      for ( int i = 0; i < a.length; i++ ) // create data
         a[ i ] = 2 * i;

      enterLabel = new Label( "Enter integer search key" );
      enter = new TextField( 10 );
      resultLabel = new Label( "Result" );
      result = new TextField( 25 );
      result.setEditable( false );
      add( enterLabel );
      add( enter );
      add( resultLabel );
      add( result );
   }

   public int linearSearch( int b[], int key, int low, int high ) 
   {   
      if ( b[ low ] == key )
         return low;
      else if ( low == high )
         return -1;
      else
         return linearSearch( b, key, low + 1, high );
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == enter ) {
         searchKey = event.arg.toString();
         element = linearSearch( a, Integer.parseInt( searchKey ),
                                 0, a.length - 1 );

         if ( element != -1 )
            result.setText( "Found value in element " + element );
         else
            result.setText( "Value not found" );
      }

      return true;
   }
}
