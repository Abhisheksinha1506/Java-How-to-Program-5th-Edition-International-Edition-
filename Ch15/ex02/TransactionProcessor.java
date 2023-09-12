// Fig. 15_14: TransactionProcessor.java
// Transaction processing program using RandomAccessFiles.

// This program reads a random access file sequentially,
// updates data already written to the file, creates new
// data to be placed in the file, and deletes data
// already in the file.
import java.awt.*;
import java.io.*;

public class TransactionProcessor extends Frame {
   
   // Application window components
   Button updateButton, // update record
          newButton,    // add new record
          deleteButton, // delete record
          done;         // quit program

   UpdateRec update;    // dialog box for record update
   NewRec    newRec;    // dialog box for new record
   DeleteRec deleteRec; // dialog box for delete record

   // Application other pieces
   RandomAccessFile file;  // file from which data is read
   Record data;   

   // Constructor -- intialize the Frame
   public TransactionProcessor()
   {
      super( "Transaction Processor" );

      // Open the file
      try {
         file = new RandomAccessFile( "credit.dat", "rw" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      data = new Record();

      setup();
   }

   // Setup the window for the application with TextFields
   // and Buttons
   public void setup()
   {
      resize( 300, 80 );
      setLayout( new GridLayout( 2, 2 ) );
      
      updateButton = new Button( "Update Record" );
      newButton = new Button( "New Record" );
      deleteButton = new Button( "Delete Record" );
      done = new Button( "Done" );

      add( updateButton );
      add( newButton );
      add( deleteButton );
      add( done );

      show();             // show the Frame

      // Create dialog boxes
      update = new UpdateRec( file );
      newRec = new NewRec( file );
      deleteRec = new DeleteRec( file );      
   }

   // Process actions
   public boolean action( Event event, Object o )
   {
      if ( event.target instanceof Button ) {
         String current = (String) event.arg;

         if ( current.equals( "Update Record" ) ) 
            update.show();
         else if ( current.equals( "New Record" ) ) 
            newRec.show();
         else if ( current.equals( "Delete Record" ) ) 
            deleteRec.show();
      }

      return true;
   }

   // Process the event when the user closes the window
   // or presses the "Done" button
   public boolean handleEvent( Event event )
   {
      // User closed the window or clicked Done
      if ( event.id == Event.WINDOW_DESTROY ||
           event.target == done ) {
         cleanup();  

         hide();
         dispose();  // release system resources
         System.exit( 0 );
         return true;
      }

      // May need to process other events in action
      return super.handleEvent( event );
   }

   public void cleanup()
   {
      try {
         file.close();
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }
   }

   public static void main( String args[] )
   { 
      TransactionProcessor teller = new TransactionProcessor();
   }
}

class UpdateRec extends Dialog {
   RandomAccessFile file;
   TextField acct,
             fName,
             lName,
             bal,
             transaction;
   Label acctLabel,
         fNameLabel,
         lNameLabel,
         balLabel,
         transLabel;
   Button cancel,
          save;
   
   Record data;
   int account;

   public UpdateRec( RandomAccessFile f )
   {     
      super( new Frame(), "Update Record", true );
      resize( 300, 180 );
      setLayout( new GridLayout( 6, 2 ) );
      file = f;  

      acct = new TextField( 10 );
      fName = new TextField( 10 );
      lName = new TextField( 10 );
      bal = new TextField( 10 );
      transaction = new TextField( 10 );
      acctLabel = new Label( "Account" );
      fNameLabel = new Label( "First name" );
      lNameLabel = new Label( "Last name" );
      balLabel = new Label( "Balance" );
      transLabel = new Label( "Transaction amount" );
      save = new Button( "Save Changes" );
      cancel = new Button( "Cancel" );

      add( acctLabel);
      add( acct );
      add( fNameLabel );
      add( fName );
      add( lNameLabel );
      add( lName );
      add( balLabel );
      add( bal );
      add( transLabel );
      add( transaction );
      add( save );
      add( cancel );

      data = new Record();
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == acct )  {
         account = Integer.parseInt( acct.getText() );

         if ( account < 1 || account > 100 ) {
            acct.setText( "Invalid account" );
            return true;
         } 
   
         try {
            file.seek( ( account - 1 ) * data.size() );
            data.read( file );
         }
         catch ( IOException e ) {
            acct.setText( "Error reading file" );
         }
   
         if ( data.account != 0 ) {
            acct.setText( String.valueOf( data.account ) );
            fName.setText( data.firstName );
            lName.setText( data.lastName );
            bal.setText( String.valueOf( data.balance ) );
            transaction.setText( "charge(+) or payment(-)" );
         }
         else
            acct.setText( String.valueOf( account ) +
                          " does not exist" );
      }
      else if ( event.target == save ) {
         try {
            file.seek( ( account - 1 ) * data.size() );
            data.write( file );
         }
         catch ( IOException e ) {
            acct.setText( "Error writing file" );
            return true;
         }

         hide();
         clear();
      }
      else if ( event.target == cancel ) {
         hide();
         clear();
      }
      else if ( event.target == transaction ) {   
         Double trans = 
                   Double.valueOf( transaction.getText() );
         data.balance += trans.doubleValue();
         bal.setText( String.valueOf( data.balance ) );
      }

      return true;
   }

   private void clear() 
   {
      acct.setText( "" );
      fName.setText( "" );
      lName.setText( "" );
      bal.setText( "" );
      transaction.setText( "" );
   }
}

class NewRec extends Dialog {
   RandomAccessFile file;
   TextField acct,
             fName,
             lName,
             bal;
   Label acctLabel,
         fNameLabel,
         lNameLabel,
         balLabel;
   Button cancel,
          save;
   
   Record data;
   int account;

   public NewRec( RandomAccessFile f )
   {     
      super( new Frame(), "New Record", true );
      resize( 300, 150 );
      setLayout( new GridLayout( 5, 2 ) );
      file = f;  

      acctLabel = new Label( "Account" );
      acct = new TextField( 10 );
      fName = new TextField( 10 );
      lName = new TextField( 10 );
      bal = new TextField( 10 );
      fNameLabel = new Label( "First name" );
      lNameLabel = new Label( "Last name" );
      balLabel = new Label( "Balance" );
      save = new Button( "Save Changes" );
      cancel = new Button( "Cancel" );

      add( acctLabel);
      add( acct );
      add( fNameLabel );
      add( fName );
      add( lNameLabel );
      add( lName );
      add( balLabel );
      add( bal );
      add( save );
      add( cancel );

      data = new Record();
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == acct )  {
         account = Integer.parseInt( acct.getText() );

         if ( account < 1 || account > 100 ) {
            acct.setText( "Invalid account" );
            return true;
         } 
   
         try {
            file.seek( ( account - 1 ) * data.size() );
            data.read( file );
         }
         catch ( IOException e ) {
            acct.setText( "Error reading file" );
         }
   
         if ( data.account == 0 ) {
            fName.setText( "Enter first name" );
            lName.setText( "Enter last name" );
            bal.setText( "Enter balance" );
         }
         else {
            acct.setText( String.valueOf( data.account ) +
                          " already exists" );
            fName.setText( "" );
            lName.setText( "" );
            bal.setText( "" );
         }
      }
      else if ( event.target == save ) {
         try {
            data.account = account;
            data.lastName = lName.getText();
            data.firstName = fName.getText();
            data.balance = ( Double.valueOf( 
                               bal.getText() ) ).doubleValue();
            file.seek( ( account - 1 ) * data.size() );
            data.write( file );
         }
         catch ( IOException e ) {
            acct.setText( "Error writing file" );
            return true;
         }

         hide();
         clear();
      }
      else if ( event.target == cancel ) {
         hide();
         clear();
      }

      return true;
   }

   private void clear() 
   {
      acct.setText( "" );
      fName.setText( "" );
      lName.setText( "" );
      bal.setText( "" );
   }
}

class DeleteRec extends Dialog {
   RandomAccessFile file;
   TextField acct;
   Label acctLabel;
   Button cancel,
          delete;
   
   Record data;
   int account;

   public DeleteRec( RandomAccessFile f )
   {     
      super( new Frame(), "Delete Record", true );
      resize( 300, 80 );
      setLayout( new GridLayout( 2, 2 ) );
      file = f;  

      acctLabel = new Label( "Account" );
      acct = new TextField( 10 );
      delete = new Button( "Delete Record" );
      cancel = new Button( "Cancel" );

      add( acctLabel);
      add( acct );
      add( delete );
      add( cancel );

      data = new Record();
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == acct )  {
         account = Integer.parseInt( acct.getText() );

         if ( account < 1 || account > 100 ) {
            acct.setText( "Invalid account" );
            return true;
         } 
   
         try {
            file.seek( ( account - 1 ) * data.size() );
            data.read( file );
         }
         catch ( IOException e ) {
            acct.setText( "Error reading file" );
         }
   
         if ( data.account == 0 ) 
            acct.setText( String.valueOf( account ) +
                          " does not exist" );
      }
      else if ( event.target == delete ) {
         try {
            file.seek( ( account - 1 ) * data.size() );
            data.account = 0;
            data.firstName = "";
            data.lastName = "";
            data.balance = 0.0;
            data.write( file );
         }
         catch ( IOException e ) {
            acct.setText( "Error writing file" );
            return true;
         }

         hide();
         acct.setText( "" );
      }
      else if ( event.target == cancel ) {
         hide();
         acct.setText( "" );
      }

      return true;
   }
}
