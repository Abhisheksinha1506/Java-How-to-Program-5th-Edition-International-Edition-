// Fig. 15.12: WriteRandFile.java
// This program uses TextFields to get information from the
// user at the keyboard and writes the information to a
// random access file.
import java.io.*;
import java.awt.*;

public class WriteRandFile extends Frame {

   // Application window components
   TextField acct,      // where user enters account number
             fName,     // where user enters first name
             lName,     // where user enters last name
             bal;       // where user enters balance
   Button enter,        // send record to file
          done;         // quit program
   Label acctLabel,     // account label
         fNameLabel,    // first name label
         lNameLabel,    // last name label
         balLabel;      // balance label

   // Application other pieces
   RandomAccessFile output;  // file for output
   Record data;

   // Constructor -- intialize the Frame 
   public WriteRandFile()
   {
      super( "Write to random access file" );

      data = new Record();

      // Open the file
      try {
         output = new RandomAccessFile( "credit.dat", "rw" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      setup();
   }

   public void addRecord()
   {
      int acctNum = 0;
      Double d;

      acctNum = ( new Integer( acct.getText() ) ).intValue();

      // output the values to the file
      try {
         if ( acctNum > 0 && acctNum <= 100 ) {
            data.account = acctNum;
            data.firstName = fName.getText();
            data.lastName = lName.getText();
            d = new Double ( bal.getText() );
            data.balance = d.doubleValue();
            output.seek( (long) ( acctNum-1 ) * data.size() );
            data.write( output );

            // clear the TextFields
            acct.setText( "" );
            fName.setText( "" );
            lName.setText( "" );
            bal.setText( "" );
         }
         else {
            acct.setText( "Enter valid account (1-100)" );
            acct.selectAll();
         }
      }
      catch ( IOException e ) {
         System.err.println( "Error during write to file\n" +
                             e.toString() );
         System.exit( 1 );
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
      enter = new Button( "Enter" );
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
      add( enter );       // add button
      add( done );        // add button

      show();             // show the Frame
   }

   // Cleanup--add the current information (if valid),
   // flush remaining output to file and close file.
   public void cleanup()
   {
      if ( !acct.getText().equals("") )
         addRecord();

      try {
         output.close();
      }
      catch ( IOException e ) {
         System.err.println( "File not closed properly\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   // Process the event when the user closes the window
   // or presses the "Done" button
   public boolean handleEvent( Event event )
   {
      // User closed the window or clicked Done button
      if ( event.id == Event.WINDOW_DESTROY ||
           event.target == done ) {
         cleanup();  // write data, close file, etc.

         hide();
         dispose();  // release system resources
         System.exit( 0 );
         return true;
      }

      // User clicked Enter button to send record to file
      if ( event.target instanceof Button ) {
         if ( event.arg.equals( "Enter" ) ) {
            addRecord();
            return true;
         }
      }

      return super.handleEvent( event );
   }

   // Instantiate a CreateSeqFile object and start the program
   public static void main( String args[] )
   {
      WriteRandFile accounts = new WriteRandFile();
   }
}


