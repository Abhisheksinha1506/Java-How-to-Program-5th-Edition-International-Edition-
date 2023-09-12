// Exercise 15.12 Solution
// Phone.java

// Note: phone number must be input in the form 2345678
// Only the digits 2 thru 9 are recognized.

import java.awt.*;
import java.io.*;

public class Phone extends Frame {
   private int phoneNumber[];
   private TextField input;
   private Label prompt;

   public Phone()
   {
      phoneNumber = new int[ 7 ];
      input = new TextField( 8 );
      prompt = new Label( "Enter phone number:" );
      setLayout( new FlowLayout() );
      add( prompt );
      add( input );
      resize( 200, 200 );
      show();
   }

   public boolean handleEvent( Event e )
   {
      if ( e.id == Event.WINDOW_DESTROY ) {
         hide();
         dispose();
         System.exit( 0 );
      }

      return super.handleEvent( e );
   }

   public boolean action( Event e, Object o ) 
   {      
      if ( e.target == input ) {
         String number = input.getText();
         String letters[] = { "", "", "ABC", "DEF", "GHI", "JKL",
                              "MNO", "PRS", "TUV", "WXY" };
         DataOutputStream dos = null;

         try {
            dos = new DataOutputStream( new FileOutputStream( "phone.dat" ) );
         } catch( IOException ex ) {
            System.err.println( ex.toString() );
            System.exit( 1 );
         }

         // output all possible combinations
         for (int loop1 = 0; loop1 <= 2; loop1++)
          for (int loop2 = 0; loop2 <= 2; loop2++)
           for (int loop3 = 0; loop3 <= 2; loop3++)
            for (int loop4 = 0; loop4 <= 2; loop4++)
             for (int loop5 = 0; loop5 <= 2; loop5++)
              for (int loop6 = 0; loop6 <= 2; loop6++)
               for (int loop7 = 0; loop7 <= 2; loop7++) {

                try {
                   dos.writeByte( ( byte ) letters[ ( number.charAt( 0 ) - 48 ) ].charAt( loop1 ) ); 
                   dos.writeByte( ( byte ) letters[ ( number.charAt( 1 ) - 48 ) ].charAt( loop2 ) );
                   dos.writeByte( ( byte ) letters[ ( number.charAt( 2 ) - 48 ) ].charAt( loop3 ) );
                   dos.writeByte( ( byte ) letters[ ( number.charAt( 3 ) - 48 ) ].charAt( loop4 ) );
                   dos.writeByte( ( byte ) letters[ ( number.charAt( 4 ) - 48 ) ].charAt( loop5 ) );
                   dos.writeByte( ( byte ) letters[ ( number.charAt( 5 ) - 48 ) ].charAt( loop6 ) );
                   dos.writeByte( ( byte ) letters[ ( number.charAt( 6 ) - 48 ) ].charAt( loop7 ) );
                   dos.writeByte( ( byte ) ' ' );
                } catch( IOException io ) {
                   System.err.println( e.toString() );
                   System.exit( 1 );
                }

                input.setText( "Please wait..." );
               }

         input.setText( "Done" );
      }

      return true;
   }

   public static void main( String args[] )
   {
      Phone p = new Phone();
   }
}
