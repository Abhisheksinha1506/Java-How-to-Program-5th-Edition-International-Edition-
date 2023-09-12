// Fig. 10.9: MyButtons.java
// Creating push buttons.
import java.applet.Applet;
import java.awt.*;

public class MyButtons extends Applet {
   private Button pushButton1, pushButton2, pushButton3;

   public void init()
   {
      pushButton1 = new Button( "Click here" );
      pushButton2 = new Button( "Sorry I don't do anything" );
      pushButton3 = new Button();  // no button label
      
      // add buttons
      add( pushButton1 );
      add( pushButton2 );
      add( pushButton3 );
   }

   // handle the button events
   public boolean action( Event e,  Object o )
   {
      // check to see if a button triggered the event
      if ( e.target instanceof Button ) {

         // check to see if pushButton1 or pushButton3
         // was pressed. Nothing will be done if
         // pushButton2 was pressed.
         if ( e.target == pushButton1 )
            showStatus( "You pressed: " + o.toString() );
         else if ( e.target == pushButton3 )
            showStatus( "You pressed: " + e.arg );

         return true;   // event was handled here
      }

      return true; 
   }
}
