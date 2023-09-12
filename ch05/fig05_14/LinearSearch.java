// Fig. 5.14: LinearSearch.java
// Linear search of an array
import java.awt.*;
import java.applet.Applet;

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

   public int linearSearch( int key ) 
   {   
      for ( int n = 0; n < a.length; n++ ) 
         if ( a[ n ] == key )
            return n;

      return -1;
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == enter ) {
         searchKey = event.arg.toString();
         element = linearSearch( Integer.parseInt( searchKey ) );

         if ( element != -1 )
            result.setText( "Found value in element " + element );
         else
            result.setText( "Value not found" );
      }

      return true;
   }
}
