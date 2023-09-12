// Fig. 16.3: Server.java
// Set up a Server that will receive a connection
// from a client, send a string to the client,
// and close the connection.
import java.io.*;
import java.net.*;
import java.awt.*;

public class Server extends Frame {
   TextArea display;

   public Server()
   {
      super( "Server" );
      display = new TextArea( 20, 5 );
      add( "Center", display );
      resize( 300, 150 );
      show();
   }

   public void runServer()
   {
      ServerSocket server;
      Socket connection;
      OutputStream output;

      try {
         server = new ServerSocket( 5000, 100 );
         connection = server.accept();
         display.setText( "Connection received...\n" );
         display.appendText( "Sending data...\n" );
         output = connection.getOutputStream();
         String s = new String( "Connection successful\n");

         for ( int i = 0; i < s.length(); i++ )
            output.write( (int) s.charAt( i ) );

         display.appendText( 
            "Transmission complete. Closing socket.\n" );
         connection.close();
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
      Server s = new Server();

      s.runServer();
   }
}
