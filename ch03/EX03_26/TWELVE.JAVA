// Exercise 3.26 Solution
// Twelve.java
// Program prints the 12 days of Christmas song

public class Twelve {

   public static void main( String args[] )
   {
      String dayList[] = { "", "First", "Second", "Third",
                           "Fourth", "Fifth", "Sixth",
                           "Seventh", "Eighth", "Nineth",
                           "Tenth", "Eleventh", "Twelveth" };

      for ( int day = 1; day <= 12; day++ ) {
          System.out.print( "On the " );

          switch( day ) {
             default:
                System.out.print( dayList[ day ] );
                break;
          }

          System.out.println( " day of Christmas, my true love gave to me: " );

          switch( day ) {
             case 12:
                System.out.println( "   Twelve lords-a-leaping, " );
             case 11:
                System.out.println( "   Eleven pipers piping, " );
             case 10:
                System.out.println( "   Ten drummers drumming, " );
             case 9:
                System.out.println( "   Nine ladies dancing, " );
             case 8:
                System.out.println( "   Eight maids-a-milking, " );
             case 7:
                System.out.println( "   Seven swans-a-swimming, " );
             case 6:
                System.out.println( "   Six geese-a-laying, " );
             case 5:
                System.out.println( "   Five golden rings." );
             case 4:
                System.out.println( "   Four calling birds, " );
             case 3:
                System.out.println( "   Three French hens, " );
             case 2:
                System.out.println( "   Two turtle doves, and " );
             case 1:
                System.out.println( "   a Partridge in pear tree." );          
          }
      }
   }
}
