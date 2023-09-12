// Fig. 16.5: Server.java
// Set up a Server that will receive packets from a
// client and send packets to a client.
import java.io.*;
import java.net.*;
import java.awt.*;

public class Server extends Frame {
   TextArea display;

   DatagramPacket sendPacket, receivePacket;
   DatagramSocket sendSocket, receiveSocket;

   public Server()
   {
      super( "Server" );
      display = new TextArea( 20, 10 );
      add( "Center", display );
      resize( 400, 300 );
      show();

      try {
         sendSocket = new DatagramSocket();
         receiveSocket = new DatagramSocket( 5000 );
      }
      catch( SocketException se ) {
         se.printStackTrace();
         System.exit( 1 );
      }
   }

   public void waitForPackets()
   {
      while ( true ) {
         try {
            // set up packet
            byte array[] = new byte[ 100 ];
            receivePacket =
               new DatagramPacket( array, array.length );

            // wait for packet
            receiveSocket.receive( receivePacket );
 
            // process packet
            display.appendText( "\nPacket received:" +
               "\nFrom host: " + receivePacket.getAddress() +
               "\nHost port: " + receivePacket.getPort() +
               "\nLength: " + receivePacket.getLength() +
               "\nContaining:\n\t" );
            byte data[] = receivePacket.getData();
            String received = new String( data, 0 );   
            display.appendText( received );

            // echo information from packet back to client
            display.appendText( "\n\nEcho data to client...");
            sendPacket = new DatagramPacket( data, data.length,
               receivePacket.getAddress(), 5001 );
            sendSocket.send( sendPacket );
            display.appendText( "Packet sent\n" );
         }
         catch( IOException exception ) {
            display.appendText( exception.toString() + "\n" );
            exception.printStackTrace();
         }
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

      s.waitForPackets();
   }
}
