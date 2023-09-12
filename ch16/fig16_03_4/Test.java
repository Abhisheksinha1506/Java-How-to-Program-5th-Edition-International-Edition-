import java.io.*;
import java.net.*;

public class Test {
   public static void main( String args[] ) throws UnknownHostException
   {
      InetAddress i = InetAddress.getLocalHost();
      String name = i.getHostName();
      byte address[]= i.getAddress();

      System.out.print( name + ": " );
      for ( int c = 0; c < address.length; c++ )
         System.out.print( address[ c ] );
      System.out.println();
   }
}
