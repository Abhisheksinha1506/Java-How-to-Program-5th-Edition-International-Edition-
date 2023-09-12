// Fig. 15.6: ReadSeqFile.java
// This program reads a file sequentially and displays each
// record in text fields.
import java.io.*;
import java.awt.*;

public class ReadSeqFile extends Frame {

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
   DataInputStream input;  // file from which data is read
   boolean moreRecords = true;

   // Constructor -- intialize the Frame
   public ReadSeqFile()
   {
      super( "Read Client File" );
   }

   public void readRecord()
   {
      int account;
      String first, last;
      double balance;

      // input the values from the file
      try {
         account = input.readInt();
         first = input.readUTF();
         last = input.readUTF();
         balance = input.readDouble();

         acct.setText( String.valueOf( account ) );
         fName.setText( String.valueOf( first ) );
         lName.setText( String.valueOf( last ) );
         bal.setText( String.valueOf( balance ) );
      }
      catch ( EOFException eof ) {
         moreRecords = false;
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   // Setup the window for the application with TextFields
   // and Buttons
   public void setup()
   {

      // Open the file
      try {
         input = new DataInputStream(
                     new FileInputStream( "client.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

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

   // Cleanup--close the input file.
   public void cleanup()
   {
      try {
         input.close();
      }
      catch ( IOException e ) {
         System.err.println( "File not closed properly\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target instanceof Button )
         if ( event.arg.equals( "Next" ) )
            readRecord();

      return true;
   }

   // Process the event when the user closes the window
   // or presses the "Done" button
   public boolean handleEvent( Event event )
   {
      // End of file reached, user closed window, or
      // user clicked the Done button.
      if ( moreRecords == false ||
           event.id == Event.WINDOW_DESTROY ||
           event.target == done ) {
         cleanup();  // close file

         hide();
         dispose();  // release system resources
         System.exit( 0 );
         return true;
      }

      // May need to process event still
      return super.handleEvent( event );
   }

   // Instantiate a ReadSeqFile object and start the program
   public static void main( String args[] )
   {
      ReadSeqFile accounts = new ReadSeqFile();

      accounts.setup();
   }
}


