// Record.java
// Record class definitiion.
import java.io.*;

public class Record {
   int partNumber;
   String toolName;    
   int quantity;
   double price;

   public void read( RandomAccessFile file ) throws IOException
   {
      partNumber = file.readInt();
      byte b1[] = new byte[ 20 ];
      file.readFully( b1 );
      toolName = new String( b1, 0 );
      quantity = file.readInt();
      price = file.readDouble();
   }
  
   public void write( RandomAccessFile file ) throws IOException
   {
      file.writeInt( partNumber );

      byte b1[] = new byte[ 20 ];

      if ( toolName != null )
         toolName.getBytes( 0, toolName.length(), b1, 0 );

      file.write( b1 );
      file.writeInt( quantity );
      file.writeDouble( price );
   }

   // NOTE: This method contains a hard coded value for the
   // size of a record of information.
   public int size() { return 36; }
}
