// Fig. 15.10: Record.java
// Record class for the RandomAccessFile programs.
import java.io.*;

public class Record {
   int account;
   String lastName;
   String firstName;
   double balance;

   // Read a record from the specified RandomAccessFile
   public void read( RandomAccessFile file ) throws IOException
   {
      account = file.readInt();
      byte b1[] = new byte[ 15 ];
      file.readFully( b1 );
      firstName = new String( b1, 0 );
      byte b2[] = new byte[ 15 ];
      file.readFully( b2 );
      lastName = new String( b2, 0 );
      balance = file.readDouble();
   }

   // Write a record to the specified RandomAccessFile
   public void write( RandomAccessFile file ) throws IOException
   {
      file.writeInt( account );

      byte b1[] = new byte[ 15 ];

      if ( firstName != null )
         firstName.getBytes( 0, firstName.length(), b1, 0 );

      file.write( b1 );

      byte b2[] = new byte[ 15 ];

      if ( lastName != null )
         lastName.getBytes( 0, lastName.length(), b2, 0 );

      file.write( b2 );
      file.writeDouble( balance );
   }

   // NOTE: This method contains a hard coded value for the
   // size of a record of information.
   public int size() { return 42; }
}
