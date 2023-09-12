// Fig. 10.20: MyList.java
// Creating a List.
import java.applet.Applet;
import java.awt.*;

public class MyList extends Applet {
   private List colorList;

   public void init()
   {
      // create a list with 5 items visible
      // do not allow multiple selections
      colorList = new List( 5, false );

      // add four items to the list
      colorList.addItem( "White" );
      colorList.addItem( "Black" );
      colorList.addItem( "Yellow" );
      colorList.addItem( "Green" );

      // add list to applet
      add( colorList );
   }

   public boolean action( Event e, Object o )
   {

      // test for a list
      if ( e.target instanceof List ) {

         if ( e.arg.equals( "Yellow" ) )
            setBackground( Color.yellow );
         else if ( e.arg.equals( "White" ) )
            setBackground( Color.white );
         else if ( e.arg.equals( "Black" ) )
            setBackground( Color.black );
         else
            setBackground( Color.green );

         repaint();     // update applet              
      }

      return true;
   }
}
