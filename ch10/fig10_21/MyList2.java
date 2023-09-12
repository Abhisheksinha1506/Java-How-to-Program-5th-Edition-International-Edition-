// Fig. 10.21: MyList2.java
// Copying items from one List to another.
import java.applet.Applet;
import java.awt.*;

public class MyList2 extends Applet {
   private List stateList, copyList;
   private Button copy;

   public void init()
   {
      // create a list with 5 items visible
      // allow multiple selections
      stateList = new List( 5, true );

      // create a list with 5 items visible
      // do not allow multiple selections
      copyList = new List( 5, false );

      // create copy button
      copy = new Button( "Copy >>>" );

      // add some data to stateList
      stateList.addItem( "Texas" );
      stateList.addItem( "Alaska" );
      stateList.addItem( "Florida" );
      stateList.addItem( "Montana" );
      stateList.addItem( "Mississippi" );
      stateList.addItem( "Delaware" );
      stateList.addItem( "New Mexico" );
      stateList.addItem( "South Dakota" );
      stateList.addItem( "West Virginia" );

      // add list to applet
      add( stateList );
      add( copy );
      add( copyList );
   }

   public boolean action( Event e, Object o )
   {
      String states[];

      // test for a button event
      if ( e.target == copy ) {

         // get the selected states
         states = stateList.getSelectedItems();

         // copy them to copyList
         for ( int i = 0; i < states.length; i++ )
            copyList.addItem( states[ i ] );
      }

      return true;
   }
}
