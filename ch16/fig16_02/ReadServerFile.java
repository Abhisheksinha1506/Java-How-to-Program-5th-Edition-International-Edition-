// Fig. 16.2: ReadServerFile.java
// This program uses a URL connection to read a file
// on the server.
import java.awt.*;
import java.net.*;
import java.io.*;
import java.applet.Applet;

public class ReadServerFile extends Applet {
   URL fileURL;
   TextArea contents;
   InputStream input;
   DataInputStream dataInput;

   public void init()
   {
      contents = new TextArea( "Please wait...", 10, 40 );
      add( contents );

      try {
         fileURL = new URL(
            "http://www.deitel.com/test/test.txt" );
      }
      catch ( MalformedURLException e ) {
         showStatus( "Exception: " + e.toString() );
      }
   }

   public void start()
   {
      String text;

      try {
         input = fileURL.openStream();
         dataInput = new DataInputStream( input );
         contents.setText( "The file contents are:\n" );

         while ( ( text = dataInput.readLine() ) != null ) 
            contents.appendText( text + "\n" );

         dataInput.close();
      }
      catch ( IOException e ) {
         showStatus( "Exception: " + e.toString() );
      }
   }
}

