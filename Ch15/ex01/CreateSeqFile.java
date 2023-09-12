// Fig. 15.4: CreateSeqFile.java
// This program uses TextFields to get information from the
// user at the keyboard and writes the information to a 
// sequential file.
import java.io.*;
import java.awt.*;

public class CreateSeqFile extends Frame {

   // Application window components
   TextField account,   // where user enters account number
             fName,     // where user enters first name
             lName,     // where user enters last name
             balance;   // where user enters balance
   Button enter,        // send record to file
          done;         // quit program
   Label acctLabel,     // account label
         fNameLabel,    // first name label
         lNameLabel,    // last name label
         balLabel;      // balance label

   // Application other pieces
   DataOutputStream output;  // enables output of data to file

   // Constructor -- intialize the Frame 
   public CreateSeqFile()
   {
      super( "Create Client File" );
   }

   public void addRecord()
   {
      int acct = 0;
      Double d;

      acct = (new Integer( account.getText() )).intValue();

      // output the values to the file
      try {
         if ( acct > 0 ) {
            output.writeInt( acct ); 
            output.writeUTF( fName.getText() );
            output.writeUTF( lName.getText() );
            d = new Double ( balance.getText() );
            output.writeDouble( d.doubleValue() );
         }
      }
      catch ( IOException e ) {
         System.err.println( "Error during write to file\n" +
                             e.toString() );
         System.exit( 1 );
      }

      // clear the TextFields
      account.setText( "" );
      fName.setText( "" );
      lName.setText( "" );
      balance.setText( "" );
   }

   // Setup the window for the application with 
   // TextFields and Buttons
   public void setup()
   {
      resize( 300, 150 );
      setLayout( new GridLayout( 5, 2 ) );

      // create the components of the Frame
      account = new TextField( 20 );
      acctLabel = new Label( "Account Number" );
      fName = new TextField( 20 );
      fNameLabel = new Label( "First Name" );
      lName = new TextField( 20 );
      lNameLabel = new Label( "Last Name" );
      balance = new TextField( 20 );
      balLabel = new Label( "Balance" );
      enter = new Button( "Enter" );
      done = new Button( "Done" );

      // add the components to the Frame
      add( acctLabel );   // add label  
      add( account );     // add TextField
      add( fNameLabel );  // add label  
      add( fName );       // add TextField
      add( lNameLabel );  // add label  
      add( lName );       // add TextField
      add( balLabel );    // add label  
      add( balance );     // add TextField
      add( enter );       // add button
      add( done );        // add button

      show();             // show the Frame

      // Open the file
      try {
         output = new DataOutputStream(
                      new FileOutputStream( "client.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      
   }

   // Cleanup--add the current information (if valid),
   // flush remaining output to file and close file.
   public void cleanup()
   {
      if ( !account.getText().equals("") )
         addRecord();

      try {
         output.flush();
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
      // User closed the window or clicked the done button--
      // be sure info is written to file and exit program
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
      CreateSeqFile accounts = new CreateSeqFile();

      accounts.setup();
   }
}


