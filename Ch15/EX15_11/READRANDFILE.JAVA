// ReadRandFile.java 
// This program reads a random access file sequentially and
// displays the contents one record at a time in text fields.
import java.io.*;
import java.awt.*;

public class ReadRandFile extends Frame {
   private TextField part,      // displays part number
                     tName,     // displays tool name
                     quantity,  // displays quantity
                     price;     // displays price
   private Button next,         // display next record
                  done;         // quit program
   private Label partLabel,     // account label
                 tNameLabel,    // tool name label
                 qLabel,        // quantity label
                 priceLabel;    // price label

   private RandomAccessFile input;  // file from which data is read
   private Record data;
   private boolean moreRecords;
                                      
   public ReadRandFile()
   {
      super( "Read Client File" );
      moreRecords = true;

      // Open the file
      try {         
         input = new RandomAccessFile( "hardware.dat", "r" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      data = new Record();
      setup();
   }

   public void readRecord()
   {
      try {
         do {
            data.read( input );  
         } while ( input.getFilePointer() < input.length() &&
                   data.partNumber == 0 );
      }
      catch( IOException e ) {
         moreRecords = false;
      }

      if ( data.partNumber != 0 ) {
         part.setText( String.valueOf( data.partNumber ) );
         tName.setText( data.toolName );
         quantity.setText( String.valueOf( data.quantity ) );
         price.setText( String.valueOf( data.price ) );
      }
   }

   public void setup()
   {
      resize( 300, 150 );
      setLayout( new GridLayout( 5, 2 ) );

      part = new TextField( 20 );
      partLabel = new Label( "Part Number" );
      tName = new TextField( 20 );
      tNameLabel = new Label( "Tool Name" );
      quantity = new TextField( 20 );
      qLabel = new Label( "Quantity" );
      price = new TextField( 20 );
      priceLabel = new Label( "Price" );
      next = new Button( "Next" );
      done = new Button( "Done" );
   
      add( partLabel );   // add label  
      add( part );        // add TextField
      add( tNameLabel );  // add label  
      add( tName );       // add TextField
      add( qLabel );      // add label  
      add( quantity );    // add TextField
      add( priceLabel );  // add label  
      add( price );       // add TextField
      add( next );        // add button
      add( done );        // add button

      show();             // show the Frame
   }

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
  
   public boolean action( Event event, Object o )
   {
      // Determine if the next record should be displayed
      if ( event.target instanceof Button )
         if ( event.arg.equals( "Next" ) ) 
            readRecord();

      return true;
   }

   public boolean handleEvent( Event event )
   {
      if ( moreRecords == false ||
           event.id == Event.WINDOW_DESTROY ||
           event.target == done ) {
         cleanup();  // close file.

         hide();
         dispose();  
         System.exit( 0 );
         return true;
      }

      return super.handleEvent( event );
   }

   public static void main( String args[] )
   {
      ReadRandFile tools = new ReadRandFile();
   }
}


