// Exercise 16.15: Server.java
import java.net.*;
import java.io.*;

public class Server {
   ServerSocket server;
   Socket connection;
   DataInputStream input;
   DataOutputStream output;

   public static void main( String args[] )
   {
      Server s = new Server();

      s.runServer();
   }

   public Server()
   {
      try {
         server = new ServerSocket( 5000, 10 );        
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 0 );
      }
   }

   public void runServer()
   {
      while ( true ) {
         try {
            connection = server.accept();
            input = new DataInputStream( connection.getInputStream() );
            output = new DataOutputStream( connection.getOutputStream() );

            File f = new File( input.readUTF() );

            if ( f.exists() ) {
               System.out.println( f.getName() + " exists" );
               DataInputStream fileInput =
                  new DataInputStream( new FileInputStream( f ) );
               String s;

               output.writeUTF( "The file is:\n" );

               while ( ( s = fileInput.readLine() ) != null )
                  output.writeBytes( s + '\n' );

               connection.close();
            }
            else
               output.writeUTF( f.getName() + " does not exist" );
         }
         catch( IOException e ) {
            e.printStackTrace();
            System.exit( 0 );
         }
      }
   }
}
