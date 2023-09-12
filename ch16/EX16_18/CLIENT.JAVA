// Fig. 16.4: Client.java
// Set up a Client that will read information sent
// from a Server and display the information.
import java.io.*;
import java.net.*;
import java.awt.*;

public class Client extends Frame {
   TextArea display;

   public Client()
   {
      super( "Client" );
      display = new TextArea( 20, 10 );
      add( "Center", display );
      resize( 300, 150 );
      show();
   }

   public void runClient()
   {
      Socket client;
      InputStream input;

      try {
         client = new Socket( InetAddress.getLocalHost(), 
                              5000 );
         display.appendText( "Created Socket\n" );

         input = client.getInputStream();
         display.appendText( "Created input stream\n" );

         display.appendText(
            "The text from the server is:\n\t");
         char c;

         while ( ( c = (char) input.read() ) != '\n' ) 
            display.appendText( String.valueOf( c ) );

         display.appendText( "\n" );
         client.close();   
      }
      catch ( IOException e ) {
         e.printStackTrace();
      }
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         hide();
         dispose();
         System.exit( 0 );
      }

      return super.handleEvent( e );
   }

   public static void main( String args[] )
   {
      Client c = new Client();

      c.runClient();
   }
}
