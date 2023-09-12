// Fig. 15.13: ReadRandFile.java 
// This program reads a random access file sequentially and
// displays the contents one record at a time in text fields.
import java.io.*;
import java.awt.*;

public class ReadRandFile extends Frame {

   // Application window components
   TextField acct,      // displays account number
             fName,     // displays first name
             lName,     // displays last name
             bal;       // displays balance
   Button next,         // display next record
          done;         // quit program
   Label acctLabel,     // account label
         fNameLabel,    // first name label
         lNameLabel,    // last name label
         balLabel;      // balance label

   // Application other pieces
   RandomAccessFile input;  // file from which data is read
   Record data;
   boolean moreRecords = true;

   // Constructor -- intialize the Frame
   public ReadRandFile()
   {
      super( "Read Client File" );

      // Open the file
      try {
         input = new RandomAccessFile( "credit.dat", "r" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      data = new Record();

      setup();
   }

   // Read a record and display it on the screen
   public void readRecord()
   {
      // read a record and display
      try {
         do {
            data.read( input );
         } while ( input.getFilePointer() < input.length() &&
                   data.account == 0 );
      }
      catch( IOException e ) {
         moreRecords = false;
      }

      if ( data.account != 0 ) {
         acct.setText( String.valueOf( data.account ) );
         fName.setText( data.firstName );
         lName.setText( data.lastName );
         bal.setText( String.valueOf( data.balance ) );
      }
   }

   // Setup the window for the application with TextFields
   // and Buttons
   public void setup()
   {
      resize( 300, 150 );
      setLayout( new GridLayout( 5, 2 ) );

      // create the components of the Frame
      acct = new TextField( 20 );
      acctLabel = new Label( "Account Number" );
      fName = new TextField( 20 );
      fNameLabel = new Label( "First Name" );
      lName = new TextField( 20 );
      lNameLabel = new Label( "Last Name" );
      bal = new TextField( 20 );
      balLabel = new Label( "Balance" );
      next = new Button( "Next" );
      done = new Button( "Done" );

      // add the components to the Frame
      add( acctLabel );   // add label  
      add( acct );        // add TextField
      add( fNameLabel );  // add label  
      add( fName );       // add TextField
      add( lNameLabel );  // add label  
      add( lName );       // add TextField
      add( balLabel );    // add label  
      add( bal );         // add TextField
      add( next );        // add button
      add( done );        // add button

      show();             // show the Frame
   }

   // Cleanup--close the file.
   public void cleanup()
   {
      try {
         input.close();
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }
   }

   // Process the Next button
   public boolean action( Event event, Object o )
   {
      // Determine if the next record should be displayed
      if ( event.target instanceof Button )
         if ( event.arg.equals( "Next" ) ) 
            readRecord();

      return true;
   }

   // Process the event when the user closes the window
   // or presses the done button
   public boolean handleEvent( Event event )
   {
      // User closed the window or clicked Done
      if ( moreRecords == false ||
           event.id == Event.WINDOW_DESTROY ||
           event.target == done ) {
         cleanup();  // close file.

         hide();
         dispose();  // release system resources
         System.exit( 0 );
         return true;
      }

      return super.handleEvent( event );
   }

   // Instantiate a ReadSeqFile object and start the program
   public static void main( String args[] )
   {
      ReadRandFile accounts = new ReadRandFile();
   }
}


