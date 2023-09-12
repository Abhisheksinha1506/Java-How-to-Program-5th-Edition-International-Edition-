// Fig. 15.16: FileTest.java
// Demonstrating the File class.
import java.awt.*;
import java.io.*;

public class FileTest extends Frame {
   File name;
   TextField enter;
   TextArea output;

   public FileTest()
   {
      super( "Testing class File" );
      setLayout( new BorderLayout() );
      enter = new TextField(
         "Enter file or directory name here", 40 );
      output = new TextArea( 20, 30 );
      add( "North", enter );
      add( "Center", output );
      resize( 400, 400 );
      show();
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

   public boolean action( Event e, Object o )
   {
      output.setText( "" );

      name = new File( o.toString() );

      if ( name.exists() ) {
         output.appendText(
            name.getName() + " exists\n" +
            ( name.isFile() ? "is a file\n" :
                              "is not a file\n" ) +
            ( name.isDirectory() ? "is a directory\n" :
                                   "is not a directory\n" ) +
            ( name.isAbsolute() ? "is absolute path\n" :
                                  "is not absolute path\n" ) +
            "Last modified: " + name.lastModified() +
            "\nLength: " + name.length() +
            "\nPath: " + name.getPath() +
            "\nAbsolute path: " + name.getAbsolutePath() +
            "\nParent: " + name.getParent() );

         if ( name.isFile() ) {
            try {
               RandomAccessFile r =
                  new RandomAccessFile( name, "r" );

               output.appendText( "\n\n" );

               do {
                  output.appendText( r.readLine() + "\n" );
               } while( r.getFilePointer() < r.length() );
            }
            catch( IOException e2 ) {
            }
         }
         else if ( name.isDirectory() ) {
            String dir[] = name.list();

            output.appendText( "\n\nDirectory contents:\n");

            for ( int i = 0; i < dir.length; i++ )
               output.appendText( dir[ i ] + "\n" );
         }
      }
      else {
         output.appendText( o.toString() +
                            " does not exist\n" );
      }       

      return true;
   }

   public static void main( String args[] )
   {
      FileTest f = new FileTest();
   }
}
