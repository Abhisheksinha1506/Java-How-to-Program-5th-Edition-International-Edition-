// Exercise 16.18: Server.java
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

      try {
         server = new ServerSocket( 5000, 100 );

         while ( true ) {
            ManageClient m = new ManageClient( server.accept(), display );
            m.start();
         }
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

class ManageClient extends Thread {
   Socket connection;
   DataOutputStream output;
   TextArea display;

   public ManageClient( Socket s, TextArea t )
   {
      connection = s;
      display = t;
   }

   public void run()
   {
      try {
         display.appendText( "\nConnection received...\n" );
         output = new DataOutputStream( connection.getOutputStream() );
         display.appendText( "Sending data...\n" );
         output.writeBytes( "Connection successful\n" );
         display.appendText( 
            "Transmission complete. Closing socket.\n" );
         connection.close();
      }
      catch ( IOException e ) {
         e.printStackTrace();
      }
   }
}
