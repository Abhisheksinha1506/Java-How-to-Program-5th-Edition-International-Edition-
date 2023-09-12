// Fig. 10.12: MyTextField2.java
// Demonstrating TextField events.
import java.applet.Applet;
import java.awt.*;

public class MyTextField2 extends Applet {
   private TextField message, passwordField, message2;
   private String password;

   public void init()
   {
      password = "Marak954";  // set password
      message = new TextField( "Enter password: " );
      message.setEditable( false );  // read only

      passwordField = new TextField( 12 );
      passwordField.setEchoCharacter( '*' );  // masking char

      message2 = new TextField( 30 );
      message2.setEditable( false );

      // add textfields to applet
      add( message );
      add( passwordField );
      add( message2 );
   }

   public boolean action( Event e, Object o )
   {
      // check to see if a textfield triggered the event
      if ( e.target instanceof TextField )   

         // check to see it it was the textfield passwordField
         if ( e.target == passwordField )

            // check for correct password
            if ( e.arg.equals( password ) )
               message2.setText( "Access Granted" );
            else
               message2.setText( "Invalid password. " +
                                 "Access Denied" );

      return true;    // event was handled here
   }
}
