// HardwareStore.java

// This program reads a random access file sequentially,
// updates data already written to the file, creates new
// data to be placed in the file, and deletes data
// already in the file.
import java.awt.*;
import java.io.*;

public class HardwareStore extends Frame {
   private Button updateButton, // update record
                  newButton,    // add new record
                  deleteButton, // delete record
                  done;         // quit program

   private UpdateRec update;    // dialog box for record update
   private NewRec    newRec;    // dialog box for new record
   private DeleteRec deleteRec; // dialog box for delete record

   // Application other pieces
   private RandomAccessFile file;  // file from which data is read
   private Record data;   

   public HardwareStore()
   {
      super( "Hardware Store Inventory" );

      // Open the file
      try {
         file = new RandomAccessFile( "hardware.dat", "rw" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      data = new Record();
      setup();
   }

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
         String current = ( String ) event.arg;

         if ( current.equals( "Update Record" ) ) 
            update.show();
         else if ( current.equals( "New Record" ) ) 
            newRec.show();
         else if ( current.equals( "Delete Record" ) ) 
            deleteRec.show();
      }

      return true;
   }

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
 
      return super.handleEvent( event );
   }

   public void cleanup()
   {
      try {
         file.close();
      }
      catch ( IOException e ) {         
         System.exit( 1 );
      }
   }

   public static void main( String args[] )
   { 
      HardwareStore inventory = new HardwareStore();
   }
}

class UpdateRec extends Dialog {
   private RandomAccessFile file;
   private TextField part, tName, quantity, price;
   private Label partLabel, tNameLabel, quantityLabel, priceLabel;
   private Button cancel, save;   
   private Record data;
   private int thePartNumber;

   public UpdateRec( RandomAccessFile f )
   {     
      super( new Frame(), "Update Record", true );
      resize( 300, 180 );
      setLayout( new GridLayout( 6, 2 ) );
      file = f;  

      part = new TextField( 10 );
      tName = new TextField( 10 );
      quantity = new TextField( 10 );
      price = new TextField( 10 );
      partLabel = new Label( "Part" );
      tNameLabel = new Label( "Tool name" );
      quantityLabel = new Label( "Quantity" );
      priceLabel = new Label( "Price" );  
      save = new Button( "Save Changes" );
      cancel = new Button( "Cancel" );

      add( partLabel);
      add( part );
      add( tNameLabel );
      add( tName );
      add( quantityLabel );
      add( quantity );
      add( priceLabel );
      add( price );
      add( save );
      add( cancel );

      data = new Record();
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == part )  {
         thePartNumber = Integer.parseInt( part.getText() );

         if ( thePartNumber < 1 || thePartNumber > 100 ) {
            part.setText( "Invalid part number" );
            return true;
         } 
   
         try {
            file.seek( ( thePartNumber - 1 ) * data.size() );
            data.read( file );
         }
         catch ( IOException e ) {
            part.setText( "Error reading file" );
         }
   
         if ( data.partNumber != 0 ) {
            part.setText( String.valueOf( data.partNumber ) );
            tName.setText( data.toolName );
            quantity.setText( String.valueOf( data.quantity ) );
            price.setText( String.valueOf( data.price ) );           
         }
         else
            part.setText( String.valueOf( thePartNumber ) +
                          " does not exist" );
      }
      else if ( event.target == save ) {
         try {
            file.seek( ( thePartNumber - 1 ) * data.size() );
 System.out.println( "**********************" );
            data.write( file );
         }
         catch ( IOException e ) {
            part.setText( "Error writing file" );
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
      part.setText( "" );
      tName.setText( "" );
      quantity.setText( "" );
      price.setText( "" );     
   }
}

class NewRec extends Dialog {
   private RandomAccessFile file;
   private TextField part, tName, quantity, price;
   private Label partLabel, tNameLabel, qLabel, priceLabel;
   private Button cancel, save;   
   private Record data;
   private int partNum;

   public NewRec( RandomAccessFile f )
   {     
      super( new Frame(), "New Record", true );
      resize( 300, 150 );
      setLayout( new GridLayout( 5, 2 ) );
      file = f;  

      partLabel = new Label( "Part Number" );
      part = new TextField( 10 );
      tName = new TextField( 10 );
      quantity = new TextField( 10 );
      price = new TextField( 10 );
      tNameLabel = new Label( "Tool Name" );
      qLabel = new Label( "Quantity" );
      priceLabel = new Label( "Price" );
      save = new Button( "Save Changes" );
      cancel = new Button( "Cancel" );

      add( partLabel);
      add( part );
      add( tNameLabel );
      add( tName );
      add( qLabel );
      add( quantity );
      add( priceLabel );
      add( price );
      add( save );
      add( cancel );

      data = new Record();
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == part )  {
         partNum = Integer.parseInt( part.getText() );

         if ( partNum < 1 || partNum > 100 ) {
            part.setText( "Invalid account" );
            return true;
         } 
   
         try {
            file.seek( ( partNum - 1 ) * data.size() );
            data.read( file );
         }
         catch ( IOException e ) {            
            part.setText( "Error reading file" );
         }
   
         if ( data.partNumber == 0 ) {
            tName.setText( "Enter tool name" );
            quantity.setText( "Enter quantity" );
            price.setText( "Enter price" );
         }
         else {
            part.setText( String.valueOf( data.partNumber ) +
                          " already exists" );
            tName.setText( "" );
            quantity.setText( "" );
            price.setText( "" );
         }
      }
      else if ( event.target == save ) {
         try {
            data.partNumber = partNum;
            data.toolName = tName.getText();
            data.quantity = Integer.parseInt( quantity.getText() );
            data.price = ( Double.valueOf( 
                           price.getText() ) ).doubleValue();
            file.seek( ( partNum - 1 ) * data.size() );
            data.write( file );          
         }
         catch ( IOException e ) {
            part.setText( "Error writing file" );
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
      part.setText( "" );
      tName.setText( "" );
      quantity.setText( "" );
      price.setText( "" );
   }
}

class DeleteRec extends Dialog {
   private RandomAccessFile file;
   private TextField part;
   private Label partLabel;
   private Button cancel, delete;   
   private Record data;
   private int partNum;

   public DeleteRec( RandomAccessFile f )
   {     
      super( new Frame(), "Delete Record", true );
      resize( 300, 80 );
      setLayout( new GridLayout( 2, 2 ) );
      file = f;  

      partLabel = new Label( "Part Number" );
      part = new TextField( 10 );
      delete = new Button( "Delete Record" );
      cancel = new Button( "Cancel" );

      add( partLabel);
      add( part );
      add( delete );
      add( cancel );

      data = new Record();
   }

   public boolean action( Event event, Object o )
   {
      if ( event.target == part )  {
         partNum = Integer.parseInt( part.getText() );

         if ( partNum < 1 || partNum > 100 ) {
            part.setText( "Invalid part number" );
            return true;
         } 
   
         try {
            file.seek( ( partNum - 1 ) * data.size() );
            data.read( file );
         }
         catch ( IOException e ) {
            part.setText( "Error reading file" );
         }
   
         if ( data.partNumber == 0 ) 
            part.setText( String.valueOf( partNum ) +
                          " does not exist" );
      }
      else if ( event.target == delete ) {
         try {
            file.seek( ( partNum - 1 ) * data.size() );
            data.partNumber = 0;
            data.toolName = "";
            data.quantity = 0;
            data.price = 0.0;
            data.write( file );
         }
         catch ( IOException e ) {
            part.setText( "Error writing file" );
            return true;
         }

         hide();
         part.setText( "" );
      }
      else if ( event.target == cancel ) {
         hide();
         part.setText( "" );
      }

      return true;
   }
}
