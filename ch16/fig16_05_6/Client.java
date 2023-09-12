// Fig. 16.6: Client.java
// Set up a Client that will send packets to a
// server and receive packets from a server.
import java.io.*;
import java.net.*;
import java.awt.*;

public class Client extends Frame {
   TextField enter;
   TextArea display;
   Panel enterPanel;
   Label enterLabel;

   DatagramPacket sendPacket, receivePacket;
   DatagramSocket sendSocket, receiveSocket;

   public Client()
   {
      super( "Client" );
      enterPanel = new Panel();
      enterLabel = new Label( "Enter message:" );
      enter = new TextField( 20 );
      enterPanel.add( enterLabel );
      enterPanel.add( enter );
      add( "North", enterPanel );
      display = new TextArea( 20, 10 );
      add( "Center", display );
      resize( 400, 300 );
      show();

      try {
         sendSocket = new DatagramSocket();
         receiveSocket = new DatagramSocket( 5001 );
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

   public boolean action( Event event, Object o )
   {
      try {
         display.appendText( "\nSending packet containing: " +
                             o.toString() + "\n" );
         String s = o.toString();
         byte data[] = new byte[ 100 ];
         s.getBytes( 0, s.length(), data, 0 );
         sendPacket = new DatagramPacket( data, s.length(),
            InetAddress.getLocalHost(), 5000 );
         sendSocket.send( sendPacket );
         display.appendText( "Packet sent\n" );
      }
      catch ( IOException exception ) {
         display.appendText( exception.toString() + "\n" );
         exception.printStackTrace();
      }

      return true;
   }

   public static void main( String args[] )
   {
      Client c = new Client();

      c.waitForPackets();
   }
}
