// WriteRandFile.java
// This program uses TextFields to get information from the
// user at the keyboard and writes the information to a
// random access file.
import java.io.*;
import java.awt.*;

public class WriteRandFile extends Frame {
   private TextField part,      // where user enters part number
                     tName,     // where user enters tool name
                     quantity,  // where user enters quantity
                     price;     // where user enters price
   private Button enter,        // send record to file
                  done;         // quit program
   private Label partLabel,     // part label
                 tNameLabel,    // tool name label
                 qLabel,        // quantity label
                 priceLabel;    // price label   
   private RandomAccessFile output;  // file for output
   private Record data;

   public WriteRandFile()
   {
      super( "Write to random access file" );
      data = new Record();
   
      try {
         output = new RandomAccessFile( "hardware.dat", "rw" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      setup();
   }

   public void addRecord()
   {
      int partNum = 0;
      Double d;

      partNum = ( new Integer( part.getText() ) ).intValue();
     
      try {
         if ( partNum > 0 && partNum <= 100 ) {
            data.partNumber = partNum;
            data.toolName = tName.getText();
            data.quantity = Integer.parseInt( quantity.getText() );
            d = new Double ( price.getText() );
            data.price = d.doubleValue();
            output.seek( ( long ) ( partNum - 1 ) * data.size() );
            data.write( output );
        
            part.setText( "" );
            tName.setText( "" );
            quantity.setText( "" );
            price.setText( "" );
         }
         else {
            price.setText( "Enter valid part number (1-100)" );
            part.selectAll();
         }
      }
      catch ( IOException e ) {
         System.err.println( "Error during write to file\n" +
                             e.toString() );
         System.exit( 1 );
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
      enter = new Button( "Enter" );
      done = new Button( "Done" );
   
      add( partLabel );   // add label  
      add( part );        // add TextField
      add( tNameLabel );  // add label  
      add( tName );       // add TextField
      add( qLabel );      // add label  
      add( quantity );    // add TextField
      add( priceLabel );  // add label  
      add( price );       // add TextField
      add( enter );       // add button
      add( done );        // add button

      show();             // show the Frame
   }

   public void cleanup()
   {
      if ( !part.getText().equals("") )
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

   public static void main( String args[] )
   {
      WriteRandFile toolBox = new WriteRandFile();
   }
}


