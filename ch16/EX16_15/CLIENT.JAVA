// Exercise 16.15: Client.java
import java.awt.*;
import java.net.*;
import java.io.*;
import java.applet.Applet;

public class Client extends Applet {
   private TextField fileName;
   private TextArea contents;
   private DataInputStream dataInput;
   private DataOutputStream dataOutput;
   private Socket connection;

   public void init()
   {
      fileName = new TextField( "Enter file name to retrieve here" );
      fileName.selectAll();
      contents = new TextArea();
      setLayout( new BorderLayout() );
      add( "North", fileName );
      add( "Center", contents );

      try {
         connection = new Socket( InetAddress.getLocalHost(), 5000 );  
         dataInput = new DataInputStream( connection.getInputStream() );       
         dataOutput = new DataOutputStream( connection.getOutputStream() );       
      }
      catch( IOException ex ) {
         ex.printStackTrace();
      }
   }

   public boolean action( Event e, Object o )
   {
      try {
         dataOutput.writeUTF( o.toString() );

         String s = dataInput.readUTF();
         contents.setText( s );
 
         if ( s.equals( "The file is:\n" ) ) {
            int b;

            b = dataInput.readByte();

            while ( true ) {
               contents.appendText( String.valueOf( (char) b ) );
               b = dataInput.readByte();
            }
         }
      }
      catch ( EOFException eof ) {
      }
      catch ( IOException ex ) {
         ex.printStackTrace();
      }

      return true;
   }
}

