// Fig. 15.7: CreditInquiry.java
// This program reads a file sequentially and displays the
// contents in a text area based on the type of account the
// user requests (credit balance, debit balance or zero balance.
import java.io.*;
import java.awt.*;

public class CreditInquiry extends Frame {

   // Application window components
   TextArea recordDisplay;    // where records are displayed
   Button done;               // quit program
   Button credit,             // account type to display
          debit,              // account type to display
          zero;               // account type to display
   Panel buttonPanel;         // panel for buttons
   String accountType;        // Account type to display

   // Application other pieces
   File file;
   DataInputStream input;  // file from which data is read

   // Constructor -- intialize the Frame
   public CreditInquiry()
   {
      super( "Credit Inquiry Program" );
   }

   public void readRecords()
   {
      int acct;
      String first, last;
      double bal;

      // input the values from the file
      try {         
         recordDisplay.setText( accountType + ":\n" ); 

         while ( true ) {
            acct = input.readInt();
            first = input.readUTF();
            last = input.readUTF();
            bal = input.readDouble();

            if ( shouldDisplay( bal ) )
               recordDisplay.appendText( acct + 
                  "\t" + first + "\t" + last +
                  "\t" + bal + "\n" );
         }
      }
      catch ( EOFException eof ) {
         // do nothing on EOF exception
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   public boolean shouldDisplay( double balance )
   {
      if ( accountType.equals( "Credit balances" ) &&
           balance < 0 )
         return true;

      if ( accountType.equals( "Debit balances" ) &&
           balance > 0 )
         return true;

      if ( accountType.equals( "Zero balances" ) &&
           balance == 0 )
         return true;

      return false;
   }

   // Setup the window for the application with TextArea
   // and Buttons
   public void setup()
   {
      resize( 400, 150 );

      // create the components of the Frame
      recordDisplay = new TextArea( 4, 40 );
      buttonPanel = new Panel();
      done = new Button( "Done" );
      credit = new Button( "Credit balances" );
      debit = new Button( "Debit balances" );
      zero = new Button( "Zero balances" );
      buttonPanel.add( credit );
      buttonPanel.add( debit );
      buttonPanel.add( zero );
      buttonPanel.add( done );

      // add the components to the Frame
      add( "Center", recordDisplay );     // add TextArea
      add( "South", buttonPanel );        // add Button

      show();                   // show the Frame
   }

   // Process the event when the user closes the window
   // or presses the "Done" button
   public boolean handleEvent( Event event )
   {
      // User closed the window or clicked the Done button
      // Clean up window and exit program
      if ( event.id == Event.WINDOW_DESTROY ||
           event.target == done ) {
         hide();
         dispose();  // release system resources
         System.exit( 0 );
         return true;
      }

      // User selected type of account to display
      if ( event.target instanceof Button ) {
         accountType = event.arg.toString();

         // Open the file
         try {
            input = new DataInputStream(
                       new FileInputStream( "client.dat" ) );
         }
         catch ( IOException e ) {
            System.err.println( e.toString() );
            System.exit( 1 );
         }

         readRecords();

         // Close the file
         try {
            input.close();
         }
         catch ( IOException e ) {
            System.err.println( "File not closed properly\n" +
                                e.toString() );
            System.exit( 1 );
         }
      }
         
      return super.handleEvent( event );
   }

   // Instantiate a CreditInquiry object and start the program
   public static void main( String args[] )
   {
      CreditInquiry accounts = new CreditInquiry();

      accounts.setup();
      accounts.show();
   }
}


